Feature: LoginPage

  Scenario:  Check user is able to login with valid credentials
    Given user navigates to European Union home page
    When user logs in with "valid" credentials
    Then the user has successfully logged in

  Scenario:  Check user able to login with invalid credentials
    Given user navigates to European Union home page
    When user logs in with "invalid" credentials
    Then the user has unsuccessfully logged in
