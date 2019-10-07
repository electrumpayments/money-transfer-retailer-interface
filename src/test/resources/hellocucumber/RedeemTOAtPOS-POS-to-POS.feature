Feature: When a client performs a redeem order and a timeout occurs at the client, an error detail message is returned to them and a reverseRedeem message is sent.

  Scenario: Client sends a redeem order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And customer has the corresponding PIN
    When The client sends a redeem order request
    And A timeout occurs at the client
    Then The client sends a reverse redeem message
