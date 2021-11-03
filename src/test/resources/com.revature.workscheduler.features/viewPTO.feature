Feature: When user logs in, remaining PTO should be displayed
  Scenario: When a non-manager user is logged in, remaining PTO should be displayed on their dashboard
    Given Non-Manager user has logged in
    Then the user should be on their dashboard
    And the user's remaining PTO should be displayed
  Scenario: When a non-manager user is logged in, remaining PTO should be displayed on their dashboard
    Given Manager user has logged in
    Then the user should be on their dashboard
    And the user's remaining PTO should be displayed

