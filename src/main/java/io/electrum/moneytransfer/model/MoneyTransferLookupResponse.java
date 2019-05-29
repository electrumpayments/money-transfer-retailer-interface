package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Originator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains the data returned by a call to the lookupOrder operation.
 */
@ApiModel(description = "Contains the data returned by a call to the lookupOrder operation.")
public class MoneyTransferLookupResponse {
   @JsonProperty("amount")
   private LedgerAmount amount = null;

   /**
    * The status of the order
    */
   public enum StatusEnum {
      UNREDEEMED("UNREDEEMED"),

      REDEEMED("REDEEMED"),

      CANCELLED("CANCELLED"),

      EXPIRED("EXPIRED"),

      ON_HOLD("ON_HOLD"),

      UNCONFIRMED("UNCONFIRMED");

      private String value;

      StatusEnum(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }

      @JsonCreator
      public static StatusEnum fromValue(String text) {
         for (StatusEnum b : StatusEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
               return b;
            }
         }
         return null;
      }
   }

   @JsonProperty("status")
   private StatusEnum status = null;

   private String statusDescription = null;

   @JsonProperty("originator")
   private Originator originator = null;

   @JsonProperty("receiver")
   private Institution receiver = null;

   private String orderRedeemRef = null;

   private String orderRedeemRefAlt = null;

   private String orderId = null;

   public MoneyTransferLookupResponse amount(LedgerAmount amount) {
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
   @Valid
   @NotNull
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public MoneyTransferLookupResponse status(StatusEnum status) {
      this.status = status;
      return this;
   }

   /**
    * The status of the order
    * 
    * @return status
    **/
   @JsonProperty("status")
   @ApiModelProperty(value = "The status of the order")
   public StatusEnum getStatus() {
      return status;
   }

   public void setStatus(StatusEnum status) {
      this.status = status;
   }

   public MoneyTransferLookupResponse statusDescription(String statusDescription) {
      this.statusDescription = statusDescription;
      return this;
   }

   /**
    * The detailed description of the status of an order
    *
    * @return statusDescription
    **/
   @JsonProperty("statusDescription")
   @ApiModelProperty(value = "The detailed description of the status of an order")
   public String getStatusDescription() {
      return statusDescription;
   }

   public void setStatusDescription(String statusDescription) {
      this.statusDescription = statusDescription;
   }

   public MoneyTransferLookupResponse originator(Originator originator) {
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
   @Valid
   @NotNull
   public Originator getOriginator() {
      return originator;
   }

   public void setOriginator(Originator originator) {
      this.originator = originator;
   }

   public MoneyTransferLookupResponse receiver(Institution receiver) {
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
   @Valid
   @NotNull
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   public MoneyTransferLookupResponse orderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
      return this;
   }

   /**
    * Reference used by the recipient to redeem the order. This must be printed on the receipt.
    *
    * @return orderRedeemRef
    **/
   @JsonProperty("orderRedeemRef")
   @ApiModelProperty(value = "Reference used by the recipient to redeem the order. This must be printed on the receipt.")
   @Valid
   public String getOrderRedeemRef() {
      return orderRedeemRef;
   }

   public void setOrderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
   }

   public MoneyTransferLookupResponse orderRedeemRefAlt(String orderRedeemRefAlt) {
      this.orderRedeemRefAlt = orderRedeemRefAlt;
      return this;
   }

   /**
    * An alternate reference used by the recipient to redeem the order. This must be printed on the receipt.
    *
    * @return orderRedeemRefAlt
    **/
   @JsonProperty("orderRedeemRefAlt")
   @ApiModelProperty(value = "An alternate reference used by the recipient to redeem the order. This must be printed on the receipt.")
   public String getOrderRedeemRefAlt() {
      return orderRedeemRefAlt;
   }

   public void setOrderRedeemRefAlt(String orderRedeemRefAlt) {
      this.orderRedeemRefAlt = orderRedeemRefAlt;
   }

   public MoneyTransferLookupResponse orderId(String orderId) {
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
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof MoneyTransferLookupResponse)) return false;
      MoneyTransferLookupResponse that = (MoneyTransferLookupResponse) o;
      return Objects.equals(amount, that.amount) &&
            status == that.status &&
            Objects.equals(statusDescription, that.statusDescription) &&
            Objects.equals(originator, that.originator) &&
            Objects.equals(receiver, that.receiver) &&
            Objects.equals(orderRedeemRef, that.orderRedeemRef) &&
            Objects.equals(orderRedeemRefAlt, that.orderRedeemRefAlt) &&
            Objects.equals(orderId, that.orderId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, status, statusDescription, originator, receiver, orderRedeemRef, orderRedeemRefAlt, orderId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferLookupResponse {\n");

      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    status: ").append(Utils.toIndentedString(status)).append("\n");
      sb.append("    statusDescription: ").append(Utils.toIndentedString(statusDescription)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    orderRedeemRef: ").append(Utils.toIndentedString(orderRedeemRef)).append("\n");
      sb.append("    orderRedeemRefAlt: ").append(Utils.toIndentedString(orderRedeemRefAlt)).append("\n");
      sb.append("    orderId: ").append(Utils.toIndentedString(orderId)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
