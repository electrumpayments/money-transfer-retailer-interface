Feature: When a client performs a reverse redeem, the order redemption is reversed

  Scenario: Client sends a reverse redeem request pre-payout
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When the client sends a reverse redeem request
    And store-specific reversal message details are inputted
    Then the client receives a successful reversal response message
    And order redemption is reversed
