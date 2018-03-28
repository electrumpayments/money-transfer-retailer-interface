package io.electrum.moneytransfer.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;
import org.joda.time.DateTime;

import java.util.List;

/**
 * An advice that notifies that the outcome of an authorisation transaction be reversed. This can be either due to
 * cashier cancellation, or upstream timeout.
 */
@ApiModel(
      description = "An advice that notifies that the outcome of an authorisation transaction be reversed. This can be either due to cashier cancellation, or upstream timeout.")
public class MoneyTransferReversal extends BasicReversal {

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
