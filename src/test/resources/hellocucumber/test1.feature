Feature: When a response is not received after a specific time, the Money Transfer is automatically reversed

  Scenario: Electrum_Switch receives an 0200 message
    Given a Running Electrum_Switch
    And an 0200 message
    When the switch has created and sent a MoneyTransferRedeemRequest
    And at least sixty seconds have elapsed
    Then the switch automatically produces a MoneyTransferReversal
    And the MoneyTransferReversal has the requestId of the Money Transfer being reversed
    And the MoneyTransferReversal date and time are the same as the request being reversed