@run
Feature: Authorization Scenarios

  Background:
    Given I am on the Login page

  Scenario: Scenario 1

    And Login field displayed
    And Password field displayed
    And Sign In button displayed
    And Logo displayed
    And Login Message displayed
    Then I close a browser

  Scenario: Scenario 2

    Then User filed "agershkovich@lohika.com" and "456rtyAG$%^RTY" fields with LOHIKA creds
    When User click Sign In button
    Then User redirect to Main Page of BookShelf
    Then "Alexey Gershkovich" is displayed in Header
    Then I close a browser

  Scenario: Scenario 3

    When User navigate to /app/books route without authorization
    Then User redirect to Login view
    Then I close a browser


