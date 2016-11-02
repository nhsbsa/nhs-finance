package com.nhsbsa.webdriver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.io.File;

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

        // NOTE: The Mac version is 2.25 (Downloaded 2 November 2016), Dated 22 October 2016.
        chromeDriver = DriverManager.class.getClassLoader().getResource(driverName);
        System.setProperty("webdriver.chrome.driver", chromeDriver.getPath());

        // NOTE: .../nhs-finance/automation-tests/target/classes/<driverName>
        // As the chromedriver exe is copied to this location (or where defined 'TO" in the pom) from a location
        // (where defined 'FROM" in the pom) by Maven, it removes the execute permissions (for safety) so won't run.
        // Need to change the permissions where running from so it can be executed.
        // file.setExecutable changes the "user/owner" permissions to executable (if "true"), applies to Owner only

        File file = new File(chromeDriver.getFile());
        file.setExecutable(true);

        // REF: Sets the file so it is executable (if "true" in first argument)
        // 2nd argument is "apply to Owner only", so false means everyone otherwise true is owner only (like single argument method).
        //file.setExecutable(true, false);

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
