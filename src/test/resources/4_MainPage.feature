@run
Feature: Main Page
  Scenario: Book Items has Flags with Language and Label
    Given I am on the Main page with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
    When Admin sees Book Item
    Then Admin sees Language Flag and Label Flag
    And I close a browser