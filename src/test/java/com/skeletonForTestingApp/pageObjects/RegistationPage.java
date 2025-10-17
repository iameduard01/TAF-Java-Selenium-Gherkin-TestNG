package com.skeletonForTestingApp.pageObjects;

import com.skeletonForTestingApp.utilities.Utils;
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

public class RegistationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Utils utils;

    public RegistationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        utils = new Utils(driver);
    }

    @FindBy(id = "_eu_europa_publications_portlet_user_registration_UserRegistrationPortlet_INSTANCE_nFGwDJ8p6Q24_firstName")
    private WebElement firstName;

    @FindBy(id ="_eu_europa_publications_portlet_user_registration_UserRegistrationPortlet_INSTANCE_nFGwDJ8p6Q24_lastName")
    private WebElement lastName;

    @FindBy(id = "_eu_europa_publications_portlet_user_registration_UserRegistrationPortlet_INSTANCE_nFGwDJ8p6Q24_email2")
    private WebElement email;

    @FindBy(id = "_eu_europa_publications_portlet_user_registration_UserRegistrationPortlet_INSTANCE_nFGwDJ8p6Q24_password")
    private WebElement password;

    @FindBy(id = "_eu_europa_publications_portlet_user_registration_UserRegistrationPortlet_INSTANCE_nFGwDJ8p6Q24_passwordconfirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//label[contains(.,\"I read and understood\")]")
    private WebElement checkBoxTerms;
    
    @FindBy(xpath = "//span[contains(.,\"Register\")] /parent::button")
    private WebElement registerButton;

    @FindBy(xpath = "//strong[contains(.,\"Success\")] /parent::div")
    private WebElement confirmationMessage;


    public void checkRegistrationPage() {
        assertEquals(true, driver.getPageSource().contains("Create an account"));
    }

    public String fillRegistrationForm() throws InterruptedException {
        utils.waitForTextToAppear("Create an account", Duration.ofSeconds(3));
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/src/test/resources/credentials.properties")));
            firstName.sendKeys(properties.getProperty("firstName"));
            lastName.sendKeys(properties.getProperty("lastName"));
            email.sendKeys(properties.getProperty("email"));
            password.sendKeys(properties.getProperty("password"));
            confirmPassword.sendKeys(properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clickOnTermsCheckBox() {
        checkBoxTerms.click();
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

    public void checkConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        assertEquals(true, driver.getPageSource().contains("Success"));
    }
}
