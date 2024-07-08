Feature: adding a new employee
  @SmokeTest
  Scenario Outline: adding a new user in the hrm management system
    Given LAUNCHING BROWSER WE`RE AT THE DASHBOARD PAGE
    And AFTER LOGIN HEAD TO PIM EMPLOYEE PAGE
    When ADD A USERNAME AND PASSWORD AND ADD THE FULL NAME
    And ADD HIS PERSONAL CREDENTIALS
    Then ADD HIS CONTACT AND ATTACHMENT FILE AND PRESS SAVE
    Examples:
      | Fname | lname | mname | ID-Employee | Username  | Password  | Password  |
      | ahmed | said  | ahmed | 01234       | AERO1234@ | ensakh14@ | ensakh14@ |

