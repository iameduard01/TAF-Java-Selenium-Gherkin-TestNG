package com.skeletonForTestingApp.stepDefinitions;

import com.skeletonForTestingApp.pageObjects.HomePage;
import com.skeletonForTestingApp.pageObjects.LoginPage;
import com.skeletonForTestingApp.utilities.TestContextSetup;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;

public class LoginPageStepDefinition {
    private TestContextSetup testContextSetup;
    private LoginPage loginPage;

    public LoginPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.loginPage = testContextSetup.getPageObjectManager().getLoginPage();
    }


    @Then("I check if I land on Login page")
    public void iCheckIfILandOnLoginPage() {
        loginPage.checkLoginPage();
    }

    @Then("I click on register new account")
    public void iClickOnRegisterNewAccount() {
        loginPage.clickOnCreateNewAccount();
    }
}
