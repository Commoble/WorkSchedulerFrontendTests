Feature: Manager assigns shifts
  Background:
    Given User is on the login screen
    When User types in the correct username
    And User types in the correct password
    And User presses enter
    Then User is on the main user control screen

  Scenario: Manger has ability to assign shifts
    When The manager clicks create new schedule
    And The manager selects a shift type and employee and clicks add shift
    Then the shift should be added