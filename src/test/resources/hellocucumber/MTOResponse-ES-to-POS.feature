Feature: When a successful MoneyTransferOrderResponse is sent to the Electrum Switch, the POS receives a successful MoneyTransferOrderResponse

  Scenario: Electrum Switch sends a successful MoneyTransferOrderResponse
    Given a live POS/Electrum connection
    And the lookupOrder contains a valid voucher number, the corresponding PIN and the correct transfer amount
    When The Electrum Switch sends a lookupOrder request
    And The third party receives this request message
    Then The third party returns a successful MoneyTransferOrderResponse to the Electrum Switch detailing that the order exists and is redeemable
    And Electrum Switch receives this message
