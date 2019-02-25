This page describes changes to the Money Transfer Retailer Interface implemented across different releases of the interface.

## v2.6.0

Released TBC February 2019
 - Added the following new operations:
  - Admin Resources:
    - Get Exchange Rate - used to obtain a currency exchange rate.
   - Orders Resources:
     - UpdateOrderStatus - used to inform the server a change in an order's status.
- Altered the following operations:
   - Admin Resources:
     - Get Fee Quote - allowed to be called via an HTTP POST method
    - Orders Resources:
      - LookupOrder - accepts a `remittanceRef` to refer to an order which will not be explicitly redeemed (e.g. direct account deposits).
- Corrected repetition of API base path.
  - *Note* This is breaking change to the API but is not treated as such. Previously the API defined paths to operations as `/moneytransfer/v2/moneytransfer/v2/{operation}` when they should have been of the more simple form `/moneytransfer/v2/{operation}`. Changing the API base path in this manner would typically be a breaking change and would be reflected as such by bumping the major version number in the URL from `v2` to `v3`. However, all known projects depending on the Money Transfer Retailer Interface are already implemented using the simpler base path of `/moneytransfer/v2/{operation}`. Thus the decision was made to transparently fix the base path repetition bug as a minor version update as this was deemed to be a less disruptive change to all known projects.
- The version of the Base API has been updated to v3.18.0. This includes the following changes:
  - Added new models:
    - `ExchangeRate` to describe the exchange rate between two currencies.
    - `Account` to describe more varied accounts in a consistent manner. This has the following sub-types defined:
      - `BankAccount`
      - `IbanAccount`
      - `IfscAccount`
      - `SwiftAccount`
      - `MobileWalletAccount`
  - The limitations on the `id` field of the `Institution` model have been removed to make the field suitable for a wider range of applications. The values in this field need no longer be defined by Electrum and similar values as recognised at third parties may now be carried in this field. However, care should be taken during implementation to ensure that different parties agree on the values which will be present in these fields.

## v2.5.0

Released 18 January 2019
- Added `ON_HOLD` and `UNCONFIRMED` to the `StatusEnum` in the `MoneyTransferLookupResponse`. These may be used when a transaction has entered a frozen/on hold state, or if only the first leg of a dual leg transaction has completed respectively.

## v2.4.0

Released 6 November 2018
 - Added `TRANSACTION_LIMIT_EXCEEDED` to the `ErrorTypeEnum`. This may be used to indicate if a single transaction's limit was exceeded.

## v2.3.0

Released 29 October 2018
 - Added `cashierComment` to `MoneyTransferRedeemRequest`. This field may be used to describe suspicious behaviour observed by the cashier.

## v2.2.1

Released 18 September 2018
 - Added `@DoNotPersist` annotation to the `IdNumber` field of `PersonalDetails` model.
 - Masked the `IdNumber` field in the `PersonalDetails` models `toString()` method.
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
