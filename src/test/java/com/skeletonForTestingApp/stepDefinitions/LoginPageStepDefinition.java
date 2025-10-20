package com.skeletonForTestingApp.stepDefinitions;

import com.skeletonForTestingApp.pageObjects.HomePage;
import com.skeletonForTestingApp.pageObjects.LoginPage;
import com.skeletonForTestingApp.utilities.TestContextSetup;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinition {
    private TestContextSetup testContextSetup;
    private LoginPage loginPage;
    private HomePage homePage;

    public LoginPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.loginPage = testContextSetup.getPageObjectManager().getLoginPage();
        this.homePage = testContextSetup.getPageObjectManager().getHomePage();
    }


    @Then("I check if I land on Login page")
    public void iCheckIfILandOnLoginPage() {
        loginPage.checkLoginPage();
    }

    @Then("I click on register new account")
    public void iClickOnRegisterNewAccount() {
        loginPage.clickOnCreateNewAccount();
    }


    @When("user logs in with {string} credentials")
    public void userLogsInWithCredentials(String arg0) {
        loginPage.loginWithCredentials(arg0);

    }

    @Then("the user has successfully logged in")
    public void theUserHasSuccessfullyLoggedIn() {
        loginPage.checkUserIsLoggedIn();
    }

    @Then("the user has unsuccessfully logged in")
    public void theUserHasUnsuccessfullyLoggedIn() {
       loginPage.checkUserIsNotLogin();
    }
}
