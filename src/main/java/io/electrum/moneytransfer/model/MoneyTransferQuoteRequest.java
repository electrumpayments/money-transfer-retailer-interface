package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Originator;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains information necessary to obtain a quote for the money transfer.
 */
public class MoneyTransferQuoteRequest {

   @JsonProperty("originator")
   private Originator originator = null;

   @JsonProperty("receiver")
   private Institution receiver = null;

   @JsonProperty("settlementEntity")
   private Institution settlementEntity = null;

   @JsonProperty("senderDetails")
   private PersonalDetails senderDetails;

   @JsonProperty("recipientDetails")
   private PersonalDetails recipientDetails;

   @JsonProperty("amount")
   private LedgerAmount amount;

   @JsonProperty("amountIncludesFees")
   private boolean amountIncludesFees;

   public MoneyTransferQuoteRequest originator(Originator originator) {
      this.originator = originator;
      return this;
   }

   /**
    * The location where the money transfer is being initiated.
    *
    * @return originator
    **/
   @JsonProperty("originator")
   @ApiModelProperty(required = true, value = "The location where the money transfer is being initiated.")
   @Valid
   @NotNull
   public Originator getOriginator() {
      return originator;
   }

   public void setOriginator(Originator originator) {
      this.originator = originator;
   }

   public MoneyTransferQuoteRequest receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   /**
    * The service provider who is to effect the money transfer.
    *
    * @return receiver
    **/
   @JsonProperty("receiver")
   @ApiModelProperty(required = true, value = "The service provider who is to effect the money transfer.")
   @Valid
   @NotNull
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   public MoneyTransferQuoteRequest settlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
      return this;
   }

   /**
    * Data relating to the entity with whom the Merchant will settle the transaction..
    *
    * @return settlementEntity
    **/
   @JsonProperty("settlementEntity")
   @ApiModelProperty(required = false, value = "Data relating to the entity with whom the Merchant will settle the transaction.")
   @Valid
   public Institution getSettlementEntity() {
      return settlementEntity;
   }

   public void setSettlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
   }

   public MoneyTransferQuoteRequest senderDetails(PersonalDetails senderDetails) {
      this.senderDetails = senderDetails;
      return this;
   }

   /**
    * Contains details of the sender of the money transfer funds.
    *
    * @return senderDetails
    **/
   @JsonProperty("senderDetails")
   @ApiModelProperty(value = "Contains details of the sender of the money transfer funds.")
   @Valid
   public PersonalDetails getSenderDetails() {
      return senderDetails;
   }

   public void setSenderDetails(PersonalDetails senderDetails) {
      this.senderDetails = senderDetails;
   }

   public MoneyTransferQuoteRequest recipientDetails(PersonalDetails recipientDetails) {
      this.recipientDetails = recipientDetails;
      return this;
   }

   /**
    * Contains details of the recipient of the money transfer funds.
    *
    * @return recipientDetails
    **/
   @JsonProperty("recipientDetails")
   @ApiModelProperty(value = "Contains details of the recipient of the money transfer funds.")
   @Valid
   public PersonalDetails getRecipientDetails() {
      return recipientDetails;
   }

   public void setRecipientDetails(PersonalDetails recipientDetails) {
      this.recipientDetails = recipientDetails;
   }

   public MoneyTransferQuoteRequest amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   /**
    * The amount to be transferred. Whether this is the amount the sender pays or the amount the recipient is to receive
    * is determined by the amountIncludesFees flag.
    *
    * @return amount
    **/
   @JsonProperty("amount")
   @ApiModelProperty(required = true, value = "The amount to be transferred. Whether this is the amount the sender pays or the amount the recipient is to receive is determined by the amountIncludesFees flag.")
   @Valid
   @NotNull
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public MoneyTransferQuoteRequest amountIncludesFees(boolean amountIncludesFees) {
      this.amountIncludesFees = amountIncludesFees;
      return this;
   }

   /**
    * Indicates whether the amount in this MoneyTransferQuoteRequest is the amount the sender is willing to pay
    * ({@code false}) or the amount the recipient is to receive ({@code true}).
    *
    * @return amountIncludesFees
    **/
   @JsonProperty("amountIncludesFees")
   @ApiModelProperty(required = true, value = "Indicates whether the amount in this MoneyTransferQuoteRequest is the amount the sender is willing to pay (false) or the amount the recipient is to receive (true).")
   @Valid
   public boolean getAmountIncludesFees() {
      return amountIncludesFees;
   }

   public void setAmountIncludesFees(boolean amountIncludesFees) {
      this.amountIncludesFees = amountIncludesFees;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MoneyTransferQuoteRequest moneyTransferFeeQuote = (MoneyTransferQuoteRequest) o;
      return Objects.equals(this.originator, moneyTransferFeeQuote.originator)
            && Objects.equals(this.receiver, moneyTransferFeeQuote.receiver)
            && Objects.equals(this.settlementEntity, moneyTransferFeeQuote.settlementEntity)
            && Objects.equals(this.senderDetails, moneyTransferFeeQuote.senderDetails)
            && Objects.equals(this.recipientDetails, moneyTransferFeeQuote.recipientDetails)
            && Objects.equals(this.amount, moneyTransferFeeQuote.amount)
            && Objects.equals(this.amountIncludesFees, moneyTransferFeeQuote.amountIncludesFees);
   }

   @Override
   public int hashCode() {
      return Objects
            .hash(originator, receiver, settlementEntity, senderDetails, recipientDetails, amount, amountIncludesFees);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferQuoteRequest {\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    senderDetails: ").append(Utils.toIndentedString(senderDetails)).append("\n");
      sb.append("    recipientDetails: ").append(Utils.toIndentedString(recipientDetails)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    amountIncludesFees: ").append(Utils.toIndentedString(amountIncludesFees)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
