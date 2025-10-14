package com.skeletonForTestingApp.stepDefinitions;

import com.skeletonForTestingApp.pageObjects.DemoPage;
import com.skeletonForTestingApp.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DemoStepDefinition {

    private TestContextSetup testContextSetup;
    private DemoPage demoPage;

    public DemoStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        demoPage = testContextSetup.getPageObjectManager().getDemoPage();
    }

    @Given("I get to google.com")
    public void iGetToGoogleCom() {
        demoPage.getToGoogle();
    }
}
