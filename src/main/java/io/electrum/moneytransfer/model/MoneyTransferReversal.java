package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * An advice that notifies that the outcome of an authorisation transaction be reversed. This can be either due to
 * cashier cancellation, or upstream timeout.
 */
@ApiModel(
      description = "An advice that notifies that the outcome of an authorisation transaction be reversed. This can be either due to cashier cancellation, or upstream timeout.")
public class MoneyTransferReversal extends BasicReversal {

   protected LedgerAmount amount;

   MoneyTransferReversal amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   @ApiModelProperty(required = true, value = "The amount to be reversed, can be the full order amount or less as is in the case of partial redemptions")
   @JsonProperty("amount")
   @NotNull
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public MoneyTransferReversal id(String id) {
      this.id = id;
      return this;
   }

   public MoneyTransferReversal requestId(String requestId) {
      this.requestId = requestId;
      return this;
   }

   public MoneyTransferReversal time(DateTime time) {
      this.time = time;
      return this;
   }

   public MoneyTransferReversal thirdPartyIdentifiers(List<ThirdPartyIdentifier> thirdPartyIdentifiers) {
      this.thirdPartyIdentifiers = thirdPartyIdentifiers;
      return this;
   }

   public MoneyTransferReversal addThirdPartyIdentifiersItem(ThirdPartyIdentifier thirdPartyIdentifiersItem) {
      this.thirdPartyIdentifiers.add(thirdPartyIdentifiersItem);
      return this;
   }

   public MoneyTransferReversal reversalReason(ReversalReason reversalReason) {
      this.reversalReason = reversalReason;
      return this;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferReversal {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
