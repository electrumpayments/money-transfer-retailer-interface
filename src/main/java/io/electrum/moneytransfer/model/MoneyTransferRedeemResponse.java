/*
 * Money Transfer Service Interface
 * The Electrum Money Transfer Service Interface is an API designed to enable retailers to integrate with multiple counter-to-counter money transfer service providers via a single interface.  The basic procedure by which a counter-to-counter money transfer occurs is as follows: 1. A customer wishing to send money to a recipient registers a profile with the service provider. 2. The sender creates an order by making a cash payment at one of the retailer's points of sale (POS). The payment is linked to a unique payout reference generated by the service provider and a sender-selected PIN. 3. The sender supplies the recipient with the payout reference and PIN. 4. The recipient redeems the order at another POS by supplying the payout reference and PIN.  This API defines a RESTful interface that supports the following functionality: * Creation and querying of customer profiles. * Order creation (a dual message pair transaction consisting of an online payment authorization followed a store-and-forward confirmation or reversal). * Order lookup. * Order redemption. (a dual message pair transaction consisting of an online redeem authorization followed by a store-and-forward confirmation or reversal).  Note that because of the requirements of different service providers, some fields that are optional according to this specification may be mandatory for certain providers. For guidelines on how to implement this API, please contact both Electrum and the relevant service provider(s). 
 *
 * OpenAPI spec version: 1.0.1
 * Contact: support@electrum.co.za
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.electrum.moneytransfer.model;

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
   @NotNull
   public String getOrderId() {
      return orderId;
   }

   public void setOrderId(String orderId) {
      this.orderId = orderId;
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
      sb.append("}");
      return sb.toString();
   }
}
