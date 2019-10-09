Feature:When a client sends a create order request and a timeout occurs at the Electrum Switch, an error detail message is returned to them and the order creation is reversed

  Scenario: Client sends a create order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When the client sends a create order request
    And PIN is generated and captured by customer
    And receiver cell phone number is captured
    And amount to be transferred is captured
    And a timeout occurs at the Electrum Switch
    Then the client receives a error detail message
    And the order creation is automatically reversed
    And the Money Voucher is non-redeemable