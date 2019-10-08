Feature: When a client performs a reverse redeem, a successful reversal message is returned to them

  Scenario: Client sends a reverse redeem request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And store-specific reversal message details
    When the client sends a reverse redeem request
    Then the client receives a successful reversal response message
