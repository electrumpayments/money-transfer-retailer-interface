Feature: When a client performs a confirm redeem, a successful confirmation message is returned to them

  Scenario: Client sends a confirm redeem request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When The client sends a confirm redeem request
    Then The client receives a successful confirmation response message
    And The customer is paid out the transfer amount
    And A till slip is printed