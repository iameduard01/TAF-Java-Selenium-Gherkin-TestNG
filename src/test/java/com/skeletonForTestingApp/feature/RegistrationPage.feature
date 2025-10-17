Feature: Registration page
@test
  Scenario: Register a user
    Given I get to op.europa.eu
    Then I check if the title is European Parliament
    Then I click on login button
    Then I check if I land on Login page
    Then I click on register new account
    Then I check if I land on Registration Page
    Then I fill in the form
    Then I click on terms check box
    Then I click on register button
    Then Check for the confirmation message