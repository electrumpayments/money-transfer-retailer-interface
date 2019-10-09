Feature: When a client performs a redeem order, a successful redeem response message is returned to them

  Scenario: Client sends a redeem order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When the client sends a redeem order request
    And customer inputs the correct corresponding PIN
    Then the client receives a successful redemption response message