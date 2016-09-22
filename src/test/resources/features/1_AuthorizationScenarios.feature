@run
Feature: Authorization Scenarios
  Scenario: Check if UI elements are presents (Authorization  Scenario 1)
    Given I am on the Login page
    When Login field displayed
    And Password field displayed
    And Sign In button displayed
    And Logo displayed
    Then Login Message displayed
    And I close a browser

  Scenario: Redirecting to Main Page after entering correct creds (Authorization Scenario 2)
    Given I am on the Login page
    And User filed "agershkovich@lohika.com" and "456rtyAG$%^RTY" fields with LOHIKA creds
    And User click Sign In button
    And User redirect to Main Page of BookShelf
    Then "Alexey Gershkovich" is displayed in Header
    And I close a browser

  Scenario: User without authorization should be routed to Login View (Authorization Scenario 3)
    Given I am on the Login page
    When User navigate to /app/books route without authorization
    Then User redirect to Login view
    And I close a browser







