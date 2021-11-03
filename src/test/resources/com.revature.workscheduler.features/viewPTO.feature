Feature: When user logs in, remaining PTO should be displayed
  Scenario: When user is logged in, remaining PTO should be displayed on their dashboard
    Given user has logged in
    Then the user should be on their dashboard
    And the user's remaining PTO should be displayed

