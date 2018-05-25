This page describes changes to the Money Transfer Retailer Interface implemented across different releases of the interface.

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
  - Added `EncryptedPin` to `MoneyTransferAuthRequest` and `MoneyTransferRedeemRequest` and removed `pinBlock` field
  - Added `idType` and `idCountryCode` to the query parameters of `getCustomerInfoCall`
- The following fields have been updated:
  - Added Expired to `Status` enum of a `MoneyTransferLookupResponse`
  - Added `idCountryCode` to `PersonalDetails`

## v1.0.1

Deprecated, replaced with v2.0.0

Released 2 May 2018

- Added MSISDN to quotes.

## v1.0.0

Released 21 Feb 2018

Initial release.
