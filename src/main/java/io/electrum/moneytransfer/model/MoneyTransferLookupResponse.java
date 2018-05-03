package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Originator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains the data returned by a call to the lookupOrder operation.
 */
@ApiModel(description = "Contains the data returned by a call to the lookupOrder operation.")
public class MoneyTransferLookupResponse {
   @JsonProperty("amount")
   private LedgerAmount amount = null;

   /**
    * The status of the order
    */
   public enum StatusEnum {
      UNREDEEMED("UNREDEEMED"),

      REDEEMED("REDEEMED"),

      CANCELLED("CANCELLED"),

      EXPIRED("EXPIRED");

      private String value;

      StatusEnum(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }

      @JsonCreator
      public static StatusEnum fromValue(String text) {
         for (StatusEnum b : StatusEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
               return b;
            }
         }
         return null;
      }
   }

   @JsonProperty("status")
   private StatusEnum status = null;

   @JsonProperty("originator")
   private Originator originator = null;

   @JsonProperty("receiver")
   private Institution receiver = null;

   public MoneyTransferLookupResponse amount(LedgerAmount amount) {
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

   public MoneyTransferLookupResponse status(StatusEnum status) {
      this.status = status;
      return this;
   }

   /**
    * The status of the order
    * 
    * @return status
    **/
   @JsonProperty("status")
   @ApiModelProperty(value = "The status of the order")
   public StatusEnum getStatus() {
      return status;
   }

   public void setStatus(StatusEnum status) {
      this.status = status;
   }

   public MoneyTransferLookupResponse originator(Originator originator) {
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

   public MoneyTransferLookupResponse receiver(Institution receiver) {
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

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MoneyTransferLookupResponse moneyTransferLookupResponse = (MoneyTransferLookupResponse) o;
      return Objects.equals(this.amount, moneyTransferLookupResponse.amount)
            && Objects.equals(this.status, moneyTransferLookupResponse.status)
            && Objects.equals(this.originator, moneyTransferLookupResponse.originator)
            && Objects.equals(this.receiver, moneyTransferLookupResponse.receiver);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, status, originator, receiver);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferLookupResponse {\n");

      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    status: ").append(Utils.toIndentedString(status)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
