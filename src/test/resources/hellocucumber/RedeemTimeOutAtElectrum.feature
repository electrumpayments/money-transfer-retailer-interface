Feature: When a client performs a redeem order and a timeout occurs at the Electrum Switch, an error detail message is returned to them and a the redemption is reversed

  Scenario: Client sends a redeem order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When the client sends a redeem order request
    And customer has the correct corresponding PIN
    And a timeout occurs at the Electrum Switch
    Then the client receives a error detail message
    And the redemption is automatically reversed