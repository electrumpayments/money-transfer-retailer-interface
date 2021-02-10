package io.electrum.moneytransfer.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.EncryptedPin;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Used to update the pin on a order
 */
@ApiModel(description = "Used to update the pin on a order.")
public class MoneyTransferOrderPinUpdateRequest extends Transaction {

   @JsonProperty("pin")
   @NotNull
   private EncryptedPin pin = null;

   @JsonProperty("orderRedeemRef")
   private String orderRedeemRef = null;

   @JsonProperty("remittanceRef")
   private String remittanceRef = null;

   @JsonProperty("orderId")
   private String orderId = null;

   @JsonProperty("customerProfileId")
   private String customerProfileId = null;

   @JsonProperty("orderRedeemRefAlt")
   private String orderRedeemRefAlt = null;

   /**
    * The encrypted PIN to be used by the recipient to redeem the order.
    *
    * @return pin
    **/
   @JsonProperty("pin")
   @ApiModelProperty(value = "The encrypted PIN to be used by the recipient to redeem the order.")
   @Valid
   public EncryptedPin getPin() {
      return pin;
   }

   public void setPin(EncryptedPin pin) {
      this.pin = pin;
   }

   public MoneyTransferOrderPinUpdateRequest pin(EncryptedPin pin) {
      this.pin = pin;
      return this;
   }

   /**
    * Reference used by the recipient to redeem the order. This must be printed on the receipt.
    *
    * @return orderRedeemRef
    **/
   @JsonProperty("orderRedeemRef")
   @ApiModelProperty(value = "Reference used by the recipient to redeem the order. This must be printed on the receipt.")
   @Valid
   public String getOrderRedeemRef() {
      return orderRedeemRef;
   }

   public void setOrderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
   }

   public MoneyTransferOrderPinUpdateRequest orderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
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
   @ApiModelProperty(value = "Reference used by the service provider to uniquely identify the money transfer order on their system. This field can be used if the provider supplies a supplementary reference for the order in addition to the orderRedeemRef. Note that any reference issued by the provider that is specific to a particular leg of the order process should be set as a ThirdPartyIdentifier (i.e. the authorization and redeem legs of the order should each have its own reference).")
   public String getOrderId() {
      return orderId;
   }

   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }

   public MoneyTransferOrderPinUpdateRequest orderId(String orderId) {
      this.orderId = orderId;
      return this;
   }

   /**
    * Uniquely identifies a customer's profile on the upstream entity's system.
    *
    * @return customerProfileId
    **/
   @JsonProperty("customerProfileId")
   @ApiModelProperty(value = "Uniquely identifies customer's profile on the upstream entity's system.")
   public String getCustomerProfileId() {
      return customerProfileId;
   }

   public void setCustomerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
   }

   public MoneyTransferOrderPinUpdateRequest customerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
      return this;
   }

   /**
    * An alternate reference used by the recipient to redeem the order. This must be printed on the receipt.
    *
    * @return orderRedeemRefAlt
    **/
   @JsonProperty("orderRedeemRefAlt")
   @ApiModelProperty(value = "An alternate reference used by the recipient to redeem the order. This must be printed on the receipt.")
   @Valid
   public String getOrderRedeemRefAlt() {
      return orderRedeemRefAlt;
   }

   public void setOrderRedeemRefAlt(String orderRedeemRefAlt) {
      this.orderRedeemRefAlt = orderRedeemRefAlt;
   }

   public MoneyTransferOrderPinUpdateRequest orderRedeemRefAlt(String orderRedeemRefAlt) {
      this.orderRedeemRefAlt = orderRedeemRefAlt;
      return this;
   }

   public String getRemittanceRef() {
      return remittanceRef;
   }

   public void setRemittanceRef(String remittanceRef) {
      this.remittanceRef = remittanceRef;
   }

   public MoneyTransferOrderPinUpdateRequest remittanceRef(String remittanceRef) {
      this.remittanceRef = remittanceRef;
      return this;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferOrderPinUpdateRequest {\n");
      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("    tranType: ").append(Utils.toIndentedString(tranType)).append("\n");
      sb.append("    srcAccType: ").append(Utils.toIndentedString(srcAccType)).append("\n");
      sb.append("    destAccType: ").append(Utils.toIndentedString(destAccType)).append("\n");
      sb.append("    stan: ").append(Utils.toIndentedString(stan));
      sb.append("    rrn: ").append(Utils.toIndentedString(rrn));
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("    orderRedeemRef: ").append(Utils.toIndentedString(orderRedeemRef)).append("\n");
      sb.append("    remittanceRef: ").append(Utils.toIndentedString(remittanceRef)).append("\n");
      sb.append("    orderId: ").append(Utils.toIndentedString(orderId)).append("\n");
      sb.append("    customerProfileId: ").append(Utils.toIndentedString(customerProfileId)).append("\n");
      sb.append("    orderRedeemRefAlt: ").append(Utils.toIndentedString(orderRedeemRefAlt)).append("\n");
      sb.append("}");
      return sb.toString();
   }

}
