package com.skeletonForTestingApp.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private DemoPage demoPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public DemoPage getDemoPage() {
        demoPage = new DemoPage(driver);
        return demoPage;
    }
}
