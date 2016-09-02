@run
Feature: Assign Book Scenarios

  Background:

    Given I am on the Login page

  Scenario: Scenario 1

    Then Login with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
    When User browse to Book List View
    Then User see an Action button in the Book Item
    When User click Action button
    Then User see Back View of Book Item
    When User click Assign button
    Then User redirected to Assign Book View
    Then I close a browser