package io.electrum.moneytransfer.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.moneytransfer.model.IdType;
import io.electrum.moneytransfer.model.MoneyTransferAdminMessage;
import io.electrum.moneytransfer.model.MoneyTransferQuoteRequest;

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
         HttpServletRequest httpServletRequest)
         throws NotFoundException;

   void getFeeQuote(
         @NotNull Long amount,
         @NotNull Boolean amountIncludesFee,
         String idNumber,
         String merchantId,
         @NotNull String originatorInstId,
         @NotNull String receiverId,
         String senderCell,
         String recipientCell,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest)
         throws NotFoundException;

   void getFeeQuote(
         MoneyTransferQuoteRequest body,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest)
         throws NotFoundException;

   @Deprecated
   void getExchangeRate(
         @NotNull String fromCurrency,
         String toCurrency,
         String receiverId,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest)
         throws NotFoundException;

   void getExchangeRate(
         @NotNull String fromCurrency,
         String toCurrency,
         String receiverId,
         String settlementEntityId,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest)
         throws NotFoundException;

   void lookupOrders(
         @NotNull String customerProfileId,
         String merchantId,
         String originatorInstId,
         String fromDateTime,
         String toDateTime,
         String status,
         String paymentType,
         String paymentIdentifierName,
         String paymentIdentifierValue,
         @NotNull String receiverId,
         String limit,
         String offSet,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest);
}
