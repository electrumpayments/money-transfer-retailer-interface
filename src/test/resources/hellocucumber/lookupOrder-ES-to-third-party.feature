Feature: When a lookupOrder request is sent from the Electrum Switch, the Electrum Switch receives a successful MoneyTransferOrderResponse from the third party

  Scenario: Electrum Switch sends a lookupOrder request
    Given a live POS/Electrum connection
    And a live Electrum/Capitec connection
    And the lookupOrder contains a valid voucher number, the corresponding PIN and the correct transfer amount
    When The Electrum Switch sends a lookupOrder request
    And The third party receives this request message
    Then The third party returns a successful MoneyTransferOrderResponse to the Electrum Switch detailing that the order exists and is redeemable

