package com.skeletonForTestingApp.pageObjects;

import com.skeletonForTestingApp.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Utils utils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        utils = new Utils(driver);
    }

    @FindBy(id = "loginPopup")
    private WebElement loginPopup;

    @FindBy(xpath = "//span[contains(.,\"Create new account\")] /parent::a")
    private WebElement createNewAccount;

    public void checkLoginPage() {
        driver.switchTo().frame(loginPopup);
        assertEquals(true, driver.getPageSource().contains("Sign in here!"));
    }
    public void clickOnCreateNewAccount() {
        createNewAccount.click();
    }
}
