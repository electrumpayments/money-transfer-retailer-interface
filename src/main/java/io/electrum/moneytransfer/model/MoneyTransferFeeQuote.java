package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

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

   @JsonProperty("feeQuote")
   private FeeQuote feeQuote = null;

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
   @NotNull
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
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
   public FeeQuote getFeeQuote() {
      return feeQuote;
   }

   public void setFeeQuote(FeeQuote feeQuote) {
      this.feeQuote = feeQuote;
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
            && Objects.equals(this.feeQuote, moneyTransferFeeQuote.feeQuote);
   }

   @Override
   public int hashCode() {
      return Objects.hash(originator, receiver, feeQuote);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferAdminMessage {\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    feeQuote: ").append(Utils.toIndentedString(feeQuote)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
