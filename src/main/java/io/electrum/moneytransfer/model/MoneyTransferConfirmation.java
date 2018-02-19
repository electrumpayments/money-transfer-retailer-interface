package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicAdvice;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.swagger.annotations.ApiModel;
import org.joda.time.DateTime;

import java.util.List;

/**
 * An advice that notifies of the positive completion of a transaction.
 */
@ApiModel(description = "An advice that notifies of the positive completion of a transaction.")
public class MoneyTransferConfirmation extends BasicAdvice {

   public MoneyTransferConfirmation id(String id) {
      this.id = id;
      return this;
   }

   public MoneyTransferConfirmation requestId(String requestId) {
      this.requestId = requestId;
      return this;
   }

   public MoneyTransferConfirmation time(DateTime time) {
      this.time = time;
      return this;
   }

   public MoneyTransferConfirmation thirdPartyIdentifiers(List<ThirdPartyIdentifier> thirdPartyIdentifiers) {
      this.thirdPartyIdentifiers = thirdPartyIdentifiers;
      return this;
   }

   public MoneyTransferConfirmation addThirdPartyIdentifiersItem(ThirdPartyIdentifier thirdPartyIdentifiersItem) {
      this.thirdPartyIdentifiers.add(thirdPartyIdentifiersItem);
      return this;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferConfirmation {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
