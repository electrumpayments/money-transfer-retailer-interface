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

import io.electrum.moneytransfer.model.MoneyTransferAuthRequest;
import io.electrum.moneytransfer.model.MoneyTransferAuthResponse;
import io.electrum.moneytransfer.model.MoneyTransferConfirmation;
import io.electrum.moneytransfer.model.MoneyTransferLookupResponse;
import io.electrum.moneytransfer.model.MoneyTransferRedeemRequest;
import io.electrum.moneytransfer.model.MoneyTransferRedeemResponse;
import io.electrum.moneytransfer.model.MoneyTransferReversal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path("/moneytransfer/v1/orders")

@Api(description = "the orders API")
public abstract class OrdersResource {
   
   public class ConfirmPayment{
      public static final String CONFIRM_PAYMENT = "confirmPayment";
      public static final int SUCCESS = 202;
   }
   
   public class ConfirmRedeem{
      public static final String CONFIRM_REDEEM = "confirmRedeem";
      public static final int SUCCESS = 202;
   }
   
   public class CreateOrder{
      public static final String CREATE_ORDER = "createOrder";
      public static final int SUCCESS = 201;
   }
   
   public class LookupOrder{
      public static final String LOOKUP_ORDER = "lookupOrder";
      public static final int SUCCESS = 200;
      public class QueryParameters{
         public static final String ORDER_REDEEM_REF = "orderRedeemRef";
         public static final String MERCHANT_ID = "merchantId";
         public static final String ORIGINATOR_INST_ID = "originatorInstId";
         public static final String RECEIVER_ID = "receiverId";
      }
   }
   
   public class RedeemOrder{
      public static final String REDEEM_ORDER = "redeemOrder";
      public static final int SUCCESS = 201;
   }
   
   public class ReversePayment{
      public static final String REVERSE_PAYMENT = "reversePayment";
      public static final int SUCCESS = 202;
   }
   
   public class ReverseRedeem{
      public static final String REVERSE_REDEEM = "reverseRedeem";
      public static final int SUCCESS = 202;
   }

   protected abstract IOrdersResource getResourceImplementation();

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
   @ApiResponses(value = { @ApiResponse(code = ConfirmPayment.SUCCESS, message = "Accepted", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 400, message = "Bad request", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 501, message = "Not implemented", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = MoneyTransferConfirmation.class) })
   public final void confirmPayment(
         @ApiParam(value = "A payment confirmation.", required = true) MoneyTransferConfirmation body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().confirmPayment(
            body,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
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
   @ApiResponses(value = { @ApiResponse(code = ConfirmRedeem.SUCCESS, message = "Accepted", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 400, message = "Bad request", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 501, message = "Not implemented", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = MoneyTransferConfirmation.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = MoneyTransferConfirmation.class) })
   public final void confirmRedeem(
         @ApiParam(value = "A redemption confirmation.", required = true) MoneyTransferConfirmation body,
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
   @ApiResponses(value = { @ApiResponse(code = CreateOrder.SUCCESS, message = "Created", response = MoneyTransferAuthResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = MoneyTransferAuthResponse.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = MoneyTransferAuthResponse.class),
         @ApiResponse(code = 501, message = "Not implemented", response = MoneyTransferAuthResponse.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = MoneyTransferAuthResponse.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = MoneyTransferAuthResponse.class) })
   public final void createOrder(
         @ApiParam(value = "A message containing the data required to carry out the payment order, as well as "
               + "information about the point-of-sale from which the transaction originates.", required = true) MoneyTransferAuthRequest body,

         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .createOrder(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @GET
   @Produces({ "application/json" })
   @ApiOperation(value = LookupOrder.LOOKUP_ORDER, notes = "Queries the details of an existing money transfer "
         + "order.", response = MoneyTransferLookupResponse.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = LookupOrder.SUCCESS, message = "OK", response = MoneyTransferLookupResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = MoneyTransferLookupResponse.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = MoneyTransferLookupResponse.class),
         @ApiResponse(code = 501, message = "Not implemented", response = MoneyTransferLookupResponse.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = MoneyTransferLookupResponse.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = MoneyTransferLookupResponse.class) })
   public final void lookupOrder(
         @ApiParam(value = "Reference used by the recipient to redeem the order.", required = true) @QueryParam(LookupOrder.QueryParameters.ORDER_REDEEM_REF) String orderRedeemRef,

         @ApiParam(value = "The assigned merchant identifier. Also known as card acceptor id.") @QueryParam(LookupOrder.QueryParameters.MERCHANT_ID) String merchantId,

         @ApiParam(value = "Identifies the institution from which the transaction originates. Value to be assigned by Electrum.") @QueryParam(LookupOrder.QueryParameters.ORIGINATOR_INST_ID) String originatorInstId,

         @ApiParam(value = "Identifies the service provider to whom this request must be directed.", required = true) @QueryParam(LookupOrder.QueryParameters.RECEIVER_ID) String receiverId,

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
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @POST
   @Path("/redemptions")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = RedeemOrder.REDEEM_ORDER, notes = "Requests that an existing order be paid out to the recipient. "
         + "The request is treated as an online financial authorization message. If the client "
         + "calling this resource does not receive a response, then a `reverseRedeem` call must "
         + "be made to the `/orders/redemptions/reversals` resource to ensure the transaction is "
         + "cancelled with no financial impact.", response = MoneyTransferRedeemResponse.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = RedeemOrder.SUCCESS, message = "OK", response = MoneyTransferRedeemResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = MoneyTransferRedeemResponse.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = MoneyTransferRedeemResponse.class),
         @ApiResponse(code = 501, message = "Not implemented", response = MoneyTransferRedeemResponse.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = MoneyTransferRedeemResponse.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = MoneyTransferRedeemResponse.class) })
   public final void redeemOrder(
         @ApiParam(value = "A message containing the data required to redeem the order, "
               + "as well as information about the point-of-sale from which the transaction "
               + "originates.", required = true) MoneyTransferRedeemRequest body,
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
   @Path("/reversals")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = ReversePayment.REVERSE_PAYMENT, notes = "Requests that a money transfer payment be reversed. "
         + "This is treated as a store-and-forward transaction. Upon receipt, the Electrum "
         + "service will respond immediately to acknowledge receipt and place the message "
         + "on a queue for guaranteed delivery to the service provider.", response = MoneyTransferReversal.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = ReversePayment.SUCCESS, message = "Accepted", response = MoneyTransferReversal.class),
         @ApiResponse(code = 400, message = "Bad request", response = MoneyTransferReversal.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = MoneyTransferReversal.class),
         @ApiResponse(code = 501, message = "Not implemented", response = MoneyTransferReversal.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = MoneyTransferReversal.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = MoneyTransferReversal.class) })
   public final void reversePayment(
         @ApiParam(value = "A payment reversal.", required = true) MoneyTransferReversal body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().reversePayment(
            body,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @POST
   @Path("/redemptions/reversals")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = ReverseRedeem.REVERSE_REDEEM, notes = "Requests that a money transfer redemption be reversed. "
         + "This is treated as a store-and-forward transaction. Upon receipt, the Electrum "
         + "service will respond immediately to acknowledge receipt and place the message on "
         + "a queue for guaranteed delivery to the service provider.", response = MoneyTransferReversal.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = ReverseRedeem.SUCCESS, message = "Accepted", response = MoneyTransferReversal.class),
         @ApiResponse(code = 400, message = "Bad request", response = MoneyTransferReversal.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = MoneyTransferReversal.class),
         @ApiResponse(code = 501, message = "Not implemented", response = MoneyTransferReversal.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = MoneyTransferReversal.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = MoneyTransferReversal.class) })
   public final void reverseRedeem(
         @ApiParam(value = "A redemption reversal.", required = true) MoneyTransferReversal body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .reverseRedeem(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }
}
