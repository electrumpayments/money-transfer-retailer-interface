Feature: When a client sends a confirm payment request, a successful confirm payment response is returned

  Scenario: Client sends a confirm payment request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When The client sends a confirm payment request
    And Amount to be transferred is tendered in cash
    Then The client receives a successful confirm payment response
    And Till slip is printed for customer