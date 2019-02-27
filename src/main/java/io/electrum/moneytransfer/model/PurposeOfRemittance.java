package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Purpose of a money transfer.
 */
public enum PurposeOfRemittance {
   FAMILY_SUPPORT("FAMILY_SUPPORT"),
   EDUCATION("EDUCATION"),
   GIFT_AND_DONATION("GIFT_AND_DONATION"),
   MEDICAL_TREATMENT("MEDICAL_TREATMENT"),
   MAINTENANCE_EXPENSES("MAINTENANCE_EXPENSES"),
   TRAVEL("TRAVEL"),
   OTHER("OTHER");

   private final String value;

   PurposeOfRemittance(String value) {
      this.value = value;
   }

   @JsonCreator
   public static PurposeOfRemittance fromValue(String text) throws IllegalArgumentException {
      for (PurposeOfRemittance idType : PurposeOfRemittance.values()) {
         if (idType.value.equals(text)) {
            return idType;
         }
      }
      throw new IllegalArgumentException(String.format("No PurposeOfRemittance exists with value='[%s]'", text));
   }

   @JsonValue
   @Override
   public String toString() {
      return String.valueOf(value);
   }
}
