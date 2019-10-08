Feature: When a client performs a redeem order and a timeout occurs at the Electrum Switch, an error detail message is returned to them and a reverseRedeem message is sent

  Scenario: Client sends a redeem order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And customer has the corresponding PIN
    And A timeout occurs at the Electrum Switch
    When The client sends a redeem order request
    Then The client receives a error detail message
    And The redemption is automatically reversed