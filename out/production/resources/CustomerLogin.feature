Feature: Customer Login in Banking
  Scenario:Customer  logs in  and see his balance
    Given customer is on home page
    When customer clicks customer login button
    And customer choose his name on name list
    And clicks button login
    Then he see his data

  @Test1
  Scenario:Customer see his transactions
    When customer logs in
    When customer clicks transactions button
    And  choose a different date
    Then he see his transactions by date

  @Test2
  Scenario:Customer Reset his transaction
    When customer logs in and goes to transaction page
    And clicks reset button
    Then all transactions are deleted

  @Test3
  Scenario:Go back and click deposit to put some deposit on logged user
    When customer logs in and goes to transaction page and click reset
    And customer goes back
    And clicks deposit button
    And enter amount of money
    And clicks deposit
    And he clicks transactions button
    Then he see his last deposit

