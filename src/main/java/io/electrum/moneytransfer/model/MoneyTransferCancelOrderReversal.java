package io.electrum.moneytransfer.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModel;

/**
 * An advice that notifies that the outcome of an authorisation transaction be reversed. This can be either due to
 * cashier cancellation, or upstream timeout.
 */
@ApiModel(description = "An advice that notifies that the outcome of an authorisation transaction be reversed. This can be either due to cashier cancellation, or upstream timeout.")
public class MoneyTransferCancelOrderReversal extends BasicReversal {

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferCancelOrderReversal {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
