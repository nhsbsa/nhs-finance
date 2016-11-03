package com.nhsbsa.webdriver;


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

            // Get all the environment variables (for testing only to see what is defined)
            //Map<String, String> env = System.getenv();

            // Below is null, it needs to be set somewhere but isn't, comment out for now.
            //FINANCE_WEBSITE = System.getenv("finance.frontend.url");
            // Set the URL from what is in the application.properties for now.
            FINANCE_WEBSITE = properties.getProperty("finance.frontend.url");

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

    public static void navigateToLoginPage(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/login");
    }

    public static void navigateToInvalidLoginError(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/login?error");
    }

    public static void navigateToLogout(String BASE_URL) {
        DriverManager.navigate(BASE_URL + "/logout");
    }

    /*
    public static void navigateToPersonalDetails() {
        DriverManager.navigate(NavigationManager.MEMBER_WEBSITE + "/member/details");
    }
    */

}
