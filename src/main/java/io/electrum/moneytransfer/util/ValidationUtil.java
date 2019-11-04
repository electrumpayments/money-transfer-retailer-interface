package io.electrum.moneytransfer.util;

public class ValidationUtil {

   public static final String ID_COUNTRY_CODE_REGEX = "[A-Za-z]{2}";
   public static final String MERCHANT_ID_REGEX = "[ A-Za-z0-9]{1,15}";
   public static final String CURRENCY_REGEX = "[0-9]{3}";

   private ValidationUtil() {
   }
}
