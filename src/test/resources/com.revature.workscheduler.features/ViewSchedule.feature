Feature: User Views Upcoming Schedule
  Background:
    Given User is on the login screen
    When User types in the correct username
    And User types in the correct password
    And User presses enter
    Then User is on the main user control screen

  Scenario : User views the work schedule
    Given User is on the main user control screen
    When the user clicks the view schedule tab
    Then the users is on the work schedule page