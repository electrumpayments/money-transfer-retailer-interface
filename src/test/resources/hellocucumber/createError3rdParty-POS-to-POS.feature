Feature: When a client performs a create order and an error occurs at the third party, an error detail message is returned to them

  Scenario: Client sends a create order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When The client sends a create order request
    And PIN is generated and captured by customer
    And receiver cell phone number is captured
    And Amount to be transferred is captured
    And an error occurs at the third party
    Then The client receives a error detail message
