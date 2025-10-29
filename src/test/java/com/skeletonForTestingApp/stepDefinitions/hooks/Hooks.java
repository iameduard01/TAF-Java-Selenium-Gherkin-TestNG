package com.skeletonForTestingApp.stepDefinitions.hooks;

import com.skeletonForTestingApp.context.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {
    private TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario() {
        this.testContextSetup.getWebdriverConfiguration().getWebdriver().quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        WebDriver webdriver = testContextSetup.getWebdriverConfiguration().getWebdriver();
        if (scenario.isFailed()) {
            File source = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
            byte[] bytes = FileUtils.readFileToByteArray(source);
            scenario.attach(bytes, "image/png", "image");
        }
    }
}
