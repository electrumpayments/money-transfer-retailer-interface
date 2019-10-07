Feature: When a client performs a redeem order and an error occurs at the third party, an error detail message is returned to them

  Scenario: Client sends a redeem order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When The client sends a redeem order request
    And customer has the correct PIN
    And an error occurs at the third party
    Then The client receives an error detail message
