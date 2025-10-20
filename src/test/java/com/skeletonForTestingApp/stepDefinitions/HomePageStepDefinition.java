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

    @Given("user navigates to European Union home page")
    public void userNavigatesToEuropeanUnionHomePage() {
        homePage.getToHomePage();
    }

    @When("I click on login button")
    public void iClickOnLoginButton() {
        homePage.clickOnLoginButton();
    }
}
