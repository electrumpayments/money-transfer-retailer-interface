Feature: When a client performs a reverse payment, a successful reversal payment is returned to them

  Scenario: Client sends a reverse payment request pre-tender
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And Store-specific reversal message details
    When The client sends a reverse payment request
    Then The client receives a successful payment reversal response message
    And Money Voucher is non-redeemable