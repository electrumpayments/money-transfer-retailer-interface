Feature: When a client performs a lookup order, the details of the order are returned to them.

  Scenario: Client sends a lookup order request
  Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And Receiver cell phone number
    And Valid voucher number
    When The client sends a lookup order request
    Then The client receives the order details back for the corresponding order reference number