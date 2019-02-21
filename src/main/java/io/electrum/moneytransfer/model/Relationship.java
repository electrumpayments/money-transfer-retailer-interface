package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The relationships which exist between a sender and a recipient.
 */
public enum Relationship {
   PARENT("PARENT"),
   CHILD("CHILD"),
   SPOUSE("SPOUSE"),
   IN_LAWS("IN_LAWS"),
   RELATIVE("RELATIVE"),
   FRIEND_FAMILY("FRIEND_FAMILY"),
   EMPLOYEE_FAMILY("EMPLOYEE_FAMILY"),
   FRIEND("FRIEND"),
   EMPLOYEE("EMPLOYEE"),
   SUPPLIER("SUPPLIER"),
   SERVICE_PROVIDER("SERVICE_PROVIDER"),
   DONOR_RECEIVER_OF_CHARITABLE_FUNDS("DONOR_RECEIVER_OF_CHARITABLE_FUNDS"),
   TRADE_BUSINESS_PARTNER("TRADE_BUSINESS_PARTNER");

   private final String value;

   Relationship(String value) {
      this.value = value;
   }

   @JsonCreator
   public static Relationship fromValue(String text) throws IllegalArgumentException {
      for (Relationship idType : Relationship.values()) {
         if (idType.value.equals(text)) {
            return idType;
         }
      }
      throw new IllegalArgumentException(String.format("No Relationship exists with value='[%s]'", text));
   }

   @JsonValue
   @Override
   public String toString() {
      return String.valueOf(value);
   }
}
