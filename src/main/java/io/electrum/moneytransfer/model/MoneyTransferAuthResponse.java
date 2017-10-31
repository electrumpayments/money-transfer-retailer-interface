/*
 * Money Transfer Service Interface
 * The Electrum Money Transfer Service Interface is an API designed to enable retailers to integrate with multiple counter-to-counter money transfer service providers via a single interface.  The basic procedure by which a counter-to-counter money transfer occurs is as follows: 1. A customer wishing to send money to a recipient registers a profile with the service provider. 2. The sender creates an order by making a cash payment at one of the retailer's points of sale (POS). The payment is linked to a unique payout reference generated by the service provider and a sender-selected PIN. 3. The sender supplies the recipient with the payout reference and PIN. 4. The recipient redeems the order at another POS by supplying the payout reference and PIN.  This API defines a RESTful interface that supports the following functionality: * Creation and querying of customer profiles. * Order creation (a dual message pair transaction consisting of an online payment authorization followed a store-and-forward confirmation or reversal). * Order lookup. * Order redemption. (a dual message pair transaction consisting of an online redeem authorization followed by a store-and-forward confirmation or reversal).  Note that because of the requirements of different service providers, some fields that are optional according to this specification may be mandatory for certain providers. For guidelines on how to implement this API, please contact both Electrum and the relevant service provider(s). 
 *
 * OpenAPI spec version: 1.0.1
 * Contact: support@electrum.co.za
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.electrum.moneytransfer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.model.Institution;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.SlipData;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains the data returned by a call to the createOrder operation.
 */
@ApiModel(description = "Contains the data returned by a call to the createOrder operation.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-31T09:10:54.608Z")
public class MoneyTransferAuthResponse {
   @JsonProperty("id")
   private String id = null;

   @JsonProperty("amount")
   private LedgerAmount amount = null;

   @JsonProperty("time")
   private Date time = null;

   @JsonProperty("originator")
   private Originator originator = null;

   @JsonProperty("client")
   private Institution client = null;

   @JsonProperty("thirdPartyIdentifiers")
   private List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<ThirdPartyIdentifier>();

   @JsonProperty("basketRef")
   private String basketRef = null;

   @JsonProperty("receiver")
   private Institution receiver = null;

   @JsonProperty("settlementEntity")
   private Institution settlementEntity = null;

   @JsonProperty("slipData")
   private SlipData slipData = null;

   @JsonProperty("senderDetails")
   private PersonalDetails senderDetails = null;

   @JsonProperty("orderRedeemRef")
   private String orderRedeemRef = null;

   @JsonProperty("orderId")
   private String orderId = null;

   public MoneyTransferAuthResponse id(String id) {
      this.id = id;
      return this;
   }

   /**
    * The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    * 
    * @return id
    **/
   @JsonProperty("id")
   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
   @NotNull
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public MoneyTransferAuthResponse amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * Get amount
    * 
    * @return amount
    **/
   @JsonProperty("amount")
   @ApiModelProperty(required = true, value = "")
   @NotNull
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public MoneyTransferAuthResponse time(Date time) {
      this.time = time;
      return this;
   }

   /**
    * The date and time of the message as recorded by the sender. The format shall be as defined for date-time in [RFC
    * 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    * 
    * @return time
    **/
   @JsonProperty("time")
   @ApiModelProperty(required = true, value = "The date and time of the message as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @NotNull
   public Date getTime() {
      return time;
   }

   public void setTime(Date time) {
      this.time = time;
   }

   public MoneyTransferAuthResponse originator(Originator originator) {
      this.originator = originator;
      return this;
   }

   /**
    * Get originator
    * 
    * @return originator
    **/
   @JsonProperty("originator")
   @ApiModelProperty(required = true, value = "")
   @NotNull
   public Originator getOriginator() {
      return originator;
   }

   public void setOriginator(Originator originator) {
      this.originator = originator;
   }

   public MoneyTransferAuthResponse client(Institution client) {
      this.client = client;
      return this;
   }

   /**
    * Get client
    * 
    * @return client
    **/
   @JsonProperty("client")
   @ApiModelProperty(required = true, value = "")
   @NotNull
   public Institution getClient() {
      return client;
   }

   public void setClient(Institution client) {
      this.client = client;
   }

   public MoneyTransferAuthResponse thirdPartyIdentifiers(List<ThirdPartyIdentifier> thirdPartyIdentifiers) {
      this.thirdPartyIdentifiers = thirdPartyIdentifiers;
      return this;
   }

   public MoneyTransferAuthResponse addThirdPartyIdentifiersItem(ThirdPartyIdentifier thirdPartyIdentifiersItem) {
      this.thirdPartyIdentifiers.add(thirdPartyIdentifiersItem);
      return this;
   }

   /**
    * An array of identifiers which each identify the transaction within each entity&#39;s system.
    * 
    * @return thirdPartyIdentifiers
    **/
   @JsonProperty("thirdPartyIdentifiers")
   @ApiModelProperty(required = true, value = "An array of identifiers which each identify the transaction within each entity's system.")
   @NotNull
   public List<ThirdPartyIdentifier> getThirdPartyIdentifiers() {
      return thirdPartyIdentifiers;
   }

   public void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> thirdPartyIdentifiers) {
      this.thirdPartyIdentifiers = thirdPartyIdentifiers;
   }

   public MoneyTransferAuthResponse basketRef(String basketRef) {
      this.basketRef = basketRef;
      return this;
   }

   /**
    * Used to group multiple transactions which would otherwise be considered independent.
    * 
    * @return basketRef
    **/
   @JsonProperty("basketRef")
   @ApiModelProperty(value = "Used to group multiple transactions which would otherwise be considered independent.")
   public String getBasketRef() {
      return basketRef;
   }

   public void setBasketRef(String basketRef) {
      this.basketRef = basketRef;
   }

   public MoneyTransferAuthResponse receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   /**
    * Get receiver
    * 
    * @return receiver
    **/
   @JsonProperty("receiver")
   @ApiModelProperty(required = true, value = "")
   @NotNull
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   public MoneyTransferAuthResponse settlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
      return this;
   }

   /**
    * Get settlementEntity
    * 
    * @return settlementEntity
    **/
   @JsonProperty("settlementEntity")
   @ApiModelProperty(value = "")
   public Institution getSettlementEntity() {
      return settlementEntity;
   }

   public void setSettlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
   }

   public MoneyTransferAuthResponse slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   /**
    * Get slipData
    * 
    * @return slipData
    **/
   @JsonProperty("slipData")
   @ApiModelProperty(value = "")
   public SlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(SlipData slipData) {
      this.slipData = slipData;
   }

   public MoneyTransferAuthResponse senderDetails(PersonalDetails senderDetails) {
      this.senderDetails = senderDetails;
      return this;
   }

   /**
    * Get senderDetails
    * 
    * @return senderDetails
    **/
   @JsonProperty("senderDetails")
   @ApiModelProperty(required = true, value = "")
   @NotNull
   public PersonalDetails getSenderDetails() {
      return senderDetails;
   }

   public void setSenderDetails(PersonalDetails senderDetails) {
      this.senderDetails = senderDetails;
   }

   public MoneyTransferAuthResponse orderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
      return this;
   }

   /**
    * Reference used by the recipient to redeem the order. This must be printed on the receipt.
    * 
    * @return orderRedeemRef
    **/
   @JsonProperty("orderRedeemRef")
   @ApiModelProperty(required = true, value = "Reference used by the recipient to redeem the order. This must be printed on the receipt.")
   @NotNull
   public String getOrderRedeemRef() {
      return orderRedeemRef;
   }

   public void setOrderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
   }

   public MoneyTransferAuthResponse orderId(String orderId) {
      this.orderId = orderId;
      return this;
   }

   /**
    * Reference used by the service provider to uniquely identify the money transfer order on their system. This field
    * can be used if the provider supplies a supplementary reference for the order in addition to the orderRedeemRef.
    * Note that any reference issued by the provider that is specific to a particular leg of the order process should be
    * set as a ThirdPartyIdentifier (i.e. the authorization and redeem legs of the order should each have its own
    * reference).
    * 
    * @return orderId
    **/
   @JsonProperty("orderId")
   @ApiModelProperty(value = "Reference used by the service provider to uniquely identify the money transfer order on their system. This field can be used if the provider supplies a supplementary reference for the order in addition to the orderRedeemRef. Note that any reference issued by the provider that is specific to a particular leg of the order process should be set as a ThirdPartyIdentifier (i.e. the authorization and redeem legs of the order should each have its own reference).")
   public String getOrderId() {
      return orderId;
   }

   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MoneyTransferAuthResponse moneyTransferAuthResponse = (MoneyTransferAuthResponse) o;
      return Objects.equals(this.id, moneyTransferAuthResponse.id)
            && Objects.equals(this.amount, moneyTransferAuthResponse.amount)
            && Objects.equals(this.time, moneyTransferAuthResponse.time)
            && Objects.equals(this.originator, moneyTransferAuthResponse.originator)
            && Objects.equals(this.client, moneyTransferAuthResponse.client)
            && Objects.equals(this.thirdPartyIdentifiers, moneyTransferAuthResponse.thirdPartyIdentifiers)
            && Objects.equals(this.basketRef, moneyTransferAuthResponse.basketRef)
            && Objects.equals(this.receiver, moneyTransferAuthResponse.receiver)
            && Objects.equals(this.settlementEntity, moneyTransferAuthResponse.settlementEntity)
            && Objects.equals(this.slipData, moneyTransferAuthResponse.slipData)
            && Objects.equals(this.senderDetails, moneyTransferAuthResponse.senderDetails)
            && Objects.equals(this.orderRedeemRef, moneyTransferAuthResponse.orderRedeemRef)
            && Objects.equals(this.orderId, moneyTransferAuthResponse.orderId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            id,
            amount,
            time,
            originator,
            client,
            thirdPartyIdentifiers,
            basketRef,
            receiver,
            settlementEntity,
            slipData,
            senderDetails,
            orderRedeemRef,
            orderId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferAuthResponse {\n");

      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
      sb.append("    time: ").append(toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(toIndentedString(client)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    basketRef: ").append(toIndentedString(basketRef)).append("\n");
      sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
      sb.append("    settlementEntity: ").append(toIndentedString(settlementEntity)).append("\n");
      sb.append("    slipData: ").append(toIndentedString(slipData)).append("\n");
      sb.append("    senderDetails: ").append(toIndentedString(senderDetails)).append("\n");
      sb.append("    orderRedeemRef: ").append(toIndentedString(orderRedeemRef)).append("\n");
      sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(java.lang.Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
