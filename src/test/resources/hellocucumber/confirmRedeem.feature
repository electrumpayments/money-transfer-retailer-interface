Feature: When a client performs a confirm redeem, a successful confirmation message is returned to them and the receiver is paid out

  Scenario: Client sends a confirm redeem request
    Given a client
    And an Electrum Switch
    And a Money Transfer Service
    When the client sends a confirm redeem request
    Then the client receives a successful confirmation response message
    And the customer is paid out the transfer amount
    And a till slip is printed
    And the Money Voucher is no longer redeemable