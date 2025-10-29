package com.skeletonForTestingApp.context;

import com.skeletonForTestingApp.driver.WebDriverConfiguration;
import com.skeletonForTestingApp.pages.pageManager.PageObjectManager;
import com.skeletonForTestingApp.utils.Utils;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {
    public WebDriver driver;
    public WebDriverConfiguration webdriverConfiguration;
    public PageObjectManager pageObjectManager;
    public Utils utils;

    public TestContextSetup() {
        webdriverConfiguration = new WebDriverConfiguration();
        driver = webdriverConfiguration.getWebdriver();
        pageObjectManager = new PageObjectManager(driver);
        utils = new Utils(driver);
    }

    public Utils getUtils() {
        return utils;
    }

    public WebDriverConfiguration getWebdriverConfiguration() {
        return webdriverConfiguration;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
