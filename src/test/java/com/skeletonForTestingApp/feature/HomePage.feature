
Feature: HomePage

  Scenario: Check user is on the home page of op.europa.eu
    Given I get to op.europa.eu
    Then I check if the title is European Parliament

    Scenario: Check user is able to register
      Given I get to op.europa.eu
      When I click on login button