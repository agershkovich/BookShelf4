@run
Feature: Authorization Scenario 1

  Background:
    Given I am on the Login page

  Scenario: Scenario 1
    And Login field displayed
    And Password field displayed
    And Sign In button displayed
    And Logo displayed
    And Login Message displayed
    Then I close a browser
