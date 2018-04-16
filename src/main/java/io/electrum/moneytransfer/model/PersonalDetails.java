package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pesonal details of a customer.
 */
@ApiModel(description = "Pesonal details of a customer.")
public class PersonalDetails {
   @JsonProperty("firstName")
   private String firstName = null;

   @JsonProperty("lastName")
   private String lastName = null;

   @JsonProperty("address")
   private Address address = null;

   @JsonProperty("idNumber")
   private String idNumber = null;

   @JsonProperty("idType")
   private String idType = null;

   @JsonProperty("idCountryCode")
   private String idCountryCode = null;

   @JsonProperty("nationality")
   private String nationality = null;

   @JsonProperty("dateOfBirth")
   private String dateOfBirth = null;

   @JsonProperty("contactNumber")
   private String contactNumber = null;

   @JsonProperty("altContactWork")
   private String altContactWork = null;

   @JsonProperty("altContactHome")
   private String altContactHome = null;

   @JsonProperty("email")
   private String email = null;

   public PersonalDetails firstName(String firstName) {
      this.firstName = firstName;
      return this;
   }

   /**
    * The person's first name(s)
    * 
    * @return firstName
    **/
   @JsonProperty("firstName")
   @ApiModelProperty(value = "The person's first name(s)")
   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public PersonalDetails lastName(String lastName) {
      this.lastName = lastName;
      return this;
   }

   /**
    * The person's last name
    * 
    * @return lastName
    **/
   @JsonProperty("lastName")
   @ApiModelProperty(value = "The person's last name")
   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public PersonalDetails address(Address address) {
      this.address = address;
      return this;
   }

   /**
    * Get address
    * 
    * @return address
    **/
   @JsonProperty("address")
   @ApiModelProperty(value = "")
   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public PersonalDetails idNumber(String idNumber) {
      this.idNumber = idNumber;
      return this;
   }

   /**
    * The person's ID Number
    * 
    * @return idNumber
    **/
   @JsonProperty("idNumber")
   @ApiModelProperty(value = "Individual's identification number as per presented identification document")
   public String getIdNumber() {
      return idNumber;
   }

   public void setIdNumber(String idNumber) {
      this.idNumber = idNumber;
   }

   public PersonalDetails idType(String idType) {
      this.idType = idType;
      return this;
   }

   /**
    * Type of identification document
    * 
    * @return idType
    **/
   @JsonProperty("idType")
   @ApiModelProperty(value = "Type of presented identification document")
   public String getIdType() {
      return idType;
   }

   public void setIdType(String idType) {
      this.idType = idType;
   }

   public PersonalDetails idCountryCode(String idCountryCode) {
      this.idCountryCode = idCountryCode;
      return this;
   }

   /**
    * Country of issue of presented identification document, expressed as an ISO 3166-1 Alpha-2 country code
    *
    * @return idCountryCode
    **/
   @JsonProperty("idCountryCode")
   @ApiModelProperty(value = "Country of issue of presented identification document, expressed as an ISO 3166-1 Alpha-2 country code")
   @Size(min = 2, max = 2)
   public String getIdCountryCode() {
      return idCountryCode;
   }

   public void setIdCountryCode(String idCountryCode) {
      this.idCountryCode = idCountryCode;
   }

   public PersonalDetails nationality(String nationality) {
      this.nationality = nationality;
      return this;
   }

   /**
    * Nationality expressed as an ISO 3166-1 Alpha-2 country code
    * 
    * @return nationality
    **/
   @JsonProperty("nationality")
   @ApiModelProperty(value = "Nationality expressed as an ISO 3166-1 Alpha-2 country code")
   @Size(min = 2, max = 2)
   public String getNationality() {
      return nationality;
   }

   public void setNationality(String nationality) {
      this.nationality = nationality;
   }

   public PersonalDetails dateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
   }

   /**
    * Date of birth
    * 
    * @return dateOfBirth
    **/
   @JsonProperty("dateOfBirth")
   @ApiModelProperty(value = "Date of birth")
   public String getDateOfBirth() {
      return dateOfBirth;
   }

   public void setDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   /**
    * Mobile phone number of the customer to which the outcome of a transaction can be communicated. This must conform
    * to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en).
    * 
    * @return contactNumber
    **/
   @JsonProperty("contactNumber")
   @ApiModelProperty(value = "Mobile phone number of the customer to which the outcome of a transaction can be communicated. This must conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en).")
   @Pattern(regexp = "^\\+?[1-9]\\d{1,14}")
   public String getContactNumber() {
      return contactNumber;
   }

   public void setContactNumber(String contactNumber) {
      this.contactNumber = contactNumber;
   }

   public PersonalDetails contactNumber(String contactNumber) {
      this.contactNumber = contactNumber;
      return this;
   }

   public PersonalDetails altContactHome(String altContactHome) {
      this.altContactHome = altContactHome;
      return this;
   }

   /**
    * An alternative home contact number. This must conform to the ITU E.164 numbering plan
    * (https://www.itu.int/rec/T-REC-E.164/en).
    * 
    * @return altContactHome
    **/
   @JsonProperty("altContactHome")
   @ApiModelProperty(value = "An alternative home contact number. This must conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en).")
   @Pattern(regexp = "^\\+?[1-9]\\d{1,14}")
   public String getAltContactHome() {
      return altContactHome;
   }

   public void setAltContactHome(String altContactHome) {
      this.altContactHome = altContactHome;
   }

   public PersonalDetails altContactWork(String altContactWork) {
      this.altContactWork = altContactWork;
      return this;
   }

   /**
    * An alternative work contact number. This must conform to the ITU E.164 numbering plan
    * (https://www.itu.int/rec/T-REC-E.164/en).
    * 
    * @return altContactWork
    **/
   @JsonProperty("altContactWork")
   @ApiModelProperty(value = "An alternative work contact number. This must conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en).")
   @Pattern(regexp = "^\\+?[1-9]\\d{1,14}")
   public String getAltContactWork() {
      return altContactWork;
   }

   public void setAltContactWork(String altContactWork) {
      this.altContactWork = altContactWork;
   }

   public PersonalDetails email(String email) {
      this.email = email;
      return this;
   }

   /**
    * The person's email address
    * 
    * @return email
    **/
   @JsonProperty("email")
   @ApiModelProperty(value = "The person's email address")
   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PersonalDetails personalDetails = (PersonalDetails) o;
      return Objects.equals(this.firstName, personalDetails.firstName)
            && Objects.equals(this.lastName, personalDetails.lastName)
            && Objects.equals(this.address, personalDetails.address)
            && Objects.equals(this.idNumber, personalDetails.idNumber)
            && Objects.equals(this.idType, personalDetails.idType)
            && Objects.equals(this.nationality, personalDetails.nationality)
             && Objects.equals(this.idCountryCode, personalDetails.idCountryCode)
            && Objects.equals(this.dateOfBirth, personalDetails.dateOfBirth)
            && Objects.equals(this.contactNumber, personalDetails.contactNumber)
            && Objects.equals(this.altContactHome, personalDetails.altContactHome)
            && Objects.equals(this.altContactWork, personalDetails.altContactWork)
            && Objects.equals(this.email, personalDetails.email);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            firstName,
            lastName,
            address,
            idNumber,
            idType,
            nationality,
            idCountryCode,
            dateOfBirth,
            contactNumber,
            altContactHome,
            altContactWork,
            email);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PersonalDetails {\n");
      sb.append("    firstName: ").append(Utils.toIndentedString(firstName)).append("\n");
      sb.append("    lastName: ").append(Utils.toIndentedString(lastName)).append("\n");
      sb.append("    address: ").append(Utils.toIndentedString(address)).append("\n");
      sb.append("    idNumber: ").append(Utils.toIndentedString(idNumber)).append("\n");
      sb.append("    idType: ").append(Utils.toIndentedString(idType)).append("\n");
      sb.append("    nationality: ").append(Utils.toIndentedString(nationality)).append("\n");
      sb.append("    idCountryCode: ").append(Utils.toIndentedString(idCountryCode)).append("\n");
      sb.append("    dateOfBirth: ").append(Utils.toIndentedString(dateOfBirth)).append("\n");
      sb.append("    contactNumber: ").append(Utils.toIndentedString(contactNumber)).append("\n");
      sb.append("    altContactHome: ").append(Utils.toIndentedString(altContactHome)).append("\n");
      sb.append("    altContactWork: ").append(Utils.toIndentedString(altContactWork)).append("\n");
      sb.append("    email: ").append(Utils.toIndentedString(email)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
