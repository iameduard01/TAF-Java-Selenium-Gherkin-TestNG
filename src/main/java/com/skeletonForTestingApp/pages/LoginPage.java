package com.skeletonForTestingApp.pages;

import com.skeletonForTestingApp.utils.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Utils utils;
    private HomePage homePage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        utils = new Utils(driver);
        this.homePage = new HomePage(driver);
    }

    @FindBy(id = "loginPopup")
    private WebElement loginPopup;

    @FindBy(xpath = "//span[contains(.,\"Create new account\")] /parent::a")
    private WebElement createNewAccount;

    @FindBy(xpath = "//input[@id=\"username\"]")
    private WebElement emailTextBox;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id=\"kc-login\"]")
    private WebElement signinButton;

    @FindBy(xpath = "//a[contains(@aria-label,\"Logged\")]")
    private WebElement portalMenu;

    @FindBy(xpath = "//a[contains(@title,'Log out')]")
    private WebElement logoutButton;

    @FindBy(id = "open-opia-bottom-icon")
    private WebElement bottomIcon;
    
    @FindBy(xpath = "//span[contains(.,\"Invalid\")]/parent::div")
    private WebElement errorLoginMessage;

    public void checkLoginPage() {
        driver.switchTo().frame(loginPopup);
        assertEquals(true, driver.getPageSource().contains("Sign in here!"));
    }
    public void clickOnCreateNewAccount() {
        createNewAccount.click();
    }

    public void fillLoginForm(String arg) {
        switch (arg) {
            case "valid":
                Properties properties = new Properties();
                try {
                    properties.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/src/test/resources/credentials.properties")));
                    emailTextBox.sendKeys(properties.getProperty("email"));
                    passwordTextBox.sendKeys(properties.getProperty("password"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "invalid":
                emailTextBox.sendKeys(RandomStringUtils.randomAlphanumeric(10));
                passwordTextBox.sendKeys(RandomStringUtils.randomAlphanumeric(10));
                break;
        }
    }
    public void clickOnSigninButton() {
        signinButton.click();
        wait.until(ExpectedConditions.invisibilityOf(loginPopup));
    }
    public void switchFocusToHomePage(){
        driver.switchTo().parentFrame();
    }

    public void checkUserIsLoggedIn() {
        wait.until(ExpectedConditions.elementToBeClickable(portalMenu));
        portalMenu.click();
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        assertEquals(true, logoutButton.isDisplayed());
    }
    
    public void checkUserIsNotLogin(){
        wait.until(ExpectedConditions.visibilityOf(errorLoginMessage));
        assertEquals(true, errorLoginMessage.isDisplayed());
    }
    public void loginWithCredentials(String arg0) {
        switch (arg0) {
            case "valid":
                homePage.clickOnLoginButton();
                checkLoginPage();
                fillLoginForm(arg0);
                clickOnSigninButton();
                switchFocusToHomePage();
                break;
            case "invalid":
                homePage.clickOnLoginButton();
                checkLoginPage();
                fillLoginForm(arg0);
                clickOnSigninButton();
                checkUserIsNotLogin();
                break;
        }
    }
}
