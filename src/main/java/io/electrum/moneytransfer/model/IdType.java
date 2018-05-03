package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of an individual's presented identification document
 */
public enum IdType {
   NATIONAL_ID("NATIONAL_ID"),
   PASSPORT("PASSPORT"),
   DRIVERS_LICENCE("DRIVERS_LICENCE"),
   ASYLUM_DOCUMENT("ASYLUM_DOCUMENT");

   private final String value;

   IdType(String value) {
      this.value = value;
   }

   @JsonCreator
   public static IdType fromValue(String text) throws IllegalArgumentException {
      for (IdType idType : IdType.values()) {
         if (idType.value.equals(text)) {
            return idType;
         }
      }
      throw new IllegalArgumentException(String.format("No IdType exists with value='[%s]'", text));
   }

   @JsonValue
   @Override
   public String toString() {
      return String.valueOf(value);
   }
}
