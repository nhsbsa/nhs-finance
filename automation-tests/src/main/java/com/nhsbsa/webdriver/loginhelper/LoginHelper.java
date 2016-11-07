package com.nhsbsa.webdriver.loginhelper;

import com.nhsbsa.webdriver.NavigationManager;

/**
 * Created by ianfulcher on 01/11/2016.
 */
public class LoginHelper {


    public static void financeStartPage() {

        NavigationManager.navigateToStartPage(NavigationManager.FINANCE_WEBSITE);
    }

    public static void financeLoginPage() {
        NavigationManager.navigateToLoginPage(NavigationManager.FINANCE_WEBSITE);
    }

}
