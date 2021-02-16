package io.electrum.moneytransfer.api;

import static io.electrum.moneytransfer.util.ValidationUtil.CURRENCY_REGEX;
import static io.electrum.moneytransfer.util.ValidationUtil.ID_COUNTRY_CODE_REGEX;
import static io.electrum.moneytransfer.util.ValidationUtil.MERCHANT_ID_REGEX;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.moneytransfer.model.ErrorDetail;
import io.electrum.moneytransfer.model.IdType;
import io.electrum.moneytransfer.model.MoneyTransferAdminMessage;
import io.electrum.moneytransfer.model.MoneyTransferCustomerOrderHistory;
import io.electrum.moneytransfer.model.MoneyTransferFeeQuote;
import io.electrum.moneytransfer.model.MoneyTransferQuoteRequest;
import io.electrum.vas.model.ExchangeRate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(AdminResource.PATH)

@Api(description = "the admin API")
public abstract class AdminResource {

   protected abstract IAdminResource getResourceImplementation();

   public static final String PATH = "/admin";

   public class GetCustomerInfo {
      public static final String RELATIVE_PATH = "/customers";
      public static final String FULL_PATH = AdminResource.PATH + RELATIVE_PATH;
      public static final String GET_CUSTOMER_INFO = "getCustomerInfo";
      public static final int SUCCESS = 200;

      public class QueryParameters {
         public static final String ID_NUMBER = "idNumber";
         public static final String ID_TYPE = "idType";
         public static final String ID_COUNTRY_CODE = "idCountryCode";
         public static final String MERCHANT_ID = "merchantId";
         public static final String ORIGINATOR_INST_ID = "originatorInstId";
         public static final String RECEIVER_ID = "receiverId";
      }
   }

   public class CreateOrUpdateCustomer {
      public static final String RELATIVE_PATH = "/customers";
      public static final String FULL_PATH = AdminResource.PATH + RELATIVE_PATH;
      public static final String CREATE_OR_UPDATE_CUSTOMER = "createOrUpdateCustomer";
      public static final int SUCCESS = 201;
   }

   public class GetFeeQuote {
      public static final String RELATIVE_PATH = "/fees";
      public static final String FULL_PATH = AdminResource.PATH + RELATIVE_PATH;
      public static final String GET_FEE_QUOTE = "getFeeQuote";
      public static final int SUCCESS = 200;

      public class QueryParameters {
         public static final String AMOUNT = "amount";
         public static final String AMOUNT_INCLUDES_FEE = "amountIncludesFee";
         public static final String ID_NUMBER = "idNumber";
         public static final String MERCHANT_ID = "merchantId";
         public static final String ORIGINATOR_INST_ID = "originatorInstId";
         public static final String RECEIVER_ID = "receiverId";
         public static final String SENDER_CELL = "senderCell";
         public static final String RECIPIENT_CELL = "recipientCell";
      }
   }

   public class GetExchangeRate {
      public static final String RELATIVE_PATH = "/exchangerate";
      public static final String FULL_PATH = AdminResource.PATH + RELATIVE_PATH;
      public static final String GET_EXCHANGE_RATE = "getExchangeRate";
      public static final int SUCCESS = 200;

      public class QueryParameters {
         public static final String FROM_CURRENCY = "fromCurrency";
         public static final String TO_CURRENCY = "toCurrency";
         public static final String RECEIVER_ID = "receiverId";
         public static final String SETTLEMENT_ENTITY_ID = "settlementEntity";
      }
   }

   public class LookupOrders {
      private LookupOrders(){}

      public static final String RELATIVE_PATH = "/customers/orders";
      public static final String FULL_PATH = AdminResource.PATH + RELATIVE_PATH;
      public static final String LOOKUP_ORDERS = "getCustomerOrderHistory";
      public static final int SUCCESS = 200;

      public class QueryParameters {
         private QueryParameters(){}

         public static final String CUSTOMER_PROFILE_ID = "customerProfileId";
         public static final String RECEIVER_ID = "receiverId";
         public static final String MERCHANT_ID = "merchantId";
         public static final String ORIGINATOR_INST_ID = "originatorInstId";
         public static final String FROM_DATE_TIME = "fromDateTime";
         public static final String TO_DATE_TIME = "toDateTime";
         public static final String STATUS = "status";
         public static final String PAYMENT_TYPE = "paymentType";
         public static final String PAYMENT_IDENTIFIER_NAME = "paymentIdentifierName";
         public static final String PAYMENT_IDENTIFIER_VALUE = "paymentIdentifierValue";
         public static final String LIMIT = "limit";
         public static final String OFFSET = "offset";
      }
   }

   @POST
   @Path(CreateOrUpdateCustomer.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = CreateOrUpdateCustomer.CREATE_OR_UPDATE_CUSTOMER, notes = "Request to create a new or update an existing customer "
         + "profile on the service provider's system.", response = MoneyTransferAdminMessage.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = CreateOrUpdateCustomer.SUCCESS, message = "Created", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void createOrUpdateCustomer(
         @ApiParam(value = "A message containing the data required to carry out the admin "
               + "request, as well as information about the point-of-sale from which the "
               + "transaction originates.", required = true) @Valid MoneyTransferAdminMessage body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().createOrUpdateCustomer(
            body,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @GET
   @Path(GetCustomerInfo.RELATIVE_PATH)
   @Produces({ "application/json" })
   @ApiOperation(value = GetCustomerInfo.GET_CUSTOMER_INFO, notes = "Returns information of the customer's profile as "
         + "registered on the service provider's system.", response = MoneyTransferAdminMessage.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = GetCustomerInfo.SUCCESS, message = "OK", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void getCustomerInfo(
         @ApiParam(value = "Customer's identification number as per presented identification document.", required = true) @QueryParam(GetCustomerInfo.QueryParameters.ID_NUMBER) @NotNull String idNumber,
         @ApiParam(value = "Type of presented identification document.") @QueryParam(GetCustomerInfo.QueryParameters.ID_TYPE) IdType idType,
         @ApiParam(value = "Country of issue of presented identification document, expressed as an ISO 3166-1 Alpha-2 country code.") @QueryParam(GetCustomerInfo.QueryParameters.ID_COUNTRY_CODE) @Pattern(regexp = ID_COUNTRY_CODE_REGEX) String idCountryCode,
         @ApiParam(value = "The assigned merchant identifier. Also known as card acceptor id.") @QueryParam(GetCustomerInfo.QueryParameters.MERCHANT_ID) @Pattern(regexp = MERCHANT_ID_REGEX) String merchantId,
         @ApiParam(value = "Identifies the institution from which the transaction originates. Value to be assigned by Electrum.") @QueryParam(GetCustomerInfo.QueryParameters.ORIGINATOR_INST_ID) String originatorInstId,
         @ApiParam(value = "Identifies the service provider to whom this request must be directed.", required = true) @QueryParam(GetCustomerInfo.QueryParameters.RECEIVER_ID) @NotNull String receiverId,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().getCustomerInfo(
            idNumber,
            idType,
            idCountryCode,
            merchantId,
            originatorInstId,
            receiverId,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @GET
   @Path(GetFeeQuote.RELATIVE_PATH)
   @Produces({ "application/json" })
   @ApiOperation(value = GetFeeQuote.GET_FEE_QUOTE, notes = "Returns the fee that will be charged to the customer for the transfer.", response = MoneyTransferFeeQuote.class, authorizations = {
         @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = GetFeeQuote.SUCCESS, message = "OK", response = MoneyTransferFeeQuote.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void getFeeQuote(
         @ApiParam(value = "The amount the customer wishes to transfer.", required = true) @QueryParam(GetFeeQuote.QueryParameters.AMOUNT) @NotNull @Min(0) Long amount,

         @ApiParam(value = "Whether or not the amount is inclusive of the fee.", required = true) @QueryParam(GetFeeQuote.QueryParameters.AMOUNT_INCLUDES_FEE) @NotNull Boolean amountIncludesFee,

         @ApiParam(value = "National identity number of the customer.") @QueryParam(GetFeeQuote.QueryParameters.ID_NUMBER) String idNumber,

         @ApiParam(value = "The assigned merchant identifier. Also known as card acceptor ID.") @QueryParam(GetFeeQuote.QueryParameters.MERCHANT_ID) @Pattern(regexp = MERCHANT_ID_REGEX) String merchantId,

         @ApiParam(value = "Identifies the institution from which the transaction originates. Value to be assigned by Electrum.", required = true) @QueryParam(GetFeeQuote.QueryParameters.ORIGINATOR_INST_ID) @NotNull String originatorInstId,

         @ApiParam(value = "Identifies the service provider to whom this request must be directed.", required = true) @QueryParam(GetFeeQuote.QueryParameters.RECEIVER_ID) @NotNull String receiverId,

         @ApiParam(value = "The cellphone number of the sender of the funds. This field is required by some providers. This must conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en) e.g. 27821234567 for a South Africa number.") @QueryParam(GetFeeQuote.QueryParameters.SENDER_CELL) String senderCell,

         @ApiParam(value = "The cellphone number of the recipient of the funds. This field is required by some providers. This must conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en) e.g. 27821234567 for a South Africa number.") @QueryParam(GetFeeQuote.QueryParameters.RECIPIENT_CELL) String recipientCell,

         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().getFeeQuote(
            amount,
            amountIncludesFee,
            idNumber,
            merchantId,
            originatorInstId,
            receiverId,
            senderCell,
            recipientCell,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @POST
   @Path(GetFeeQuote.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = GetFeeQuote.GET_FEE_QUOTE, notes = "Returns the fee that will be charged to the customer for the transfer.", response = MoneyTransferFeeQuote.class, authorizations = {
         @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = GetFeeQuote.SUCCESS, message = "OK", response = MoneyTransferFeeQuote.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void getFeeQuote(
         @ApiParam(value = "Details necessary to provide a quote.") @Valid MoneyTransferQuoteRequest body,

         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .getFeeQuote(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @Deprecated
   public final void getExchangeRate(
         @NotNull String fromCurrency,
         @NotNull String toCurrency,
         String receiverId,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().getExchangeRate(
            fromCurrency,
            toCurrency,
            receiverId,
            null,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @GET
   @Path(GetExchangeRate.RELATIVE_PATH)
   @Produces({ "application/json" })
   @ApiOperation(value = GetExchangeRate.GET_EXCHANGE_RATE, notes = "Returns an exchange rate between two currencies.", response = ExchangeRate.class, authorizations = {
         @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = GetExchangeRate.SUCCESS, message = "OK", response = ExchangeRate.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void getExchangeRate(
         @ApiParam(value = "The currency which amounts are converted from. One unit of this currency multiplied by the rate returned by this operation is equal to one unit of the toCurrency. This currency is expressed as a three digit number as specified in ISO 4217, e.g. South African Rand is encoded as 710.", required = true) @QueryParam(GetExchangeRate.QueryParameters.FROM_CURRENCY) @NotNull @Pattern(regexp = CURRENCY_REGEX) String fromCurrency,

         @ApiParam(value = "The currency which amounts are converted to. One unit of this currency multiplied by the rate returned by this operation is equal to one unit of the fromCurrency. This currency is expressed as a three digit number as specified in ISO 4217, e.g. South African Rand is encoded as 710.", required = true) @QueryParam(GetExchangeRate.QueryParameters.TO_CURRENCY) @NotNull @Pattern(regexp = CURRENCY_REGEX) String toCurrency,

         @ApiParam(value = "The ID of the receiver who would process such a currency exchange. If this is supplied then a specific institution's exchange rate may be returned. If this parameter is not supplied then the exchange rate may simply be the market exchange rate.") @QueryParam(GetExchangeRate.QueryParameters.RECEIVER_ID) String receiverId,

         @ApiParam(value = "The ID of the settlement entity who would process such a currency exchange. If this is supplied then a specific settlement entity's exchange rate may be returned for a specific receiver.") @QueryParam(GetExchangeRate.QueryParameters.SETTLEMENT_ENTITY_ID) String settlementEntityId,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().getExchangeRate(
            fromCurrency,
            toCurrency,
            receiverId,
            settlementEntityId,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @GET
   @Produces({ "application/json" })
   @ApiOperation(value = LookupOrders.LOOKUP_ORDERS, notes = "Queries the details of a client's existing money transfer orders.", response = MoneyTransferCustomerOrderHistory.class, authorizations = {
         @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = AdminResource.LookupOrders.SUCCESS, message = "OK", response = MoneyTransferCustomerOrderHistory.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void lookupOrders(
         @ApiParam(value = "Uniquely identifies customer's profile on the upstream entity's system.") @QueryParam(LookupOrders.QueryParameters.CUSTOMER_PROFILE_ID) @NotNull String customerProfileId,
         @ApiParam(value = "Identifies the service provider to whom this request must be directed.", required = true) @QueryParam(LookupOrders.QueryParameters.RECEIVER_ID) @NotNull String receiverId,
         @ApiParam(value = "The assigned merchant identifier. Also known as card acceptor ID.") @QueryParam(LookupOrders.QueryParameters.MERCHANT_ID) @Pattern(regexp = MERCHANT_ID_REGEX) String merchantId,
         @ApiParam(value = "Identifies the institution from which the transaction originates. Value to be assigned by Electrum.") @QueryParam(LookupOrders.QueryParameters.ORIGINATOR_INST_ID) String originatorInstId,
         @ApiParam(value = "The date from which to start searching for orders (inclusive).") @QueryParam(LookupOrders.QueryParameters.FROM_DATE_TIME) String fromDateTime,
         @ApiParam(value = "The date from which to end searching for orders (exclusive).") @QueryParam(LookupOrders.QueryParameters.TO_DATE_TIME) String toDateTime,
         @ApiParam(value = "Should be among the options of the OrderStatus in SendCash") @QueryParam(LookupOrders.QueryParameters.STATUS) String status,
         @ApiParam(value = "Payment type to filter orders by.") @QueryParam(LookupOrders.QueryParameters.PAYMENT_TYPE) String paymentType,
         @ApiParam(value = "Payment identifier for the payment type indicated. Required if 'paymentType' is defined.") @QueryParam(LookupOrders.QueryParameters.PAYMENT_IDENTIFIER_NAME) String paymentIdentifierName,
         @ApiParam(value = "Payment identifier value for the payment type indicated. Required if 'paymentType' is defined.") @QueryParam(LookupOrders.QueryParameters.PAYMENT_IDENTIFIER_VALUE) String paymentIdentifierValue,
         @ApiParam(value = "The max number of expected responses.") @QueryParam(LookupOrders.QueryParameters.LIMIT) int limit,
         @ApiParam(value = "The offset from the beginning date.") @QueryParam(LookupOrders.QueryParameters.OFFSET) int offset,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().lookupOrders(
            customerProfileId,
            merchantId,
            originatorInstId,
            fromDateTime,
            toDateTime,
            status,
            paymentType,
            paymentIdentifierName,
            paymentIdentifierValue,
            receiverId,
            limit,
            offset,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

}
