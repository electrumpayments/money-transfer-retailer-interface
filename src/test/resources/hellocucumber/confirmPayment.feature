Feature: When a client sends a confirm payment request, a successful confirm payment response is returned and a redeemable Money Voucher is created

  Scenario: Client sends a confirm payment request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When the client sends a confirm payment request
    And amount to be transferred is tendered in cash
    Then the client receives a successful confirm payment response
    And till slip is printed for customer
    And a redeemable Money Voucher is created