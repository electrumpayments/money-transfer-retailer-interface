Feature: When a client sends a create or update customer request, a successful create or update customer response is returned

  Scenario: Client sends a create or update customer request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When The client sends a create or update customer request
    And Sender cell phone number is inputted
    And Sender source of funds is updated or confirmed
    Then The client receives a successful create or update customer response