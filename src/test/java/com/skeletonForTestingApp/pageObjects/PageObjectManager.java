package com.skeletonForTestingApp.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegistationPage registationPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }
    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }
    public RegistationPage getRegistationPage() {
        registationPage = new RegistationPage(driver);
        return registationPage;
    }
}
