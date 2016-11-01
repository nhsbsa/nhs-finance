package com.nhsbsa.finance;

import com.nhsbsa.finance.pageobjects.FinanceLoginPage;
import com.nhsbsa.webdriver.DriverManager;
import com.nhsbsa.webdriver.NavigationManager;
import cucumber.annotation.en.Given;
import org.openqa.selenium.support.PageFactory;

import static com.nhsbsa.finance.pageobjects.FinancePages.financeLoginPage;

/**
 * Created by MattHood on 01/11/2016.
 */
public class AuthenticationSteps {

    @Given("^user navigates to finance login page$")
    public void user_navigates_to_member_login_page() {
        NavigationManager.navigateToLogin(NavigationManager.FINANCE_WEBSITE + "/login");
        financeLoginPage = PageFactory.initElements(DriverManager.getDriver(), FinanceLoginPage.class);
    }
}
