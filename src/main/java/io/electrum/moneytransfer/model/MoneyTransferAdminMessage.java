package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Originator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Used to transfer data in calls to the /admin/customers resource.
 */
@ApiModel(description = "Used to transfer data in calls to the /admin/customers resource.")
public class MoneyTransferAdminMessage {
   @JsonProperty("originator")
   private Originator originator = null;

   @JsonProperty("receiver")
   private Institution receiver = null;

   @JsonProperty("customerDetails")
   private PersonalDetails customerDetails = null;

   @JsonProperty("customerProfileId")
   private String customerProfileId = null;

   public MoneyTransferAdminMessage originator(Originator originator) {
      this.originator = originator;
      return this;
   }

   /**
    * Get originator
    *
    * @return originator
    **/
   @JsonProperty("originator")
   @ApiModelProperty(required = true, value = "")
   @Valid
   @NotNull
   public Originator getOriginator() {
      return originator;
   }

   public void setOriginator(Originator originator) {
      this.originator = originator;
   }

   public MoneyTransferAdminMessage receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

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

   public MoneyTransferAdminMessage customerDetails(PersonalDetails customerDetails) {
      this.customerDetails = customerDetails;
      return this;
   }

   /**
    * Get customerDetails
    *
    * @return customerDetails
    **/
   @JsonProperty("customerDetails")
   @ApiModelProperty(value = "")
   @Valid
   public PersonalDetails getCustomerDetails() {
      return customerDetails;
   }

   public void setCustomerDetails(PersonalDetails customerDetails) {
      this.customerDetails = customerDetails;
   }

   public MoneyTransferAdminMessage customerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
      return this;
   }

   /**
    * Uniquely identifies customer's profile on the upstream entity's system.
    *
    * @return customerProfileId
    **/
   @JsonProperty("customerProfileId")
   @ApiModelProperty(value = "Uniquely identifies customer's profile on the upstream entity's system.")
   public String getCustomerProfileId() {
      return customerProfileId;
   }

   public void setCustomerProfileId(String customerProfileId) {
      this.customerProfileId = customerProfileId;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MoneyTransferAdminMessage moneyTransferAdminMessage = (MoneyTransferAdminMessage) o;
      return Objects.equals(this.originator, moneyTransferAdminMessage.originator)
            && Objects.equals(this.receiver, moneyTransferAdminMessage.receiver)
            && Objects.equals(this.customerDetails, moneyTransferAdminMessage.customerDetails)
            && Objects.equals(this.customerProfileId, moneyTransferAdminMessage.customerProfileId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(originator, receiver, customerDetails, customerProfileId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MoneyTransferAdminMessage {\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    customerDetails: ").append(Utils.toIndentedString(customerDetails)).append("\n");
      sb.append("    customerProfileId: ").append(Utils.toIndentedString(customerProfileId)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
