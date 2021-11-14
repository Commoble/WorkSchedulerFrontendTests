Feature: Manager assigns shifts
  Background:
    Given User is on the login screen
    When User types in the correct username
    And User types in the correct password
    And User presses enter
    Then User is on the main user control screen

  Scenario: Manger has ability to assign shifts
    Given User is on the main user control screen
    When The manager clicks  create new schedule.
    Then The manger see available employees to add to schedule.