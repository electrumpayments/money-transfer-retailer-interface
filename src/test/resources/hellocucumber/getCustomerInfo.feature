Feature: When a client sends a get customer info request, a response detailing whether the customer is a known user is returned

  Scenario: Client sends a get customer info request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And customer/sender ID number
    When the client sends a get customer info request
    Then the client receives a response detailing whether or not the customer is a known user