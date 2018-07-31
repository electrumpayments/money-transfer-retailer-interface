package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.EncryptedPin;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Used to submit data in a call to the redeemOrder operation.
 */
@ApiModel(description = "Used to submit data in a call to the redeemOrder operation.")
public class MoneyTransferRedeemRequest extends Transaction {

   private LedgerAmount amount = null;

   private EncryptedPin pin;

   private String orderRedeemRef = null;

   private PersonalDetails recipientDetails = null;

   public MoneyTransferRedeemRequest amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * Get amount
    *
    * @return amount
    **/
   @JsonProperty("amount")
   @ApiModelProperty(value = "")
   @Valid
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public MoneyTransferRedeemRequest pin(EncryptedPin pin) {
      this.pin = pin;
      return this;
   }

   /**
    * The encrypted PIN to be used by the recipient to redeem the order.
    *
    * @return pin
    **/
   @JsonProperty("pin")
   @ApiModelProperty(value = "The encrypted PIN to be used by the recipient to redeem the order.")
   @Valid
   public EncryptedPin getPin() {
      return pin;
   }

   public void setPin(EncryptedPin pin) {
      this.pin = pin;
   }

   public MoneyTransferRedeemRequest orderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
      return this;
   }

   /**
    * Reference used by the recipient to redeem the order.
    *
    * @return orderRedeemRef
    **/
   @JsonProperty("orderRedeemRef")
   @ApiModelProperty(required = true, value = "Reference used by the recipient to redeem the order.")
   @Valid
   @NotNull
   public String getOrderRedeemRef() {
      return orderRedeemRef;
   }

   public void setOrderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
   }

   public MoneyTransferRedeemRequest recipientDetails(PersonalDetails recipientDetails) {
      this.recipientDetails = recipientDetails;
      return this;
   }

   /**
    * Personal details of the intended recipient.
    * Conditionally optional - please confirm with your integration partner whether this is required.
    *
    * @return recipientDetails
    **/
   @JsonProperty("recipientDetails")
   @ApiModelProperty(value = "Personal details of the intended recipient. Conditionally optional - please confirm with your integration partner whether this is required.")
   @Valid
   public PersonalDetails getRecipientDetails() {
      return recipientDetails;
   }

   public void setRecipientDetails(PersonalDetails recipientDetails) {
      this.recipientDetails = recipientDetails;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      final MoneyTransferRedeemRequest that = (MoneyTransferRedeemRequest) o;
      return Objects.equals(amount, that.amount) && Objects.equals(pin, that.pin) && Objects.equals(recipientDetails,
            that.recipientDetails) && Objects.equals(orderRedeemRef, that.orderRedeemRef);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), amount, pin, recipientDetails, orderRedeemRef);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferRedeemRequest {\n");
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
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("    recipientDetails: ").append(Utils.toIndentedString(recipientDetails)).append("\n");
      sb.append("    orderRedeemRef: ").append(Utils.toIndentedString(orderRedeemRef)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
