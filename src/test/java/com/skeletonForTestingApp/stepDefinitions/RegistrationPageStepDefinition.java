package com.skeletonForTestingApp.stepDefinitions;

import com.skeletonForTestingApp.pages.RegistationPage;
import com.skeletonForTestingApp.context.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPageStepDefinition {
    private TestContextSetup testContextSetup;
    private RegistationPage registationPage;

    public RegistrationPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.registationPage = testContextSetup.getPageObjectManager().getRegistationPage();
    }

    @Then("I fill in the form")
    public void iFillInTheForm() throws InterruptedException {
        registationPage.fillRegistrationForm();
    }

    @Then("I check if I land on Registration Page")
    public void iCheckIfILandOnRegistrationPage() {
        registationPage.checkRegistrationPage();
    }

    @Then("I click on terms check box")
    public void iClickOnTermsCheckBox() {
        registationPage.clickOnTermsCheckBox();
    }

    @Then("I click on register button")
    public void iClickOnRegisterButton() {
        registationPage.clickOnRegisterButton();
    }

    @Then("Check for the confirmation message")
    public void checkForTheConfirmationMessage() {
        registationPage.checkConfirmationMessage();
    }

    @When("user fill in the registration form")
    public void userFillInTheRegistrationForm() {

    }
}
