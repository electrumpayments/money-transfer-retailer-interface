package io.electrum.moneytransfer.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
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
      sb.append("}");
      return sb.toString();
   }

}
