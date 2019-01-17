package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents the outcome of an unsuccessful transaction.
 */
@ApiModel(description = "Represents the outcome of an unsuccessful transaction.")
public class ErrorDetail {
   /**
    * The type of error that occurred
    */
   public enum ErrorTypeEnum {
      @Deprecated
      /**
       * @deprecated - As of v 2.1.0 Use {@link #INVALID_MERCHANT} instead.
       */
      TRANSACTION_NOT_ALLOWED_FOR_MERCHANT("TRANSACTION_NOT_ALLOWED_FOR_MERCHANT"),
      ALREADY_REDEEMED("ALREADY_REDEEMED"),
      PIN_RETRIES_EXCEEDED("PIN_RETRIES_EXCEEDED"),
      INCORRECT_PIN("INCORRECT_PIN"),
      UNABLE_TO_REDEEM("UNABLE_TO_REDEEM"),
      INVALID_REDEEM_REF("INVALID_REDEEM_REF"),
      DAILY_LIMIT_EXCEEDED("DAILY_LIMIT_EXCEEDED"),
      MONTHLY_LIMIT_EXCEEDED("MONTHLY_LIMIT_EXCEEDED"),
      PROVIDER_SYSTEM_ERROR("PROVIDER_SYSTEM_ERROR"),
      CUSTOMER_CHECK_FAILED("CUSTOMER_CHECK_FAILED"),
      DUPLICATE_RECORD("DUPLICATE_RECORD"),
      FORMAT_ERROR("FORMAT_ERROR"),
      SYSTEM_ERROR("SYSTEM_ERROR"),
      TRANSACTION_DECLINED("TRANSACTION_DECLINED"),
      INVALID_AMOUNT("INVALID_AMOUNT"),
      ROUTING_ERROR("ROUTING_ERROR"),
      TRANSACTION_NOT_SUPPORTED("TRANSACTION_NOT_SUPPORTED"),
      UNABLE_TO_LOCATE_RECORD("UNABLE_TO_LOCATE_RECORD"),
      UPSTREAM_UNAVAILABLE("UPSTREAM_UNAVAILABLE"),
      AUTHENTICATION_ERROR("AUTHENTICATION_ERROR"),
      INVALID_MERCHANT("INVALID_MERCHANT"),
      TRANSACTION_LIMIT_EXCEEDED("TRANSACTION_LIMIT_EXCEEDED"),
      ON_HOLD("ON_HOLD"),
      UNCONFIRMED("UNCONFIRMED");

      private String value;

      ErrorTypeEnum(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }

      @JsonCreator
      public static ErrorTypeEnum fromValue(String text) {
         for (ErrorTypeEnum b : ErrorTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
               return b;
            }
         }
         return null;
      }
   }

   private ErrorTypeEnum errorType = null;

   private String errorMessage = null;

   private String id = null;

   private String originalId = null;

   private Object detailMessage = null;

   private String providerErrorCode = null;

   private String providerErrorMessage = null;

   public ErrorDetail errorType(ErrorTypeEnum errorType) {
      this.errorType = errorType;
      return this;
   }

   /**
    * The type of error that occurred
    * 
    * @return errorType
    **/
   @JsonProperty("errorType")
   @ApiModelProperty(required = true, value = "The type of error that occurred")
   @Valid
   @NotNull
   public ErrorTypeEnum getErrorType() {
      return errorType;
   }

   public void setErrorType(ErrorTypeEnum errorType) {
      this.errorType = errorType;
   }

   public ErrorDetail errorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
   }

   /**
    * A description of the error
    * 
    * @return errorMessage
    **/
   @JsonProperty("errorMessage")
   @ApiModelProperty(required = true, value = "A description of the error")
   @Valid
   @NotNull
   @Size(min = 0, max = 80)
   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   public ErrorDetail id(String id) {
      this.id = id;
      return this;
   }

   /**
    * The UUID of the message for which the error occurred.
    * 
    * @return id
    **/
   @JsonProperty("id")
   @ApiModelProperty(required = true, value = "The UUID of the message for which the error occurred.")
   @Valid
   @NotNull
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public ErrorDetail originalId(String originalId) {
      this.originalId = originalId;
      return this;
   }

   /**
    * The UUID of the original request message in the case of an error occurring for an advice message.
    * 
    * @return originalId
    **/
   @JsonProperty("originalId")
   @ApiModelProperty(value = "The UUID of the original request message in the case of an error occurring for an advice message.")
   public String getOriginalId() {
      return originalId;
   }

   public void setOriginalId(String originalId) {
      this.originalId = originalId;
   }

   public ErrorDetail detailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
      return this;
   }

   /**
    * A free form detailed description of a particular failure condition may optionally be supplied.
    * 
    * @return detailMessage
    **/
   @JsonProperty("detailMessage")
   @ApiModelProperty(value = "A free form detailed description of a particular failure condition may optionally be supplied.")
   public Object getDetailMessage() {
      return detailMessage;
   }

   public void setDetailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
   }

   public ErrorDetail providerErrorCode(String providerErrorCode) {
      this.providerErrorCode = providerErrorCode;
      return this;
   }

   /**
    * The error code returned by the service provider. Note that this should be used for informational purposes only.
    * Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of
    * responses.
    * 
    * @return providerErrorCode
    **/
   @JsonProperty("providerErrorCode")
   @ApiModelProperty(value = "The error code returned by the service provider. Note that this should be used for informational purposes only. Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of responses.")
   public String getProviderErrorCode() {
      return providerErrorCode;
   }

   public void setProviderErrorCode(String providerErrorCode) {
      this.providerErrorCode = providerErrorCode;
   }

   public ErrorDetail providerErrorMessage(String providerErrorMessage) {
      this.providerErrorMessage = providerErrorMessage;
      return this;
   }

   /**
    * The error message returned by the service provider. Note that this should be used for informational purposes only.
    * Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of
    * responses.
    * 
    * @return providerErrorMessage
    **/
   @JsonProperty("providerErrorMessage")
   @ApiModelProperty(value = "The error message returned by the service provider. Note that this should be used for informational purposes only. Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of responses.")
   public String getProviderErrorMessage() {
      return providerErrorMessage;
   }

   public void setProviderErrorMessage(String providerErrorMessage) {
      this.providerErrorMessage = providerErrorMessage;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ErrorDetail errorDetail = (ErrorDetail) o;
      return Objects.equals(this.errorType, errorDetail.errorType)
            && Objects.equals(this.errorMessage, errorDetail.errorMessage) && Objects.equals(this.id, errorDetail.id)
            && Objects.equals(this.originalId, errorDetail.originalId)
            && Objects.equals(this.detailMessage, errorDetail.detailMessage)
            && Objects.equals(this.providerErrorCode, errorDetail.providerErrorCode)
            && Objects.equals(this.providerErrorMessage, errorDetail.providerErrorMessage);
   }

   @Override
   public int hashCode() {
      return Objects
            .hash(errorType, errorMessage, id, originalId, detailMessage, providerErrorCode, providerErrorMessage);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ErrorDetail {\n");

      sb.append("    errorType: ").append(Utils.toIndentedString(errorType)).append("\n");
      sb.append("    errorMessage: ").append(Utils.toIndentedString(errorMessage)).append("\n");
      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    originalId: ").append(Utils.toIndentedString(originalId)).append("\n");
      sb.append("    detailMessage: ").append(Utils.toIndentedString(detailMessage)).append("\n");
      sb.append("    providerErrorCode: ").append(Utils.toIndentedString(providerErrorCode)).append("\n");
      sb.append("    providerErrorMessage: ").append(Utils.toIndentedString(providerErrorMessage)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
