package io.electrum.moneytransfer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Originator;
import io.swagger.annotations.ApiModelProperty;

public class MoneyTransferCustomerOrderHistory {

   @JsonProperty("receiver")
   @NotNull
   private Institution receiver = null;

   @JsonProperty("orders")
   private List<MoneyTransferLookupResponse> orders = null;

   @JsonProperty("originator")
   private Originator originator = null;

   /**
    * Get receiver
    *
    * @return receiver
    **/
   @JsonProperty("receiver")
   @ApiModelProperty(required = true, value = "")
   @Valid
   @NotNull
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   public MoneyTransferCustomerOrderHistory receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   public List<MoneyTransferLookupResponse> getOrders() {
      return orders;
   }

   public void setOrders(List<MoneyTransferLookupResponse> orders) {
      this.orders = orders;
   }

   public MoneyTransferCustomerOrderHistory orders(List<MoneyTransferLookupResponse> orders) {
      this.orders = orders;
      return this;
   }

   public MoneyTransferCustomerOrderHistory addOrder(MoneyTransferLookupResponse order) {
      if (orders == null) {
         orders = new ArrayList<>();
      }
      orders.add(order);
      return this;
   }

   /**
    * Get originator
    *
    * @return originator
    **/
   @JsonProperty("originator")
   @ApiModelProperty(required = true)
   @Valid
   public Originator getOriginator() {
      return originator;
   }

   public void setOriginator(Originator originator) {
      this.originator = originator;
   }

   public MoneyTransferCustomerOrderHistory originator(Originator originator) {
      this.originator = originator;
      return this;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (!(o instanceof MoneyTransferCustomerOrderHistory))
         return false;
      MoneyTransferCustomerOrderHistory that = (MoneyTransferCustomerOrderHistory) o;
      return receiver.equals(that.receiver) && Objects.equals(orders, that.orders)
            && Objects.equals(originator, that.originator);
   }

   @Override
   public int hashCode() {
      return Objects.hash(receiver, orders, originator);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferCustomerOrderHistory {\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    orders: ").append(Utils.toIndentedString(orders)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
