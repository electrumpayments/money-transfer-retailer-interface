package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of a money transfer order.
 */
public enum OrderStatus {
   UNREDEEMED("UNREDEEMED"),
   REDEEMED("REDEEMED"),
   CANCELLED("CANCELLED"),
   EXPIRED("EXPIRED"),
   ON_HOLD("ON_HOLD"),
   UNCONFIRMED("UNCONFIRMED");

   private final String value;

   OrderStatus(String value) {
      this.value = value;
   }

   @JsonCreator
   public static OrderStatus fromValue(String text) throws IllegalArgumentException {
      for (OrderStatus idType : OrderStatus.values()) {
         if (idType.value.equals(text)) {
            return idType;
         }
      }
      throw new IllegalArgumentException(String.format("No OrderStatus exists with value='[%s]'", text));
   }

   @JsonValue
   @Override
   public String toString() {
      return String.valueOf(value);
   }
}
