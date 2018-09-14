This page describes changes to the Money Transfer Retailer Interface implemented across different releases of the interface.

## v2.2.0

Released 14 September 2018
 - Added `@Masked` annotation to the `IdNumber` field of `PersonalDetails` model.
 - Added `customerProfileId` in `MoneyTransferRedeemRequest`

## v2.1.0

Released 27 August 2018
 - Deprecated TRANSACTION_NOT_ALLOWED_FOR_MERCHANT ErrorType. Provided INVALID_MERCHANT ErrorType for use instead.

## v2.0.2

 Released 8 August 2018
  - No code changes. Changes to release process only.

## v2.0.1

Released 2 August 2018
 - Added `@Valid` annotations to resources and model objects, which allows the object to be recursively validated.

## v2.0.0

Released 3 May 2018

- Added `IdType` enum:
  - NATIONAL_ID
  - PASSPORT
  - DRIVERS_LICENCE
  - ASYLUM_DOCUMENT
  - UNKNOWN
- Added new fields to the following messages:
  - Added `recipientDetails` to `MoneyTransferRedeemRequest`, optional field
  - Added `idType` and `idCountryCode` to the query parameters of `getCustomerInfoCall`
  - Added `idType` to the PersonalDetails object
- The following fields have been updated:
  - Simple `pinBlock` String field in `MoneyTransferAuthRequest` and `MoneyTransferRedeemRequest` has been replaced with a complex `EncryptedPin` object. The simple `pinBlock` field now resides in the `EncryptedPin` object.
  - Added `EXPIRED` to `Status` enum of a `MoneyTransferLookupResponse`
  - Added `idCountryCode` to `PersonalDetails`

## v1.0.1

Released 2 May 2018

- Added MSISDN to quotes.

## v1.0.0

Released 21 Feb 2018

Initial release.
