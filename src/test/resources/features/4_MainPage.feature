@run
Feature: Main Page Design
   Scenario: Book Items has Flags with Language and Label
     Given I am on the Main page with admin "agershkovich@lohika.com" and "456rtyAG$%^RTY"
     When Admin sees Book Item
     Then Admin sees Language Flag and Label Flag