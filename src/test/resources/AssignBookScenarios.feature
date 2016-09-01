@run
Feature: Assign Book Scenarios
  Background:
    Given I am on the Login page
  Scenario: Scenario 1
    Then Login with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
    When User browse to Book List View
    Then User see an Assign button in the Book Item
    Then User click a button
    Then User redirected to Assign Book View
    Then I close a browser