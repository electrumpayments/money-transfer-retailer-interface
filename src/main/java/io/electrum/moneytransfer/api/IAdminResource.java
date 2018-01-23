package io.electrum.moneytransfer.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.moneytransfer.model.MoneyTransferAdminMessage;

public interface IAdminResource {
   void createOrUpdateCustomer(
         MoneyTransferAdminMessage body,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest);

   void getCustomerInfo(
         @NotNull String idNumber,
         String merchantId,
         @NotNull String originatorInstId,
         @NotNull String receiverId,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest) throws NotFoundException;
}
