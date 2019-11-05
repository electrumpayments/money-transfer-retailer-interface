package io.electrum.moneytransfer.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
import io.electrum.moneytransfer.model.MoneyTransferAuthRequest;
import io.electrum.moneytransfer.model.MoneyTransferAuthResponse;
import io.electrum.moneytransfer.model.MoneyTransferCancelOrderReversal;
import io.electrum.moneytransfer.model.MoneyTransferConfirmation;
import io.electrum.moneytransfer.model.MoneyTransferLookupResponse;
import io.electrum.moneytransfer.model.MoneyTransferOrderCancelRequest;
import io.electrum.moneytransfer.model.MoneyTransferOrderCancelResponse;
import io.electrum.moneytransfer.model.MoneyTransferOrderStatusUpdateRequest;
import io.electrum.moneytransfer.model.MoneyTransferRedeemRequest;
import io.electrum.moneytransfer.model.MoneyTransferRedeemResponse;
import io.electrum.moneytransfer.model.MoneyTransferReversal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import static io.electrum.moneytransfer.util.ValidationUtil.MERCHANT_ID_REGEX;

@Path(OrdersResource.PATH)
@Api(description = "the orders API")
public abstract class OrdersResource {

   public class CreateOrder {
      public static final String CREATE_ORDER = "createOrder";
      public static final int SUCCESS = 201;
      public static final String RELATIVE_PATH = "/";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;
   }

   public class LookupOrder {
      public static final String LOOKUP_ORDER = "lookupOrder";
      public static final int SUCCESS = 200;
      public static final String RELATIVE_PATH = "/";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;

      public class QueryParameters {
         public static final String ORDER_REDEEM_REF = "orderRedeemRef";
         public static final String REMITTANCE_REF = "remittanceRef";
         public static final String MERCHANT_ID = "merchantId";
         public static final String ORIGINATOR_INST_ID = "originatorInstId";
         public static final String RECEIVER_ID = "receiverId";
         public static final String SETTLEMENT_ENTITY_ID = "settlementEntityId";
      }
   }

   public class RedeemOrder {
      public static final String REDEEM_ORDER = "redeemOrder";
      public static final int SUCCESS = 201;
      public static final String RELATIVE_PATH = "/redemptions";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;
   }

   public class ConfirmPayment {
      public static final String CONFIRM_PAYMENT = "confirmPayment";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH = "/confirmations";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;
   }

   public class ConfirmRedeem {
      public static final String CONFIRM_REDEEM = "confirmRedeem";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH = RedeemOrder.RELATIVE_PATH + "/confirmations";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;
   }

   public class ReversePayment {
      public static final String REVERSE_PAYMENT = "reversePayment";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH = "/reversals";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;
   }

   public class ReverseRedeem {
      public static final String REVERSE_REDEEM = "reverseRedeem";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH = RedeemOrder.RELATIVE_PATH + "/reversals";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;
   }

   public class OrderStatus {
      public static final String ORDER_STATUS = "orderStatus";
      public static final int SUCCESS = 204;
      public static final String RELATIVE_PATH = "/status";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;
   }

   public class CancelOrder {
      public static final String CANCEL_ORDER = "cancelOrder";
      public static final int SUCCESS = 200;
      public static final String RELATIVE_PATH = "/cancel";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;
   }

   public class CancelOrderReversal {
      public static final String CANCEL_ORDER_REVERSAL = "cancelOrderReversal";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH = CancelOrder.RELATIVE_PATH + "/reversals";
      public static final String FULL_PATH = OrdersResource.PATH + RELATIVE_PATH;
   }

   protected abstract IOrdersResource getResourceImplementation();

   public static final String PATH = "/orders";

   @POST
   @Path("/confirmations")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = ConfirmPayment.CONFIRM_PAYMENT, notes = "Advises that a money transfer payment has been made successfully. "
         + "This is treated as a store-and-forward transaction. Upon receipt, the Electrum service will "
         + "respond immediately to acknowledge receipt and place the message on a queue for guaranteed "
         + "delivery to the service provider. If the service provider does not support positive advice "
         + "messages, then this is simply stored for reporting purposes.", response = MoneyTransferConfirmation.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = ConfirmPayment.SUCCESS, message = "Accepted", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void confirmPayment(
         @ApiParam(value = "A payment confirmation.", required = true) @NotNull @Valid MoneyTransferConfirmation body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .confirmPayment(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Path("/redemptions/confirmations")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = ConfirmRedeem.CONFIRM_REDEEM, notes = "Advises that a money transfer order has been successfully redeemed. "
         + "This is treated as a store-and-forward transaction. Upon receipt, the Electrum service will "
         + "respond immediately to acknowledge receipt and place the message on a queue for guaranteed "
         + "delivery to the service provider. If the service provider does not support positive advice "
         + "messages, then this is simply stored for reporting purposes.", response = MoneyTransferConfirmation.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = ConfirmRedeem.SUCCESS, message = "Accepted", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void confirmRedeem(
         @ApiParam(value = "A redemption confirmation.", required = true) @NotNull @Valid MoneyTransferConfirmation body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .confirmRedeem(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = CreateOrder.CREATE_ORDER, notes = "Requests that an order be created for the specified payment amount. "
         + "The request is treated as an online financial authorization message. If the client calling this "
         + "resource does not receive a response, then a `reversePayment` call must be made to the "
         + "`/orders/reversals` resource to ensure the transaction is cancelled with no financial "
         + "impact.", response = MoneyTransferAuthResponse.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = CreateOrder.SUCCESS, message = "Created", response = MoneyTransferAuthResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void createOrder(
         @ApiParam(value = "A message containing the data required to carry out the payment order, as well as "
               + "information about the point-of-sale from which the transaction originates.", required = true) @NotNull @Valid MoneyTransferAuthRequest body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .createOrder(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @Deprecated
   public final void lookupOrder(
         String orderRedeemRef,
         String merchantId,
         String originatorInstId,
         String receiverId,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().lookupOrder(
            orderRedeemRef,
            merchantId,
            originatorInstId,
            receiverId,
            null,
            null,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @Deprecated
   public final void lookupOrder(
         String orderRedeemRef,
         String merchantId,
         String originatorInstId,
         String receiverId,
         String remittanceRef,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().lookupOrder(
            orderRedeemRef,
            merchantId,
            originatorInstId,
            receiverId,
            null,
            remittanceRef,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @GET
   @Produces({ "application/json" })
   @ApiOperation(value = LookupOrder.LOOKUP_ORDER, notes = "Queries the details of an existing money transfer "
         + "order.", response = MoneyTransferLookupResponse.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = LookupOrder.SUCCESS, message = "OK", response = MoneyTransferLookupResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void lookupOrder(
         @ApiParam(value = "Reference used by the recipient to redeem the order. If both this value and remittanceRef are supplied then this takes precedence.") @QueryParam(LookupOrder.QueryParameters.ORDER_REDEEM_REF) String orderRedeemRef,
         @ApiParam(value = "The assigned merchant identifier. Also known as card acceptor ID.") @QueryParam(LookupOrder.QueryParameters.MERCHANT_ID) @Pattern(regexp = MERCHANT_ID_REGEX) String merchantId,
         @ApiParam(value = "Identifies the institution from which the transaction originates. Value to be assigned by Electrum.") @QueryParam(LookupOrder.QueryParameters.ORIGINATOR_INST_ID) String originatorInstId,
         @ApiParam(value = "Identifies the service provider to whom this request must be directed.", required = true) @QueryParam(LookupOrder.QueryParameters.RECEIVER_ID) @NotNull String receiverId,
         @ApiParam(value = "Identifies the entity with whom the Merchant will settle the transaction.", required = false) @QueryParam(LookupOrder.QueryParameters.SETTLEMENT_ENTITY_ID) String settlementEntityId,
         @ApiParam(value = "Reference used by the recipient to refer to the order when no redemption is to occur (e.g. direct account deposits). If both this value and orderRedeemRef are supplied then orderRedeemRef takes precedence.") @QueryParam(LookupOrder.QueryParameters.REMITTANCE_REF) String remittanceRef,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().lookupOrder(
            orderRedeemRef,
            merchantId,
            originatorInstId,
            receiverId,
            settlementEntityId,
            remittanceRef,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @POST
   @Path(RedeemOrder.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = RedeemOrder.REDEEM_ORDER, notes = "Requests that an existing order be paid out to the recipient. "
         + "The request is treated as an online financial authorization message. If the client "
         + "calling this resource does not receive a response, then a `reverseRedeem` call must "
         + "be made to the `/orders/redemptions/reversals` resource to ensure the transaction is "
         + "cancelled with no financial impact.", response = MoneyTransferRedeemResponse.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = RedeemOrder.SUCCESS, message = "OK", response = MoneyTransferRedeemResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void redeemOrder(
         @ApiParam(value = "A message containing the data required to redeem the order, "
               + "as well as information about the point-of-sale from which the transaction "
               + "originates.", required = true) @NotNull @Valid MoneyTransferRedeemRequest body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .redeemOrder(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Path(ReversePayment.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = ReversePayment.REVERSE_PAYMENT, notes = "Requests that a money transfer payment be reversed. "
         + "This is treated as a store-and-forward transaction. Upon receipt, the Electrum "
         + "service will respond immediately to acknowledge receipt and place the message "
         + "on a queue for guaranteed delivery to the service provider.", response = MoneyTransferReversal.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = ReversePayment.SUCCESS, message = "Accepted", response = MoneyTransferReversal.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void reversePayment(
         @ApiParam(value = "A payment reversal.", required = true) @NotNull @Valid MoneyTransferReversal body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .reversePayment(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Path(ReverseRedeem.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = ReverseRedeem.REVERSE_REDEEM, notes = "Requests that a money transfer redemption be reversed. "
         + "This is treated as a store-and-forward transaction. Upon receipt, the Electrum "
         + "service will respond immediately to acknowledge receipt and place the message on "
         + "a queue for guaranteed delivery to the service provider.", response = MoneyTransferReversal.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = ReverseRedeem.SUCCESS, message = "Accepted", response = MoneyTransferReversal.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void reverseRedeem(
         @ApiParam(value = "A redemption reversal.", required = true) @NotNull @Valid MoneyTransferReversal body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .reverseRedeem(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @PUT
   @Path(OrderStatus.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @ApiOperation(value = OrderStatus.ORDER_STATUS, notes = "Advises of a change in an order's status.", authorizations = {
         @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = OrderStatus.SUCCESS, message = "No Content"),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void updateOrderStatus(
         @ApiParam(value = "The new status of the order.", required = true) @NotNull @Valid MoneyTransferOrderStatusUpdateRequest body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .updateOrderStatus(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Path(CancelOrder.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = CancelOrder.CANCEL_ORDER, notes = "Requests that an order be cancelled and that a sender be refunded. This requested is treated as an online message. If no response is received, the cancellation will be reversed.", response = MoneyTransferOrderCancelResponse.class, authorizations = {
         @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = CancelOrder.SUCCESS, message = "Ok", response = MoneyTransferOrderCancelResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void cancelOrder(
         @ApiParam(value = "A message containing the data required to cancel a payment order, as well as information about the point-of-sale from which the transaction originates.", required = true) @NotNull @Valid MoneyTransferOrderCancelRequest body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .cancelOrder(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Path(CancelOrderReversal.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = CancelOrderReversal.CANCEL_ORDER_REVERSAL, notes = "Requests that a cancellation be reversed. This is treated as a store-and-forward transaction. Upon receipt, it's recommended that implementors respond immediately to acknowledge receipt and place the message on a queue for guaranteed delivery to the service provider.", response = MoneyTransferCancelOrderReversal.class, authorizations = {
         @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = CancelOrderReversal.SUCCESS, message = "Accepted", response = MoneyTransferCancelOrderReversal.class),
         @ApiResponse(code = 200, message = "OK", response = MoneyTransferCancelOrderReversal.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void cancelOrderReversal(
         @ApiParam(value = "A message containing the data required to reverse an order cancellation.", required = true) @NotNull @Valid MoneyTransferCancelOrderReversal body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().cancelOrderReversal(
            body,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }
}
