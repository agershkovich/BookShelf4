@run
Feature: Details Page
  Scenario: DrillDown to Details Page
    Given I am on the Main page with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
    When I click on the Book Item
    Then I routed to Detail Page
      And I close a browser