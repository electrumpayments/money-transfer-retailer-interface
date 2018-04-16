package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModelProperty;

/**
 * Details of the fee charged by the provider for a money transfer order.
 */
public class FeeQuote {
   @JsonProperty("feeAmount")
   private LedgerAmount feeAmount = null;

   @JsonProperty("transferAmount")
   private LedgerAmount transferAmount = null;

   @JsonProperty("totalAmount")
   private LedgerAmount totalAmount = null;

   public FeeQuote feeAmount(LedgerAmount feeAmount) {
      this.feeAmount = feeAmount;
      return this;
   }

   /**
    * The fee to be charged for the transaction.
    *
    * @return feeAmount
    **/
   @ApiModelProperty(required = true, value = "The fee to be charged for the transaction.")
   @NotNull
   public LedgerAmount getFeeAmount() {
      return feeAmount;
   }

   public void setFeeAmount(LedgerAmount feeAmount) {
      this.feeAmount = feeAmount;
   }

   public FeeQuote transferAmount(LedgerAmount transferAmount) {
      this.transferAmount = transferAmount;
      return this;
   }

   /**
    * The amount to be transferred to the recipient.
    *
    * @return transferAmount
    **/
   @ApiModelProperty(required = true, value = "The amount to be transferred to the recipient.")
   @NotNull
   public LedgerAmount getTransferAmount() {
      return transferAmount;
   }

   public void setTransferAmount(LedgerAmount transferAmount) {
      this.transferAmount = transferAmount;
   }

   public FeeQuote totalAmount(LedgerAmount totalAmount) {
      this.totalAmount = totalAmount;
      return this;
   }

   /**
    * Total amount payable by the sender, including fee.
    *
    * @return totalAmount
    **/
   @ApiModelProperty(required = true, value = "Total amount payable by the sender, including fee.")
   @NotNull
   public LedgerAmount getTotalAmount() {
      return totalAmount;
   }

   public void setTotalAmount(LedgerAmount totalAmount) {
      this.totalAmount = totalAmount;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      FeeQuote feeQuote = (FeeQuote) o;
      return Objects.equals(this.feeAmount, feeQuote.feeAmount)
            && Objects.equals(this.transferAmount, feeQuote.transferAmount)
            && Objects.equals(this.totalAmount, feeQuote.totalAmount);
   }

   @Override
   public int hashCode() {
      return Objects.hash(feeAmount, transferAmount, totalAmount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class FeeQuote {\n");
      sb.append("    feeAmount: ").append(Utils.toIndentedString(feeAmount)).append("\n");
      sb.append("    transferAmount: ").append(Utils.toIndentedString(transferAmount)).append("\n");
      sb.append("    totalAmount: ").append(Utils.toIndentedString(totalAmount)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
