Feature: When a client sends a create or update customer request, a successful create or update customer response is returned

  Scenario: Client sends a create or update customer request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When the client sends a create or update customer request
    And sender cell phone number is inputted
    And sender source of funds is updated or confirmed
    Then the client receives a successful create or update customer response