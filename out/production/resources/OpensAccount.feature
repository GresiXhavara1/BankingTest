Feature:Bank Manager logs in and opens an account for a user
  Scenario:Bank Manager opens an account for customer that is choosen from a dropdownlist
    Given bank manager is on home page
    When bank manager clicks login button
    And choose open account button for customer
    Then choose a customer from customer dropdownlist
    And choose the currency
    And clicks process button
    Then clicks ok button from a pop up alert
    Then customers is opened an account