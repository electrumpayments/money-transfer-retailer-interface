Feature: When a client performs a lookup order, the details of the order are returned to them

  Scenario: Client sends a lookup order request
  Given a client
    And an Electrum Switch
    And a Money Transfer Service
    And an existing Money Transfer Voucher
    When the client sends a lookup order request
    And inputs the receiver cell phone number
    And inputs a valid voucher number
    Then the client receives the order details back for the corresponding order reference number