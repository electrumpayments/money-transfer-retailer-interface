Feature:When a client sends a create order request and a timeout occurs at the Electrum Switch, an error detail message is returned to them and a reversePayment message is sent

  Scenario: Client sends a create order request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And A timeout occurs at the Electrum Switch
    When The client sends a create order request
    And PIN is generated and captured by customer
    And receiver cell phone number is captured
    And Amount to be transferred is captured
    Then The client receives a error detail message
    And The order creation is automatically reversed
    And Money Voucher is non-redeemable