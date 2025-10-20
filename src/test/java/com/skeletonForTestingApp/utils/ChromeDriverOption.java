package com.skeletonForTestingApp.utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverOption {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.addArguments("--disable-popup-blocking");
        return chromeOptions;
    }
}
