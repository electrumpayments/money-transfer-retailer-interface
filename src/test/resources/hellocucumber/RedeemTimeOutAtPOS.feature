Feature: When a client performs a redeem order and a timeout occurs at the client, the redemption is automatically reversed

  Scenario: Client sends a redeem order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When the client sends a redeem order request
    And customer inputs the correct corresponding PIN
    And a timeout occurs at the client
    Then the order redemption is automatically reversed