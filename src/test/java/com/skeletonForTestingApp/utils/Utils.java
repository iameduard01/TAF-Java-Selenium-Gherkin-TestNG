package com.skeletonForTestingApp.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForTextToAppear(String text, Duration duration) {
        By xpath = By.xpath(String.format("//*[contains(text(),'%s')]", text));
        WebDriverWait driverWait = new WebDriverWait(driver, duration);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(xpath));
    }

}
