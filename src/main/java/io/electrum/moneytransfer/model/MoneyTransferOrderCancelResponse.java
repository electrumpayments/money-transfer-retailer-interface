package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Used to submit data in a response to the cancelOrder operation.
 */
@ApiModel(description = "Used to submit data in a response to the cancelOrder operation.")
public class MoneyTransferOrderCancelResponse extends Transaction {
   private LedgerAmount amount = null;

   private String orderRedeemRef = null;

   private String orderRedeemRefAlt = null;

   private String orderId = null;

   /**
    * Get amount
    *
    * @return amount
    **/
   @JsonProperty("amount")
   @ApiModelProperty(value = "")
   @Valid
   @NotNull
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public MoneyTransferOrderCancelResponse amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * The reference used to identify the order which should be cancelled.
    *
    * @return orderRedeemRef
    **/
   @JsonProperty("orderRedeemRef")
   @ApiModelProperty(required = true, value = "The reference used to identify the order which should be cancelled.")
   @Valid
   @NotNull
   public String getOrderRedeemRef() {
      return orderRedeemRef;
   }

   public void setOrderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
   }

   public MoneyTransferOrderCancelResponse orderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
      return this;
   }

   /**
    * An alternate reference used by the recipient to redeem the order. This must be printed on the receipt.
    *
    * @return orderRedeemRefAlt
    **/
   @JsonProperty("orderRedeemRefAlt")
   @ApiModelProperty(required = true, value = "An alternate reference used to identify the order which should be cancelled.")
   @Valid
   @NotNull
   public String getOrderRedeemRefAlt() {
      return orderRedeemRefAlt;
   }

   public void setOrderRedeemRefAlt(String orderRedeemRefAlt) {
      this.orderRedeemRefAlt = orderRedeemRefAlt;
   }

   public MoneyTransferOrderCancelResponse orderRedeemRefAlt(String orderRedeemRefAlt) {
      this.orderRedeemRefAlt = orderRedeemRefAlt;
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
   @Valid
   @NotNull
   public String getOrderId() {
      return orderId;
   }

   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }

   public MoneyTransferOrderCancelResponse orderId(String orderId) {
      this.orderId = orderId;
      return this;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + Objects.hash(amount, orderId, orderRedeemRef, orderRedeemRefAlt);
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (!super.equals(obj)) {
         return false;
      }
      if (!(obj instanceof MoneyTransferOrderCancelResponse)) {
         return false;
      }
      MoneyTransferOrderCancelResponse other = (MoneyTransferOrderCancelResponse) obj;
      return Objects.equals(amount, other.amount) && Objects.equals(orderId, other.orderId)
            && Objects.equals(orderRedeemRef, other.orderRedeemRef)
            && Objects.equals(orderRedeemRefAlt, other.orderRedeemRefAlt);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferOrderCancelResponse {\n");
      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    orderRedeemRef: ").append(Utils.toIndentedString(orderRedeemRef)).append("\n");
      sb.append("    orderRedeemRefAlt: ").append(Utils.toIndentedString(orderRedeemRefAlt)).append("\n");
      sb.append("    orderId: ").append(Utils.toIndentedString(orderId)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
