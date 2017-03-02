@run
Feature: Main Page
  Scenario: Book Items has Flags with Language and Label
    Given I am on the Main page with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
    When Admin sees Book Item
    Then Admin sees Language Flag and Label Flag
      And I close a browser

  Scenario: Header Design and Refactoring
     Given I am on the Main page with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
     Then Admin see redesigned elements
       And I close a browser

  Scenario: Returning to Main page after clicking on the Logo
     Given I am on the Detail page with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
     When I click on the Logo
     Then I return to the Main Page
       And I close a browser