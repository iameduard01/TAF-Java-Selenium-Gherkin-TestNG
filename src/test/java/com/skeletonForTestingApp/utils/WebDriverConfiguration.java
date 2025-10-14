package com.skeletonForTestingApp.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class WebDriverConfiguration {
    private WebDriver driver;

    public WebDriver getWebdriver() {
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/src/test/resources/config.properties")));
            String browser = properties.getProperty("browser");
            if (driver == null) {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(ChromeDriverOption.getChromeOptions());
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
