package io.electrum.moneytransfer.api;

import javax.servlet.http.HttpServletRequest;
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
import io.electrum.moneytransfer.model.MoneyTransferAdminMessage;
import io.electrum.moneytransfer.model.MoneyTransferFeeQuote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path("/moneytransfer/v1/admin")

@Api(description = "the admin API")
public abstract class AdminResource {

   protected abstract IAdminResource getResourceImplementation();

   public class GetCustomerInfo {
      public static final String GET_CUSTOMER_INFO = "getCustomerInfo";
      public static final int SUCCESS = 200;

      public class QueryParameters {
         public static final String ID_NUMBER = "idNumber";
         public static final String MERCHANT_ID = "merchantId";
         public static final String ORIGINATOR_INST_ID = "originatorInstId";
         public static final String RECEIVER_ID = "receiverId";
      }
   }

   public class CreateOrUpdateCustomer {
      public static final String CREATE_OR_UPDATE_CUSTOMER = "createOrUpdateCustomer";
      public static final int SUCCESS = 201;
   }

   public class GetFeeQuote {
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

   @POST
   @Path("/customers")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = CreateOrUpdateCustomer.CREATE_OR_UPDATE_CUSTOMER, notes = "Request to create a new or update an existing customer "
         + "profile on the service provider's system.", response = MoneyTransferAdminMessage.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void createOrUpdateCustomer(
         @ApiParam(value = "A message containing the data required to carry out the admin "
               + "request, as well as information about the point-of-sale from which the "
               + "transaction originates.", required = true) MoneyTransferAdminMessage body,
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
   @Path("/customers")
   @Produces({ "application/json" })
   @ApiOperation(value = GetCustomerInfo.GET_CUSTOMER_INFO, notes = "Returns information of the customer's profile as "
         + "registered on the service provider's system.", response = MoneyTransferAdminMessage.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void getCustomerInfo(
         @ApiParam(value = "National identity number of the customer.", required = true) @QueryParam(GetCustomerInfo.QueryParameters.ID_NUMBER) String idNumber,

         @ApiParam(value = "The assigned merchant identifier. Also known as card acceptor id.") @QueryParam(GetCustomerInfo.QueryParameters.MERCHANT_ID) String merchantId,

         @ApiParam(value = "Identifies the institution from which the transaction originates. Value to be assigned by Electrum.") @QueryParam(GetCustomerInfo.QueryParameters.ORIGINATOR_INST_ID) String originatorInstId,

         @ApiParam(value = "Identifies the service provider to whom this request must be directed.", required = true) @QueryParam(GetCustomerInfo.QueryParameters.RECEIVER_ID) String receiverId,

         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().getCustomerInfo(
            idNumber,
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
   @Path("/fees")
   @Produces({ "application/json" })
   @ApiOperation(value = GetFeeQuote.GET_FEE_QUOTE, notes = "Returns the fee that will be charged to the customer for the transfer.", response = MoneyTransferFeeQuote.class, authorizations = {
         @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = MoneyTransferFeeQuote.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void getFeeQuote(
         @ApiParam(value = "The amount the customer wishes to transfer.", required = true) @QueryParam(GetFeeQuote.QueryParameters.AMOUNT) Long amount,

         @ApiParam(value = "Whether or not the amount is inclusive of the fee.", required = true) @QueryParam(GetFeeQuote.QueryParameters.AMOUNT_INCLUDES_FEE) Boolean amountIncludesFee,

         @ApiParam(value = "National identity number of the customer.") @QueryParam(GetFeeQuote.QueryParameters.ID_NUMBER) String idNumber,

         @ApiParam(value = "The assigned merchant identifier. Also known as card acceptor ID.") @QueryParam(GetFeeQuote.QueryParameters.MERCHANT_ID) String merchantId,

         @ApiParam(value = "Identifies the institution from which the transaction originates. Value to be assigned by Electrum.", required = true) @QueryParam(GetFeeQuote.QueryParameters.ORIGINATOR_INST_ID) String originatorInstId,

         @ApiParam(value = "Identifies the service provider to whom this request must be directed.", required = true) @QueryParam(GetFeeQuote.QueryParameters.RECEIVER_ID) String receiverId,

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
}
