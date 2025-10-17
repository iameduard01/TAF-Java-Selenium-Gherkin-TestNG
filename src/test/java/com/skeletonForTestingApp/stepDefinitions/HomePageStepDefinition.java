package com.skeletonForTestingApp.stepDefinitions;

import com.skeletonForTestingApp.pageObjects.HomePage;
import com.skeletonForTestingApp.utilities.TestContextSetup;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinition {
    private TestContextSetup testContextSetup;
    private HomePage homePage;

    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.getPageObjectManager().getHomePage();
    }

    @Given("I get to op.europa.eu")
    public void iGetToOpEuropaEu() {
        homePage.getToHomePage();
    }

    @Then("I check if the title is European Parliament")
    public void iCheckIfTheTitleIsEuropeanParliament() {
        homePage.validateTitle();
    }

    @When("I click on login button")
    public void iClickOnLoginButton() {
        homePage.clickOnLoginButton();
    }
}
