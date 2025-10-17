Feature: LoginPage

  Scenario: Check user is on login page
    Given I get to op.europa.eu
    Then I check if the title is European Parliament
    Then I click on login button
    Then I check if I land on Login page

