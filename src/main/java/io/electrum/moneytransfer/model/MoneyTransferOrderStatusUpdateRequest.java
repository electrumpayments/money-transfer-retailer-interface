package io.electrum.moneytransfer.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.AccountType;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.SlipData;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.electrum.vas.model.TranType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Used to describe a change to the status of an order.
 */
@ApiModel(description = "Used to describe a change to the status of an order.")
public class MoneyTransferOrderStatusUpdateRequest {
   @JsonProperty("updateTime")
   @ApiModelProperty(required = true, value = "The date and time at which the order was updated on the money transfer service provider's system. This is relevant so that if multiple status updates were sent, but delivered out of order, the receiving system can ignore any older status updates. The format shall be as defined for date-time in RFC 3339 section 5.6. It is recommended that the optional time-secfrac be included up to millisecond precision.")
   @Valid
   @NotNull
   private DateTime updateTime = null;

   @JsonProperty("orderRedeemRef")
   @ApiModelProperty(value = "Reference used by the recipient to redeem the order. (this is the same as the query param in the lookupOrder operation). Should be supplied if remittanceRef is not supplied.")
   @Valid
   private String orderRedeemRef = null;

   @JsonProperty("remittanceRef")
   @ApiModelProperty(value = "Reference for a remittance transaction. Should be supplied if orderRedeemRef is not supplied.")
   @Valid
   private String remittanceRef = null;

   @JsonProperty("status")
   @ApiModelProperty(required = true, value = "The new status of the order.")
   @Valid
   @NotNull
   private OrderStatus status = null;

   @ApiModelProperty(value = "Data relating to the originator of the transaction.")
   @JsonProperty("originator")
   @Valid
   private Originator originator = null;

   @ApiModelProperty(value = "Data relating to the sender of MoneyTransferOrderStatusUpdateRequest.")
   @JsonProperty("client")
   @Valid
   private Institution client = null;

   @ApiModelProperty(value = "Data relating to the entity with whom the Merchant will settle the transaction.")
   @JsonProperty("settlementEntity")
   @Valid
   private Institution settlementEntity = null;

   @ApiModelProperty(value = "Data relating to the entity which ultimately processes the request.")
   @JsonProperty("receiver")
   @Valid
   private Institution receiver = null;

   @ApiModelProperty(value = "An array of identifiers which each identify the transaction within each entity's system.")
   @JsonProperty("thirdPartyIdentifiers")
   @Valid
   private List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<ThirdPartyIdentifier>();

   private SlipData slipData = null;

   private String basketRef = null;

   private TranType tranType = null;

   private AccountType srcAccType = null;

   private AccountType destAccType = null;

   private String stan = null;

   private String rrn = null;

   @JsonProperty("amount")
   @ApiModelProperty(value = "The order amount.")
   @Valid
   private LedgerAmount amount = null;

   @JsonProperty("senderDetails")
   @ApiModelProperty(value = "")
   @Valid
   private PersonalDetails senderDetails = null;

   @JsonProperty("orderRedeemRefAlt")
   @ApiModelProperty(value = "An alternate reference used by the recipient to redeem the order. This must be printed on the receipt.")
   @Valid
   private String orderRedeemRefAlt = null;

   @JsonProperty("orderId")
   @ApiModelProperty(value = "Reference used by the service provider to uniquely identify the money transfer order on their system. This field can be used if the provider supplies a supplementary reference for the order in addition to the orderRedeemRef. Note that any reference issued by the provider that is specific to a particular leg of the order process should be set as a ThirdPartyIdentifier (i.e. the authorization and redeem legs of the order should each have its own reference).")
   private String orderId = null;

   @JsonProperty("customerProfileId")
   @ApiModelProperty(value = "Uniquely identifies customer's profile on the upstream entity's system.")
   private String customerProfileId = null;

   public MoneyTransferOrderStatusUpdateRequest updateTime(DateTime updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   public DateTime getUpdateTime() {
      return updateTime;
   }

   public void setUpdateTime(DateTime updateTime) {
      this.updateTime = updateTime;
   }

   public MoneyTransferOrderStatusUpdateRequest orderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
      return this;
   }

   public String getOrderRedeemRef() {
      return orderRedeemRef;
   }

   public void setOrderRedeemRef(String orderRedeemRef) {
      this.orderRedeemRef = orderRedeemRef;
   }

   public MoneyTransferOrderStatusUpdateRequest remittanceRef(String remittanceRef) {
      this.remittanceRef = remittanceRef;
      return this;
   }

   public String getRemittanceRef() {
      return remittanceRef;
   }

   public void setRemittanceRef(String remittanceRef) {
      this.remittanceRef = remittanceRef;
   }

   public MoneyTransferOrderStatusUpdateRequest status(OrderStatus status) {
      this.status = status;
      return this;
   }

   public OrderStatus getStatus() {
      return status;
   }

   public void setStatus(OrderStatus status) {
      this.status = status;
   }

   /**
    * Data relating to the originator of the transaction
    **/
   public MoneyTransferOrderStatusUpdateRequest originator(Originator originator) {
      this.originator = originator;
      return this;
   }

   public Originator getOriginator() {
      return originator;
   }

   public void setOriginator(Originator originator) {
      this.originator = originator;
   }

   /**
    * Data relating to the sender of BasicRequest.
    **/
   public MoneyTransferOrderStatusUpdateRequest client(Institution client) {
      this.client = client;
      return this;
   }

   public Institution getClient() {
      return client;
   }

   public void setClient(Institution client) {
      this.client = client;
   }

   /**
    * Data relating to the entity with whom the Merchant will settle the transaction.
    **/
   public MoneyTransferOrderStatusUpdateRequest settlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
      return this;
   }

   public Institution getSettlementEntity() {
      return settlementEntity;
   }

   public void setSettlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
   }

   /**
    * Data relating to the entity which ultimately processes the request.
    **/
   public MoneyTransferOrderStatusUpdateRequest receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   /**
    * An array of identifiers which each identify the transaction within each entity's system.
    **/
   public MoneyTransferOrderStatusUpdateRequest thirdPartyIdentifiers(
         List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
      return this;
   }

   public List<ThirdPartyIdentifier> getThirdPartyIdentifiers() {
      return thirdPartyIdentifiers;
   }

   public void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
   }

   public MoneyTransferOrderStatusUpdateRequest slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   public MoneyTransferOrderStatusUpdateRequest amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public MoneyTransferOrderStatusUpdateRequest senderDetails(PersonalDetails senderDetails) {
      this.senderDetails = senderDetails;
      return this;
   }

   public PersonalDetails getSenderDetails() {
      return senderDetails;
   }

   public void setSenderDetails(PersonalDetails senderDetails) {
      this.senderDetails = senderDetails;
   }

   public String getOrderRedeemRefAlt() {
      return orderRedeemRefAlt;
   }

   public void setOrderRedeemRefAlt(String orderRedeemRefAlt) {
      this.orderRedeemRefAlt = orderRedeemRefAlt;
   }

   public MoneyTransferOrderStatusUpdateRequest orderId(String orderId) {
      this.orderId = orderId;
      return this;
   }

   public String getOrderId() {
      return orderId;
   }

   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }

   public String getCustomerProfileId() {
      return customerProfileId;
   }

   public void setCustomerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
   }

   public MoneyTransferOrderStatusUpdateRequest customerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
      return this;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((orderRedeemRef == null) ? 0 : orderRedeemRef.hashCode());
      result = prime * result + ((remittanceRef == null) ? 0 : remittanceRef.hashCode());
      result = prime * result + ((status == null) ? 0 : status.hashCode());
      result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      MoneyTransferOrderStatusUpdateRequest other = (MoneyTransferOrderStatusUpdateRequest) obj;
      if (orderRedeemRef == null) {
         if (other.orderRedeemRef != null)
            return false;
      } else if (!orderRedeemRef.equals(other.orderRedeemRef))
         return false;
      if (remittanceRef == null) {
         if (other.remittanceRef != null)
            return false;
      } else if (!remittanceRef.equals(other.remittanceRef))
         return false;
      if (status != other.status)
         return false;
      if (updateTime == null) {
         if (other.updateTime != null)
            return false;
      } else if (!updateTime.equals(other.updateTime))
         return false;
      if (client == null) {
         if (other.client != null)
            return false;
      } else if (!client.equals(other.client))
         return false;
      if (settlementEntity == null) {
         if (other.settlementEntity != null)
            return false;
      } else if (!settlementEntity.equals(other.settlementEntity))
         return false;
      if (receiver == null) {
         if (other.receiver != null)
            return false;
      } else if (!receiver.equals(other.receiver))
         return false;
      if (thirdPartyIdentifiers == null) {
         if (other.thirdPartyIdentifiers != null)
            return false;
      } else if (!thirdPartyIdentifiers.equals(other.thirdPartyIdentifiers))
         return false;
      if (basketRef == null) {
         if (other.basketRef != null)
            return false;
      } else if (!basketRef.equals(other.basketRef))
         return false;
      if (tranType == null) {
         if (other.tranType != null)
            return false;
      } else if (!tranType.equals(other.tranType))
         return false;
      if (srcAccType == null) {
         if (other.srcAccType != null)
            return false;
      } else if (!srcAccType.equals(other.srcAccType))
         return false;
      if (destAccType == null) {
         if (other.destAccType != null)
            return false;
      } else if (!destAccType.equals(other.destAccType))
         return false;
      if (stan == null) {
         if (other.stan != null)
            return false;
      } else if (!stan.equals(other.stan))
         return false;
      if (rrn == null) {
         if (other.rrn != null)
            return false;
      } else if (!rrn.equals(other.rrn))
         return false;
      if (amount == null) {
         if (other.amount != null)
            return false;
      } else if (!amount.equals(other.amount))
         return false;
      if (senderDetails == null) {
         if (other.senderDetails != null)
            return false;
      } else if (!senderDetails.equals(other.senderDetails))
         return false;
      if (orderRedeemRefAlt == null) {
         if (other.orderRedeemRefAlt != null)
            return false;
      } else if (!orderRedeemRefAlt.equals(other.orderRedeemRefAlt))
         return false;
      if (orderId == null) {
         if (other.orderId != null)
            return false;
      } else if (!orderId.equals(other.orderId))
         return false;
      if (customerProfileId == null) {
         if (other.customerProfileId != null)
            return false;
      } else if (!customerProfileId.equals(other.customerProfileId))
         return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferOrderStatusUpdateRequest {\n");
      sb.append("    updateTime: ").append(Utils.toIndentedString(updateTime)).append("\n");
      sb.append("    orderRedeemRef: ").append(Utils.toIndentedString(orderRedeemRef)).append("\n");
      sb.append("    remittanceRef: ").append(Utils.toIndentedString(remittanceRef)).append("\n");
      sb.append("    status: ").append(Utils.toIndentedString(status)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("    tranType: ").append(Utils.toIndentedString(tranType)).append("\n");
      sb.append("    srcAccType: ").append(Utils.toIndentedString(srcAccType)).append("\n");
      sb.append("    destAccType: ").append(Utils.toIndentedString(destAccType)).append("\n");
      sb.append("    stan: ").append(Utils.toIndentedString(stan)).append("\n");
      sb.append("    rrn: ").append(Utils.toIndentedString(rrn)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    senderDetails: ").append(Utils.toIndentedString(senderDetails)).append("\n");
      sb.append("    orderRedeemRefAlt: ").append(Utils.toIndentedString(orderRedeemRefAlt)).append("\n");
      sb.append("    orderId: ").append(Utils.toIndentedString(orderId)).append("\n");
      sb.append("    customerProfileId: ").append(Utils.toIndentedString(customerProfileId)).append("\n");
      sb.append("}");
      return sb.toString();
   }

}
