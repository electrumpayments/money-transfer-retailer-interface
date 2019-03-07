package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains the data returned by a call to the redeemOrder operation.
 */
@ApiModel(description = "Contains the data returned by a call to the redeemOrder operation.")
public class MoneyTransferRedeemResponse extends Transaction {

   private LedgerAmount amount = null;

   private String orderId = null;

   private String customerProfileId = null;

   /**
    * Get amount
    * 
    * @return amount
    **/
   @JsonProperty("amount")
   @ApiModelProperty(required = true, value = "")
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
            && Objects.equals(customerProfileId, that.customerProfileId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), amount, orderId, customerProfileId);
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
      sb.append("}");
      return sb.toString();
   }
}
