package com.nhsbsa.webdriver.navigation;

import com.nhsbsa.webdriver.DriverManager;
import com.nhsbsa.webdriver.NavigationManager;

/**
 * Created by jeffreya on 05/09/2016.
 */
public class MemberNavigation extends NavigationManager {

    public static void navigateToPersonalDetails() {
        DriverManager.navigate(NavigationManager.MEMBER_WEBSITE + "/details");
    }


}
