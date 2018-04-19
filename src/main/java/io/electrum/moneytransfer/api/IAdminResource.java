package io.electrum.moneytransfer.api;

import io.electrum.moneytransfer.model.IdType;
import io.electrum.moneytransfer.model.MoneyTransferAdminMessage;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

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
         IdType idType,
         String idCountryCode,
         String merchantId,
         @NotNull String originatorInstId,
         @NotNull String receiverId,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest) throws NotFoundException;

   void getFeeQuote(
         @NotNull Long amount,
         @NotNull Boolean amountIncludesFee,
         String idNumber,
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
