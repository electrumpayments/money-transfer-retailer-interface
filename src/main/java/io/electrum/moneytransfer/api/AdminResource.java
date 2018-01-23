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

import io.electrum.moneytransfer.model.MoneyTransferAdminMessage;
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

   @POST
   @Path("/customers")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "", notes = "Request to create a new or update an existing customer "
         + "profile on the service provider's system.", response = MoneyTransferAdminMessage.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 400, message = "Bad request", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 501, message = "Not implemented", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = MoneyTransferAdminMessage.class) })
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
   @ApiOperation(value = "", notes = "Returns information of the customer's profile as "
         + "registered on the service provider's system.", response = MoneyTransferAdminMessage.class, authorizations = {
               @Authorization(value = "httpBasic") }, tags = {})
   @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 400, message = "Bad request", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 501, message = "Not implemented", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = MoneyTransferAdminMessage.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = MoneyTransferAdminMessage.class) })
   public final void getCustomerInfo(
         @ApiParam(value = "National identity number of the customer.", required = true) @QueryParam("idNumber") String idNumber,

         @ApiParam(value = "The assigned merchant identifier. Also known as card acceptor id.") @QueryParam("merchantId") String merchantId,
         
         @ApiParam(value = "Identifies the institution from which the transaction originates. Value to be assigned by Electrum.") @QueryParam("originatorInstId") String originatorInstId,

         @ApiParam(value = "Identifies the service provider to whom this request must be directed.", required = true) @QueryParam("receiverId") String receiverId,

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
}
