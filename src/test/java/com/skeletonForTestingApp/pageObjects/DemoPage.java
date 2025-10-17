package com.skeletonForTestingApp.pageObjects;

import com.skeletonForTestingApp.utils.ChromeDriverOption;
import com.skeletonForTestingApp.utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class DemoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Utils utils;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        utils = new Utils(driver);
    }

    public void getToGoogle() {
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/src/test/resources/credentials.properties")));
            String link = properties.getProperty("link");
            driver.get(link);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
