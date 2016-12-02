package com.nhsbsa.webdriver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

import lombok.extern.slf4j.Slf4j;

/**
 * Created/Modified by jeffreya/ianfulcher.
 */
@Slf4j
public class DriverManager {

    private static WebDriver WEB_DRIVER;

    // In your .profile setup environment variable to point to where the chromedriver exe is downloaded, like
    // /Users/joebloggs/software/chromedriver/chromedriver
    //private static final String CHROME_DRIVER = System.getenv("CHROME_DRIVER");
    private static final String CHROME_DRIVER = "/Users/MattHood/software/chromedriver/chromedriver";

    static {
        if (StringUtils.isBlank(CHROME_DRIVER)) {
            log.error("No chrome driver ENV found, set CHROME_DRIVER in .profile");
            System.exit(-1);
        } else {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        }

    }

    static void navigate(final String url) {
        getDriver().get(url);
    }

    public static void shutdown() {
        getDriver().quit();
        WEB_DRIVER = null;
    }

    public static WebDriver getDriver() {
        if (WEB_DRIVER == null) {
            WEB_DRIVER = new ChromeDriver();
        }
        return WEB_DRIVER;
    }

}
