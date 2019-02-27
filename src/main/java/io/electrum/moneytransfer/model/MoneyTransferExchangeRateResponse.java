package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.ExchangeRate;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains information necessary to obtain a quote for the money transfer.
 */
public class MoneyTransferExchangeRateResponse {

   private ExchangeRate exchangeRate = null;

   public MoneyTransferExchangeRateResponse exchangeRate(ExchangeRate exchangeRate) {
      this.exchangeRate = exchangeRate;
      return this;
   }

   /**
    * The requested exchange rate.
    *
    * @return exchangeRate
    **/
   @JsonProperty("exchangeRate")
   @ApiModelProperty(required = true, value = "The requested exchange rate.")
   @Valid
   @NotNull
   public ExchangeRate getExchangeRate() {
      return exchangeRate;
   }

   public void setExchangeRate(ExchangeRate exchangeRate) {
      this.exchangeRate = exchangeRate;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MoneyTransferExchangeRateResponse exchangeRateResponse = (MoneyTransferExchangeRateResponse) o;
      return Objects.equals(this.exchangeRate, exchangeRateResponse.exchangeRate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(exchangeRate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferExchangeRateResponse {\n");
      sb.append("    exchangeRate: ").append(Utils.toIndentedString(exchangeRate)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
