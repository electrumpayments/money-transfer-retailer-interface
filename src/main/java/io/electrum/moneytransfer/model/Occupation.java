package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The various recognised occupations of participants in a money transfer.
 */
public enum Occupation {
   BUSINESSMAN("BUSINESSMAN"),
   PROFESSIONAL("PROFESSIONAL"),
   HOUSE_WIFE("HOUSE_WIFE"),
   GENERAL_WORKER("GENERAL_WORKER"),
   OTHER("OTHER");

   private final String value;

   Occupation(String value) {
      this.value = value;
   }

   @JsonCreator
   public static Occupation fromValue(String text) throws IllegalArgumentException {
      for (Occupation idType : Occupation.values()) {
         if (idType.value.equals(text)) {
            return idType;
         }
      }
      throw new IllegalArgumentException(String.format("No Occupation exists with value='[%s]'", text));
   }

   @JsonValue
   @Override
   public String toString() {
      return String.valueOf(value);
   }
}
