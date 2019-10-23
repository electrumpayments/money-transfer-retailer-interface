package io.electrum.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The various sources of income used to facilitate a money transfer.
 */
public enum SourceOfIncome {
   SALARIED("SALARIED"),
   PERSONAL_INCOME("PERSONAL_INCOME"),
   LOAN("LOAN"),
   BUSINESS("BUSINESS"),
   SAVINGS("SAVINGS"),
   GIFT("GIFT"),
   WINNINGS("WINNINGS"),
   SALE_OF_ASSETS("SALE_OF_ASSETS"),
   INVESTMENTS("INVESTMENTS"),
   FAMILY_FINANCIAL_SUPPORT("FAMILY_FINANCIAL_SUPPORT"),
   GOVERNMENT_FINANCIAL_SUPPORT("GOVERNMENT_FINANCIAL_SUPPORT"),
   OTHER("OTHER");

   private final String value;

   SourceOfIncome(String value) {
      this.value = value;
   }

   @JsonCreator
   public static SourceOfIncome fromValue(String text) throws IllegalArgumentException {
      for (SourceOfIncome idType : SourceOfIncome.values()) {
         if (idType.value.equals(text)) {
            return idType;
         }
      }
      throw new IllegalArgumentException(String.format("No SourceOfIncome exists with value='[%s]'", text));
   }

   @JsonValue
   @Override
   public String toString() {
      return String.valueOf(value);
   }
}
