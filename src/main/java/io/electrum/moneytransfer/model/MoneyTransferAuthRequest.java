package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.EncryptedPin;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Used to submit data in a call to the createOrder operation.
 */
@ApiModel(description = "Used to submit data in a call to the createOrder operation.")
public class MoneyTransferAuthRequest extends Transaction {

   private LedgerAmount amount = null;

   private PersonalDetails senderDetails = null;

   private PersonalDetails recipientDetails = null;

   private EncryptedPin pin;

   private String customerProfileId = null;

   private Boolean newCustomer = null;

   private LedgerAmount fee = null;

   public MoneyTransferAuthRequest amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * The amount to be transferred.
    *
    * @return amount
    **/
   @JsonProperty("amount")
   @ApiModelProperty(required = true, value = "The amount to be transferred.")
   @NotNull
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public MoneyTransferAuthRequest originator(Originator originator) {
      this.originator = originator;
      return this;
   }

   public MoneyTransferAuthRequest senderDetails(PersonalDetails senderDetails) {
      this.senderDetails = senderDetails;
      return this;
   }

   /**
    * Personal details of a customer.
    *
    * @return senderDetails
    **/
   @JsonProperty("senderDetails")
   @ApiModelProperty(required = true, value = "Personal details of a customer.")
   @NotNull
   public PersonalDetails getSenderDetails() {
      return senderDetails;
   }

   public void setSenderDetails(PersonalDetails senderDetails) {
      this.senderDetails = senderDetails;
   }

   public MoneyTransferAuthRequest recipientDetails(PersonalDetails recipientDetails) {
      this.recipientDetails = recipientDetails;
      return this;
   }

   /**
    * Personal details of a recipient.
    *
    * @return recipientDetails
    **/
   @JsonProperty("recipientDetails")
   @ApiModelProperty(required = true, value = "Personal details of a recipient.")
   @NotNull
   public PersonalDetails getRecipientDetails() {
      return recipientDetails;
   }

   public void setRecipientDetails(PersonalDetails recipientDetails) {
      this.recipientDetails = recipientDetails;
   }

   public MoneyTransferAuthRequest pin(EncryptedPin pin) {
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
   public EncryptedPin getPin() {
      return pin;
   }

   public void setPin(EncryptedPin pin) {
      this.pin = pin;
   }

   /**
    * Uniquely identifies a customer's profile on the upstream entity's system.
    *
    * @return customerProfileId
    **/
   @JsonProperty("customerProfileId")
   @ApiModelProperty(value = "Uniquely identifies customer's profile on the upstream entity's system.")
   public String getCustomerProfileId() {
      return customerProfileId;
   }

   public void setCustomerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
   }

   public MoneyTransferAuthRequest customerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
      return this;
   }

   public MoneyTransferAuthRequest newCustomer(Boolean newCustomer) {
      this.newCustomer = newCustomer;
      return this;
   }

   /**
    * An optional flag indicating whether the customer placing the order is already registered on the provider's system.
    *
    * @return newCustomer
    **/
   @JsonProperty("newCustomer")
   @ApiModelProperty(value = "An optional flag indicating whether the customer placing the order is already registered on the provider's system.")
   public Boolean getNewCustomer() {
      return newCustomer;
   }

   public void setNewCustomer(Boolean newCustomer) {
      this.newCustomer = newCustomer;
   }

   /**
    * The fee that will be charged on this transaction, as accepted by the sender.
    *
    * @return fee
    **/
   @JsonProperty("fee")
   @ApiModelProperty(value = "The fee that will be charged on this transaction, as accepted by the sender.")
   public LedgerAmount getFee() {
      return fee;
   }

   public void setFee(LedgerAmount fee) {
      this.fee = fee;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      final MoneyTransferAuthRequest that = (MoneyTransferAuthRequest) o;
      return Objects.equals(amount, that.amount) && Objects.equals(senderDetails, that.senderDetails) && Objects.equals(recipientDetails,
            that.recipientDetails) && Objects.equals(pin, that.pin) && Objects.equals(customerProfileId,
            that.customerProfileId) && Objects.equals(newCustomer, that.newCustomer) && Objects.equals(fee, that.fee);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(),
            amount,
            senderDetails,
            recipientDetails,
            pin,
            customerProfileId,
            newCustomer,
            fee);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferAuthRequest {\n");
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
      sb.append("    senderDetails: ").append(Utils.toIndentedString(senderDetails)).append("\n");
      sb.append("    recipientDetails: ").append(Utils.toIndentedString(recipientDetails)).append("\n");
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("    customerProfileId: ").append(Utils.toIndentedString(customerProfileId)).append("\n");
      sb.append("    newCustomer: ").append(Utils.toIndentedString(newCustomer)).append("\n");
      sb.append("    fee: ").append(Utils.toIndentedString(fee)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
