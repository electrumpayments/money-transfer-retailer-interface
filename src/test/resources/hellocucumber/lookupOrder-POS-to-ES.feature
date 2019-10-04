Feature: When a lookupOrder request is sent from POS, the Electrum Switch sends a lookupOrder request to the third party

  Scenario: POS sends a lookupOrder request
  Given a live POS/Electrum connection
    And a live Electrum/Capitec connection
    And customer has a valid voucher number, the corresponding PIN and the correct transfer amount
    When The POS sends a lookupOrder request
    And Electrum Switch receives the lookupOrder request
    Then Electrum Switch automatically sends a lookupOrder request to Capitec