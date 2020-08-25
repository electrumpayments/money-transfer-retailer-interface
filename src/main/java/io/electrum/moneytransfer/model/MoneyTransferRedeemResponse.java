package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.interfaces.HasAmounts;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains the data returned by a call to the redeemOrder operation.
 */
@ApiModel(description = "Contains the data returned by a call to the redeemOrder operation.")
public class MoneyTransferRedeemResponse extends Transaction implements HasAmounts {

   private LedgerAmount amount = null;

   private String orderId = null;

   private String customerProfileId = null;

   private Amounts amounts = null;

   /**
    * The amount to be transferred. This field may be deprecated in a future version of the API. We encourage you to
    * please also populate the 'amounts.requestAmount' field with this information.
    *
    * @return amount
    **/
   @JsonProperty("amount")
   @ApiModelProperty(required = true, value = "The amount to be transferred. This field may be deprecated in a future version of the API. "
         + "We encourage you to please also populate the 'amounts.requestAmount' field with this information.")
   @Valid
   @NotNull
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public MoneyTransferRedeemResponse orderId(String orderId) {
      this.orderId = orderId;
      return this;
   }

   /**
    * Reference used by the service provider to uniquely identify the money transfer order on their system. This field
    * can be used if the provider supplies a supplementary reference for the order in addition to the orderRedeemRef.
    * Note that any reference issued by the provider that is specific to a particular leg of the order process should be
    * set as a ThirdPartyIdentifier (i.e. the authorization and redeem legs of the order should each have its own
    * reference).
    *
    * @return orderId
    **/
   @JsonProperty("orderId")
   @ApiModelProperty(required = true, value = "Reference used by the service provider to uniquely identify the money transfer order on their system. This field can be used if the provider supplies a supplementary reference for the order in addition to the orderRedeemRef. Note that any reference issued by the provider that is specific to a particular leg of the order process should be set as a ThirdPartyIdentifier (i.e. the authorization and redeem legs of the order should each have its own reference).")
   @Valid
   @NotNull
   public String getOrderId() {
      return orderId;
   }

   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }

   public MoneyTransferRedeemResponse customerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
      return this;
   }

   /**
    * Get customer profile id
    *
    * @return customer profile id
    */
   @JsonProperty("customerProfileId")
   @ApiModelProperty(value = "Uniquely identifies customer's profile on the upstream entity's system.")
   public String getCustomerProfileId() {
      return customerProfileId;
   }

   public void setCustomerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
   }

   public MoneyTransferRedeemResponse amounts(Amounts amounts) {
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
      final MoneyTransferRedeemResponse that = (MoneyTransferRedeemResponse) o;
      return Objects.equals(amount, that.amount) && Objects.equals(orderId, that.orderId)
            && Objects.equals(customerProfileId, that.customerProfileId) && Objects.equals(amounts, that.amounts);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), amount, orderId, customerProfileId, amounts);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferRedeemResponse {\n");

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
      sb.append("    orderId: ").append(Utils.toIndentedString(orderId)).append("\n");
      sb.append("    customerProfileId: ").append(Utils.toIndentedString(customerProfileId)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
