Feature: When a client performs a redeem order, a successful redeem response message is returned to them

  Scenario: Client sends a redeem order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And customer has the corresponding PIN
    When The client sends a redeem order request
    Then The client receives a successful redemption response message