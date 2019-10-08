Feature: When a client sends a create order request, a successful create order response is returned.

  Scenario: Client sends a create order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When The client sends a create order request
    And PIN is generated and captured by customer
    And receiver cell phone number is captured
    And Amount to be transferred is captured
    Then The client receives a successful create order response
