package com.nhsbsa.webdriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by jeffreya on 23/08/2016.
 */
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

            FINANCE_WEBSITE = System.getenv("finance.frontend.url");

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

    public static void navigateToLogin(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/login");
    }

    public static void navigateToInvalidLoginError(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/login?error");
    }

    public static void navigateToLogout(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/logout");
    }


}
