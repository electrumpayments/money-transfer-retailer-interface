package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Originator;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains a fee quote for the money transfer.
 */
public class MoneyTransferFeeQuote {

   @JsonProperty("originator")
   private Originator originator = null;

   @JsonProperty("receiver")
   private Institution receiver = null;

   @JsonProperty("settlementEntity")
   private Institution settlementEntity = null;

   @JsonProperty("feeQuote")
   private FeeQuote feeQuote = null;

   @JsonProperty("senderDetails")
   private PersonalDetails senderDetails;

   @JsonProperty("recipientDetails")
   private PersonalDetails recipientDetails;

   @JsonProperty("quoteId")
   private String quoteId;

   @JsonProperty("expiryDateTime")
   private DateTime expiryDateTime;

   public MoneyTransferFeeQuote originator(Originator originator) {
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

   public MoneyTransferFeeQuote receiver(Institution receiver) {
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

   public MoneyTransferFeeQuote settlementEntity(Institution settlementEntity) {
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

   public MoneyTransferFeeQuote feeQuote(FeeQuote feeQuote) {
      this.feeQuote = feeQuote;
      return this;
   }

   /**
    * Contains details of the fee that will be charged for the transfer.
    *
    * @return feeQuote
    **/
   @JsonProperty("feeQuote")
   @ApiModelProperty(value = "Contains details of the fee that will be charged for the transfer.")
   @Valid
   public FeeQuote getFeeQuote() {
      return feeQuote;
   }

   public void setFeeQuote(FeeQuote feeQuote) {
      this.feeQuote = feeQuote;
   }

   public MoneyTransferFeeQuote senderDetails(PersonalDetails senderDetails) {
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

   public MoneyTransferFeeQuote recipientDetails(PersonalDetails recipientDetails) {
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

   public MoneyTransferFeeQuote quoteId(String quoteId) {
      this.quoteId = quoteId;
      return this;
   }

   /**
    * A reference to this quote. This maybe provided when an order is created to link an order to a specific quote.
    *
    * @return quoteId
    **/
   @JsonProperty("quoteId")
   @ApiModelProperty(value = "A reference to this quote. This maybe provided when an order is created to link an order to a specific quote.")
   @Valid
   public String getQuoteId() {
      return quoteId;
   }

   public void setQuoteId(String quoteId) {
      this.quoteId = quoteId;
   }

   public MoneyTransferFeeQuote expiryDateTime(DateTime expiryDateTime) {
      this.expiryDateTime = expiryDateTime;
      return this;
   }

   /**
    * The date and time when the quote expires.
    *
    * @return expiryDateTime
    **/
   @JsonProperty("expiryDateTime")
   @ApiModelProperty(value = "The date and time when the quote expires.")
   @Valid
   public DateTime getExpiryDateTime() {
      return expiryDateTime;
   }

   public void setExpiryDateTime(DateTime expiryDateTime) {
      this.expiryDateTime = expiryDateTime;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MoneyTransferFeeQuote moneyTransferFeeQuote = (MoneyTransferFeeQuote) o;
      return Objects.equals(this.originator, moneyTransferFeeQuote.originator)
            && Objects.equals(this.receiver, moneyTransferFeeQuote.receiver)
            && Objects.equals(this.settlementEntity, moneyTransferFeeQuote.settlementEntity)
            && Objects.equals(this.feeQuote, moneyTransferFeeQuote.feeQuote)
            && Objects.equals(this.senderDetails, moneyTransferFeeQuote.senderDetails)
            && Objects.equals(this.recipientDetails, moneyTransferFeeQuote.recipientDetails)
            && Objects.equals(this.quoteId, moneyTransferFeeQuote.quoteId)
            && Objects.equals(this.expiryDateTime, moneyTransferFeeQuote.expiryDateTime);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            originator,
            receiver,
            settlementEntity,
            feeQuote,
            senderDetails,
            recipientDetails,
            quoteId,
            expiryDateTime);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferFeeQuote {\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    feeQuote: ").append(Utils.toIndentedString(feeQuote)).append("\n");
      sb.append("    senderDetails: ").append(Utils.toIndentedString(senderDetails)).append("\n");
      sb.append("    recipientDetails: ").append(Utils.toIndentedString(recipientDetails)).append("\n");
      sb.append("    quoteId: ").append(Utils.toIndentedString(quoteId)).append("\n");
      sb.append("    expiryDateTime: ").append(Utils.toIndentedString(expiryDateTime)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
