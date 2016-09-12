@run
Feature: Assign Book Scenarios
  Scenario: Redirection to Assign Book Page (Assign Book Scenario 1)
    Given I am on the Login page
    And Login with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
    And User browse to Book List View
    And User see an Action button in the Book Item
    And User click Action button
    And User see Back View of Book Item
    When User click Assign button
    Then User redirected to Assign Book View
    And I close a browser

  Scenario: Checking if UI elements are presents on Assign Book page (Assign Book Scenario 2)
    Given I am on the Login page
    When User browse to Assign Book View as "agershkovich@lohika.com" and "456rtyAG$%^RTY"
    And Assign Book drop-down list displayed
    And To User drop-down list displayed
    And Assign book button displayed
    Then User see an Assing Book form
    And I close a browser


