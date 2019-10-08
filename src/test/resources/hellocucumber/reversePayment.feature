Feature: When a client performs a reverse payment, a successful reversal payment is returned to them

  Scenario: Client sends a reverse payment request pre-tender
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And store-specific reversal message details
    When the client sends a reverse payment request
    Then the client receives a successful payment reversal response message
    And money voucher is non-redeemable