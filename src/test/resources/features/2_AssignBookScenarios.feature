#@run
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
    Then All UI elements of Assign Book page are presented
      And I close a browser


  Scenario: Check that the book name does not change during the assignment (Assign Book Scenario 3)
    Given I am on the Main page with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
     And User sees a Books's title in the Book Item
    When User sees an Assing Book form
    Then The value in Assign Book field is equal to Book's title that was selected in Book list view
      And I close a browser



