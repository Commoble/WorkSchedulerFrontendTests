Feature: User requests time off
  Background:
    Given User is on the login screen
    When User types in the correct username
    And User types in the correct password
    And User presses enter
    Then User is on the main user control screen

  Scenario: User views time off screen
    When User clicks the time off button
    Then User is on the time off screen

  Scenario: User requests time off
    When User clicks the time off button
    When User fills out the time off request form
    Then The request confirmation is shown