package com.skeletonForTestingApp.pages;

import com.skeletonForTestingApp.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Utils utils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        utils = new Utils(driver);
    }

    @FindBy(xpath = "//span[contains(.,\"Log in\")] /parent::a")
    private WebElement loginButton;

    @FindBy(id = "loginPopup")
    private WebElement loginPopup;

    @FindBy(id = "open-opia-bottom-icon")
    private WebElement bottomIcon;

    public String getHomePageLink(){
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/src/test/resources/credentials.properties")));
            String link = properties.getProperty("linkForHomePage");
            return link;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getToHomePage() {
        driver.get(getHomePageLink());
        validateTitle();
    }
    public void validateTitle(){
        wait.until(ExpectedConditions.titleIs("Home - Publications Office of the EU"));
        Assert.assertEquals(driver.getCurrentUrl(), getHomePageLink());
    }

    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(bottomIcon));
        loginButton.click();
    }
}
