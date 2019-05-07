package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.sdk.masking2.DoNotPersist;
import io.electrum.sdk.masking2.MaskAll;
import io.electrum.sdk.masking2.Masked;
import io.electrum.vas.Utils;
import io.electrum.vas.model.EncryptedPin;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Used to submit data in a call to the redeemOrder operation.
 */
@ApiModel(description = "Used to submit data in a call to the cancelOrder operation.")
public class MoneyTransferOrderCancelRequest extends Transaction {
   @JsonProperty("orderRedeemRef")
   private String orderRedeemRef = null;

   @JsonProperty("orderRedeemRefAlt")
   private String orderRedeemRefAlt = null;

   @JsonProperty("pin")
   private EncryptedPin pin;

   @JsonProperty("idNumber")
   @Masked
   @DoNotPersist(replacementValue = "000000000000")
   private String idNumber = null;

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

   public MoneyTransferOrderCancelRequest orderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
      return this;
   }

   /**
    * An alternate reference used by the recipient to redeem the order. This must be printed on the receipt.
    *
    * @return orderRedeemRefAlt
    **/
   @JsonProperty("orderRedeemRefAlt")
   @ApiModelProperty(required = true, value = "The reference used to identify the order which should be cancelled.")
   @Valid
   @NotNull
   public String getOrderRedeemRefAlt() {
      return orderRedeemRefAlt;
   }

   public void setOrderRedeemRefAlt(String orderRedeemRefAlt) {
      this.orderRedeemRefAlt = orderRedeemRefAlt;
   }

   public MoneyTransferOrderCancelRequest orderRedeemRefAlt(String orderRedeemRefAlt) {
      this.orderRedeemRefAlt = orderRedeemRefAlt;
      return this;
   }

   /**
    * If required, the same pin which would have been used to redeem the order, should be supplied to cancel the order.
    *
    * @return pin
    **/
   @JsonProperty("pin")
   @ApiModelProperty(value = "If required, the same pin which would have been used to redeem the order, should be supplied to cancel the order.")
   @Valid
   public EncryptedPin getPin() {
      return pin;
   }

   public void setPin(EncryptedPin pin) {
      this.pin = pin;
   }

   public MoneyTransferOrderCancelRequest pin(EncryptedPin pin) {
      this.pin = pin;
      return this;
   }

   /**
    * The ID Number of the sender. This is the same ID Number used when creating the order.
    *
    * @return idNumber
    **/
   @JsonProperty("idNumber")
   @ApiModelProperty(value = "The ID Number of the sender. This is the same ID Number used when creating the order.")
   @Valid
   @Masked
   @DoNotPersist(replacementValue = "000000000000")
   public String getIdNumber() {
      return orderRedeemRefAlt;
   }

   public void setIdNumber(String idNumber) {
      this.idNumber = idNumber;
   }

   public MoneyTransferOrderCancelRequest idNumber(String idNumber) {
      this.idNumber = idNumber;
      return this;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + Objects.hash(idNumber, orderRedeemRef, orderRedeemRefAlt, pin);
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
      if (!(obj instanceof MoneyTransferOrderCancelRequest)) {
         return false;
      }
      MoneyTransferOrderCancelRequest other = (MoneyTransferOrderCancelRequest) obj;
      return Objects.equals(idNumber, other.idNumber) && Objects.equals(orderRedeemRef, other.orderRedeemRef)
            && Objects.equals(orderRedeemRefAlt, other.orderRedeemRefAlt) && Objects.equals(pin, other.pin);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferOrderCancelRequest {\n");
      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("    orderRedeemRef: ").append(Utils.toIndentedString(orderRedeemRef)).append("\n");
      sb.append("    orderRedeemRefAlt: ").append(Utils.toIndentedString(orderRedeemRefAlt)).append("\n");
      sb.append("    idNumber: ").append(Utils.toIndentedString(new MaskAll().mask(idNumber))).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
