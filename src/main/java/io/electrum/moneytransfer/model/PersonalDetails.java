package io.electrum.moneytransfer.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.sdk.masking2.DoNotPersist;
import io.electrum.sdk.masking2.MaskAll;
import io.electrum.sdk.masking2.Masked;
import io.electrum.vas.Utils;
import io.electrum.vas.model.Account;
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
   @Masked
   @DoNotPersist(replacementValue = "000000000000")
   private String idNumber = null;

   @JsonProperty("idType")
   private IdType idType = null;

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

   @JsonProperty("accountDetails")
   private Account accountDetails = null;

   @JsonProperty("idIssuedDate")
   private DateTime idIssuedDate = null;

   @JsonProperty("idExpiryDate")
   private DateTime idExpiryDate = null;

   @JsonProperty("culturalName")
   private String culturalName = null;

   @JsonProperty("sourceOfIncome")
   private SourceOfIncome sourceOfIncome = null;

   @JsonProperty("occupation")
   private Occupation occupation = null;

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
   @Masked
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
   @Masked
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
   @Valid
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
   @Masked
   public String getIdNumber() {
      return idNumber;
   }

   public void setIdNumber(String idNumber) {
      this.idNumber = idNumber;
   }

   public PersonalDetails idType(IdType idType) {
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
   public IdType getIdType() {
      return idType;
   }

   public void setIdType(IdType idType) {
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
   @Valid
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
   @Valid
   @Size(min = 2, max = 2)
   @Masked
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
   @Masked
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
   @Valid
   @Pattern(regexp = "^\\+?[1-9]\\d{1,14}")
   @Masked
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
   @Valid
   @Pattern(regexp = "^\\+?[1-9]\\d{1,14}")
   @Masked
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
   @Valid
   @Pattern(regexp = "^\\+?[1-9]\\d{1,14}")
   @Masked
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
   @Masked
   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public PersonalDetails accountDetails(Account accountDetails) {
      this.accountDetails = accountDetails;
      return this;
   }

   /**
    * The person's account details.
    *
    * @return accountDetails
    **/
   @JsonProperty("accountDetails")
   @ApiModelProperty(value = "The person's account details.")
   @Valid
   public Account getAccountDetails() {
      return accountDetails;
   }

   public void setAccountDetails(Account accountDetails) {
      this.accountDetails = accountDetails;
   }

   public PersonalDetails idIssuedDate(DateTime idIssuedDate) {
      this.idIssuedDate = idIssuedDate;
      return this;
   }

   /**
    * The date and time when the person's form of ID was issued.
    *
    * @return idIssuedDate
    **/
   @JsonProperty("idIssuedDate")
   @ApiModelProperty(value = "The date and time when the person's form of ID was issued.")
   @Valid
   public DateTime getIdIssuedDate() {
      return idIssuedDate;
   }

   public void setIdIssuedDate(DateTime idIssuedDate) {
      this.idIssuedDate = idIssuedDate;
   }

   public PersonalDetails idExpiryDate(DateTime idExpiryDate) {
      this.idExpiryDate = idExpiryDate;
      return this;
   }

   /**
    * The date and time when the person's form of ID expires.
    *
    * @return idExpiryDate
    **/
   @JsonProperty("idExpiryDate")
   @ApiModelProperty(value = "The date and time when the person's form of ID expires.")
   @Valid
   public DateTime getIdExpiryDate() {
      return idExpiryDate;
   }

   public void setIdExpiryDate(DateTime idExpiryDate) {
      this.idExpiryDate = idExpiryDate;
   }

   public PersonalDetails culturalName(String culturalName) {
      this.culturalName = culturalName;
      return this;
   }

   /**
    * The person's full name in their native alphabet.
    *
    * @return culturalName
    **/
   @JsonProperty("culturalName")
   @ApiModelProperty(value = "The person's full name in their native alphabet.")
   public String getCulturalName() {
      return culturalName;
   }

   public void setCulturalName(String culturalName) {
      this.culturalName = culturalName;
   }

   public PersonalDetails sourceOfIncome(SourceOfIncome sourceOfIncome) {
      this.sourceOfIncome = sourceOfIncome;
      return this;
   }

   /**
    * The source of the funds used for the money transfer.
    *
    * @return sourceOfIncome
    **/
   @JsonProperty("sourceOfIncome")
   @ApiModelProperty(value = "The source of the funds used for the money transfer.")
   @Valid
   public SourceOfIncome getSourceOfIncome() {
      return sourceOfIncome;
   }

   public void setSourceOfIncome(SourceOfIncome sourceOfIncome) {
      this.sourceOfIncome = sourceOfIncome;
   }

   public PersonalDetails occupation(Occupation occupation) {
      this.occupation = occupation;
      return this;
   }

   /**
    * The person's occupation.
    *
    * @return occupation
    **/
   @JsonProperty("occupation")
   @ApiModelProperty(value = "The person's occupation.")
   @Valid
   public Occupation getOccupation() {
      return occupation;
   }

   public void setOccupation(Occupation occupation) {
      this.occupation = occupation;
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
            && Objects.equals(this.email, personalDetails.email)
            && Objects.equals(this.accountDetails, personalDetails.accountDetails)
            && Objects.equals(this.idIssuedDate, personalDetails.idIssuedDate)
            && Objects.equals(this.idExpiryDate, personalDetails.idExpiryDate)
            && Objects.equals(this.culturalName, personalDetails.culturalName)
            && Objects.equals(this.sourceOfIncome, personalDetails.sourceOfIncome)
            && Objects.equals(this.occupation, personalDetails.occupation);
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
            email,
            accountDetails,
            idIssuedDate,
            idExpiryDate,
            culturalName,
            sourceOfIncome,
            occupation);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PersonalDetails {\n");
      sb.append("    firstName: ").append(Utils.toIndentedString(new MaskAll().mask(firstName))).append("\n");
      sb.append("    lastName: ").append(Utils.toIndentedString(new MaskAll().mask(lastName))).append("\n");
      sb.append("    address: ").append(Utils.toIndentedString(address)).append("\n");
      sb.append("    idNumber: ").append(Utils.toIndentedString(new MaskAll().mask(idNumber))).append("\n");
      sb.append("    idType: ").append(Utils.toIndentedString(idType)).append("\n");
      sb.append("    nationality: ").append(Utils.toIndentedString(new MaskAll().mask(nationality))).append("\n");
      sb.append("    idCountryCode: ").append(Utils.toIndentedString(new MaskAll().mask(idCountryCode))).append("\n");
      sb.append("    dateOfBirth: ").append(Utils.toIndentedString(new MaskAll().mask(dateOfBirth))).append("\n");
      sb.append("    contactNumber: ").append(Utils.toIndentedString(new MaskAll().mask(contactNumber))).append("\n");
      sb.append("    altContactHome: ").append(Utils.toIndentedString(new MaskAll().mask(altContactHome))).append("\n");
      sb.append("    altContactWork: ").append(Utils.toIndentedString(new MaskAll().mask(altContactWork))).append("\n");
      sb.append("    email: ").append(Utils.toIndentedString(new MaskAll().mask(email))).append("\n");
      sb.append("    accountDetails: ").append(Utils.toIndentedString(accountDetails)).append("\n");
      sb.append("    idIssuedDate: ").append(Utils.toIndentedString(idIssuedDate)).append("\n");
      sb.append("    idExpiryDate: ").append(Utils.toIndentedString(idExpiryDate)).append("\n");
      sb.append("    culturalName: ").append(Utils.toIndentedString(new MaskAll().mask(culturalName))).append("\n");
      sb.append("    sourceOfIncome: ").append(Utils.toIndentedString(sourceOfIncome)).append("\n");
      sb.append("    occupation: ").append(Utils.toIndentedString(occupation)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
