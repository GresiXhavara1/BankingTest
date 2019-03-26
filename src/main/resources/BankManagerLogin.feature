
Feature: Log In Of Bank Manager

  Scenario: Bank Manager Logs in and Add Customer
    Given manager is on home page
    When manager clicks login button
    And clicks add customer button
    And fill user first name
    And fill user last name
    And user postal code
    And click add customer
    Then click ok button on popup alert
    Then the customer is added
    And clicks on customers button to see the list of customers


    @Test1
    Scenario: Bank Manager is logged in and goes to customers to find a customer and to delete them.
      When manager is on customers page
      When manager find for a customer
      And he clicks delete button
      Then the customer is deleted
