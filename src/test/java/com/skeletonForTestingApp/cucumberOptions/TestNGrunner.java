package com.skeletonForTestingApp.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        //location of scenarios
        features = "src/test/java/com/skeletonForTestingApp/feature",
        //scenarios are linked with step definitions
        glue = "com.skeletonForTestingApp.stepDefinitions",
        //log esthetics
        monochrome = true,
        //executable tags
        tags = "@test",
        //generate report for failed scenarios
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"},
        //verify the hole thing
        dryRun = false
)
public class TestNGrunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
