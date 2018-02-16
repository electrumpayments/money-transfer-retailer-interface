package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Details of a customer's address
 */
@ApiModel(description = "Details of a customer's address")
public class Address {
   @JsonProperty("addressLine1")
   private String addressLine1 = null;

   @JsonProperty("addressLine2")
   private String addressLine2 = null;

   @JsonProperty("city")
   private String city = null;

   @JsonProperty("province")
   private String province = null;

   @JsonProperty("country")
   private String country = null;

   @JsonProperty("postCode")
   private String postCode = null;

   public Address addressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
      return this;
   }

   /**
    * First line of street address.
    * 
    * @return addressLine1
    **/
   @JsonProperty("addressLine1")
   @ApiModelProperty(value = "First line of street address.")
   public String getAddressLine1() {
      return addressLine1;
   }

   public void setAddressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
   }

   public Address addressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
      return this;
   }

   /**
    * Second line of street address (if required).
    * 
    * @return addressLine2
    **/
   @JsonProperty("addressLine2")
   @ApiModelProperty(value = "Second line of street address (if required).")
   public String getAddressLine2() {
      return addressLine2;
   }

   public void setAddressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
   }

   public Address city(String city) {
      this.city = city;
      return this;
   }

   /**
    * Get city
    * 
    * @return city
    **/
   @JsonProperty("city")
   @ApiModelProperty(value = "")
   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public Address province(String province) {
      this.province = province;
      return this;
   }

   /**
    * Get province
    * 
    * @return province
    **/
   @JsonProperty("province")
   @ApiModelProperty(value = "")
   public String getProvince() {
      return province;
   }

   public void setProvince(String province) {
      this.province = province;
   }

   public Address country(String country) {
      this.country = country;
      return this;
   }

   /**
    * Country expressed as an ISO 3166-1 Alpha-2 code
    * 
    * @return country
    **/
   @JsonProperty("country")
   @ApiModelProperty(value = "Country expressed as an ISO 3166-1 Alpha-2 code")
   @Size(min = 2, max = 2)
   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public Address postCode(String postCode) {
      this.postCode = postCode;
      return this;
   }

   /**
    * Get postCode
    * 
    * @return postCode
    **/
   @JsonProperty("postCode")
   @ApiModelProperty(value = "")
   public String getPostCode() {
      return postCode;
   }

   public void setPostCode(String postCode) {
      this.postCode = postCode;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Address address = (Address) o;
      return Objects.equals(this.addressLine1, address.addressLine1)
            && Objects.equals(this.addressLine2, address.addressLine2) && Objects.equals(this.city, address.city)
            && Objects.equals(this.province, address.province) && Objects.equals(this.country, address.country)
            && Objects.equals(this.postCode, address.postCode);
   }

   @Override
   public int hashCode() {
      return Objects.hash(addressLine1, addressLine2, city, province, country, postCode);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Address {\n");

      sb.append("    addressLine1: ").append(Utils.toIndentedString(addressLine1)).append("\n");
      sb.append("    addressLine2: ").append(Utils.toIndentedString(addressLine2)).append("\n");
      sb.append("    city: ").append(Utils.toIndentedString(city)).append("\n");
      sb.append("    province: ").append(Utils.toIndentedString(province)).append("\n");
      sb.append("    country: ").append(Utils.toIndentedString(country)).append("\n");
      sb.append("    postCode: ").append(Utils.toIndentedString(postCode)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
