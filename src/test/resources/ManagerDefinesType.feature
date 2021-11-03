Feature: Manager Defines Shift Type


  Scenario: Manager Defines Baker Shift
    Given the manager is on the login page
    When the manager logs in
    Then the manager selects create schedule
    Given the manager is on the schedule creator tab
    When the manager selects the Baker radio button or scroller
    Then the manager defines Baker


  Scenario: Manager Defines Cashier Shift
    Given the manager is on the login page
    When the manager logs in
    Then the manager selects create schedule
    Given the manager is on the schedule creator tab
    When the manager selects the Cashier radio button or scroller
    Then the manager defines Cashier


