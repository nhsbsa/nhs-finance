package com.nhsbsa.webdriver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

/**
 * Created by jeffreya on 23/08/2016.
 */
public class DriverManager {

    private static WebDriver WEB_DRIVER;

    private static final URL chromeDriver;

    static {
        String driverName = "chromedriver";
        if (StringUtils.contains(System.getProperty("os.name").toLowerCase(), "windows")) {
            driverName += ".exe";
        }
        chromeDriver = DriverManager.class.getClassLoader().getResource(driverName);
        System.setProperty("webdriver.chrome.driver", chromeDriver.getPath());
    }

    public static void navigate(final String url) {
        System.out.println("the url:" + url);
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
