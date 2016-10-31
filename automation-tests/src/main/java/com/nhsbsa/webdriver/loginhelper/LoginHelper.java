package com.nhsbsa.webdriver.loginhelper;

import com.nhsbsa.webdriver.NavigationManager;

/**
 * Created by jeffreya on 05/09/2016.
 */
public class LoginHelper {


    public static void memberLogin() {

        NavigationManager.navigateToLogin(NavigationManager.MEMBER_WEBSITE);


    }

    public static void employerLogin() {

        NavigationManager.navigateToLogin(NavigationManager.EMPLOYER_WEBSITE);


    }
}
