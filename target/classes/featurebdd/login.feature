Feature: login page
  @SmokeTest
  Scenario Outline: testing login page
    Given we are on the login page
    When entering a Moh97_i as username and  WH12369@ as password
    And  i pressed enter and opened a new page
    And  entering a Admin as username and admin123 as password
    Then i should see login successful

    Examples:
      | usernames | Password | usernames | Password |
      | Moh97_i   | WH12369@ | Admin     | admin123 |