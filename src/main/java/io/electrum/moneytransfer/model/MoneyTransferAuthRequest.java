package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Used to submit data in a call to the createOrder operation.
 */
@ApiModel(description = "Used to submit data in a call to the createOrder operation.")
public class MoneyTransferAuthRequest extends Transaction {

   private LedgerAmount amount = null;

   private PersonalDetails senderDetails = null;

   private PersonalDetails recipientDetails = null;

   private String pinBlock = null;

   private String customerProfileId = null;

   private Boolean newCustomer = null;

   public MoneyTransferAuthRequest amount(LedgerAmount amount) {
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
    * Personal details of a customer.
    *
    * @return recipientDetails
    **/
   @JsonProperty("recipientDetails")
   @ApiModelProperty(required = true, value = "Personal details of a customer.")
   @NotNull
   public PersonalDetails getRecipientDetails() {
      return recipientDetails;
   }

   public void setRecipientDetails(PersonalDetails recipientDetails) {
      this.recipientDetails = recipientDetails;
   }

   public MoneyTransferAuthRequest pinBlock(String pinBlock) {
      this.pinBlock = pinBlock;
      return this;
   }

   /**
    * Hexadecimal string representing the encrypted PIN to be used by the recipient to redeem the order.
    *
    * @return pinBlock
    **/
   @JsonProperty("pinBlock")
   @ApiModelProperty(required = true,
         value = "Hexadecimal string representing the encrypted PIN to be used by the recipient to redeem the order.")
   @NotNull
   @Pattern(regexp = "[a-fA-F0-9]{16}")
   public String getPinBlock() {
      return pinBlock;
   }

   public void setPinBlock(String pinBlock) {
      this.pinBlock = pinBlock;
   }

   /**
    * Get customerDetails
    *
    * @return customerDetails
    **/
   @JsonProperty("customerProfileId")
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
   @ApiModelProperty(
         value = "An optional flag indicating whether the customer placing the order is already registered on the provider's system.")
   public Boolean getNewCustomer() {
      return newCustomer;
   }

   public void setNewCustomer(Boolean newCustomer) {
      this.newCustomer = newCustomer;
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
      sb.append("    pinBlock: ").append(Utils.toIndentedString(pinBlock)).append("\n");
      sb.append("    customerProfileId: ").append(Utils.toIndentedString(customerProfileId)).append("\n");
      sb.append("    newCustomer: ").append(Utils.toIndentedString(newCustomer)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
