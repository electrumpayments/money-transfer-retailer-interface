package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.interfaces.HasAmounts;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.EncryptedPin;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Used to submit data in a call to the createOrder operation.
 */
@ApiModel(description = "Used to submit data in a call to the createOrder operation.")
public class MoneyTransferAuthRequest extends Transaction implements HasAmounts {

   private LedgerAmount amount = null;

   private PersonalDetails senderDetails = null;

   private PersonalDetails recipientDetails = null;

   private EncryptedPin pin;

   private String customerProfileId = null;

   private Boolean newCustomer = null;

   private LedgerAmount fee = null;

   private String quoteId = null;

   private PurposeOfRemittance purposeOfRemittance = null;

   private Relationship recipientRelationship = null;

   private Amounts amounts = null;

   public MoneyTransferAuthRequest amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * The amount to be transferred. This field may be deprecated in a future version of the API. We encourage you to
    * please also populate the 'amounts.requestAmount' field with this information.
    *
    * @return amount
    **/
   @JsonProperty("amount")
   @ApiModelProperty(required = true, value = "The amount to be transferred. This field may be deprecated in a future "
         + "version of the API. We encourage you to please also populate the 'amounts.requestAmount' field with this information.")
   @Valid
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
   @Valid
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
    * Personal details of the intended recipient. Conditionally optional - please confirm with your integration partner
    * whether this is required.
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
   @Valid
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
   @Valid
   public LedgerAmount getFee() {
      return fee;
   }

   public void setFee(LedgerAmount fee) {
      this.fee = fee;
   }

   public MoneyTransferAuthRequest quoteId(String quoteId) {
      this.quoteId = quoteId;
      return this;
   }

   /**
    * The value returned in a previous MoneyTransferFeeQuoteResponse object. This allows a specific money transfer order
    * to be linked to a specific quote.
    *
    * @return quoteId
    **/
   @JsonProperty("quoteId")
   @ApiModelProperty(value = "The value returned in a previous MoneyTransferFeeQuoteResponse object. This allows a specific money transfer order to be linked to a specific quote.")
   public String getQuoteId() {
      return quoteId;
   }

   public void setQuoteId(String quoteId) {
      this.quoteId = quoteId;
   }

   public MoneyTransferAuthRequest purposeOfRemittance(PurposeOfRemittance purposeOfRemittance) {
      this.purposeOfRemittance = purposeOfRemittance;
      return this;
   }

   /**
    * The reason the sender is performing a money transfer. This may be tracked for compliance/reporting purposes.
    *
    * @return purposeOfRemittance
    **/
   @JsonProperty("purposeOfRemittance")
   @ApiModelProperty(value = "The reason the sender is performing a money transfer. This may be tracked for compliance/reporting purposes.")
   public PurposeOfRemittance getPurposeOfRemittance() {
      return purposeOfRemittance;
   }

   public void setPurposeOfRemittance(PurposeOfRemittance purposeOfRemittance) {
      this.purposeOfRemittance = purposeOfRemittance;
   }

   public MoneyTransferAuthRequest relationship(Relationship relationship) {
      this.recipientRelationship = relationship;
      return this;
   }

   /**
    * The relationship between the sender and recipient of the money transfer. This may be tracked for
    * compliance/reporting purposes.
    *
    * @return recipientRelationship
    **/
   @JsonProperty("recipientRelationship")
   @ApiModelProperty(value = "The recipientRelationship between the sender and recipient of the money transfer. This may be tracked for compliance/reporting purposes.")
   public Relationship getRelationship() {
      return recipientRelationship;
   }

   public void setRelationship(Relationship relationship) {
      this.recipientRelationship = relationship;
   }

   public MoneyTransferAuthRequest amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   /**
    * Amounts which make up the transaction. The existing 'amount' field currently takes precedence over this 'amounts'
    * field, however the use of this 'amounts' field is encouraged. The 'amount' field may be deprecated in a future
    * version of this API.
    *
    * @return amounts
    **/
   @JsonProperty("amounts")
   @ApiModelProperty(value = "Amounts which make up the transaction. The existing 'amount' field currently takes "
         + "precedence over this 'amounts' field, however the use of this 'amounts' field is encouraged. The 'amount' "
         + "field may be deprecated in a future version of this API.")
   @Valid
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
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
      return Objects.equals(amount, that.amount) && Objects.equals(senderDetails, that.senderDetails)
            && Objects.equals(recipientDetails, that.recipientDetails) && Objects.equals(pin, that.pin)
            && Objects.equals(customerProfileId, that.customerProfileId)
            && Objects.equals(newCustomer, that.newCustomer) && Objects.equals(fee, that.fee)
            && Objects.equals(quoteId, that.quoteId) && Objects.equals(purposeOfRemittance, that.purposeOfRemittance)
            && Objects.equals(recipientRelationship, that.recipientRelationship)
            && Objects.equals(amounts, that.amounts);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            super.hashCode(),
            amount,
            senderDetails,
            recipientDetails,
            pin,
            customerProfileId,
            newCustomer,
            fee,
            quoteId,
            purposeOfRemittance,
            recipientRelationship,
            amounts);
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
      sb.append("    quoteId: ").append(Utils.toIndentedString(quoteId)).append("\n");
      sb.append("    purposeOfRemittance: ").append(Utils.toIndentedString(purposeOfRemittance)).append("\n");
      sb.append("    recipientRelationship: ").append(Utils.toIndentedString(recipientRelationship)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
