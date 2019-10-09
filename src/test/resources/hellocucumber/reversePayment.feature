Feature: When a client performs a reverse payment, the order creation is reversed

  Scenario: Client sends a reverse payment request pre-tender
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When the client sends a reverse payment request
    And store-specific reversal message details are inputted
    Then the client receives a successful payment reversal response message
    And the order creation is reversed