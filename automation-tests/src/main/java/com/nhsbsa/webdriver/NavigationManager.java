package com.nhsbsa.webdriver;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Driver;
import java.util.Properties;

//import java.util.Map;

/**
 * Created by jeffreya on 23/08/2016.
 */
@Slf4j
public class NavigationManager {

    private static final URL applicationProperties = DriverManager.class.getClassLoader().getResource("application.properties");
    public static String FINANCE_WEBSITE;

    public static String ACHECKER_WEBSITE;
    public static String ACHECKER_ID;
    public static String ACHECKER_OUTPUT;
    public static String ACHECKER_GUIDE;

    static {
        final Properties properties = new Properties();

        InputStream input = null;
        try {
            input = new FileInputStream(applicationProperties.getFile());
            properties.load(input);

            FINANCE_WEBSITE = System.getenv("finance_frontend_url");
            if (StringUtils.isBlank(FINANCE_WEBSITE)) {
                FINANCE_WEBSITE = "localhost:8080";
                log.warn("NO URL PROVIDED, DEFAULTING TO LOCALHOST:8080");
            }

            // application.properties under the src/test/resources/
            ACHECKER_WEBSITE = properties.getProperty("achecker.webservice.url");
            ACHECKER_ID = properties.getProperty("achecker.webservice.id");
            ACHECKER_OUTPUT = properties.getProperty("achecker.webservice.output");
            ACHECKER_GUIDE = properties.getProperty("achecker.webservice.guide");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void navigateToStartPage(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/start");
    }

    public static void navigateToStartPageSlash(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/");
    }
    public static void navigateToLoginPage(String BASE_URL) {

        DriverManager.navigate(BASE_URL + "/login");
    }

    public static void navigateToInvalidLoginError(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/login?error");
    }

    public static void navigateToLogout(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/logout");
    }

}
