package com.nhsbsa.finance;

import com.nhsbsa.finance.pageobjects.FinanceLoginPage;
import com.nhsbsa.webdriver.DriverManager;
import com.nhsbsa.webdriver.NavigationManager;
import com.nhsbsa.webdriver.accessibility.AccessibilityChecker;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.support.PageFactory;

import static com.nhsbsa.finance.pageobjects.FinancePages.financeLoginPage;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by MattHood on 01/11/2016.
 */
public class AuthenticationSteps {

    @Given("^user navigates to finance login page$")
    public void user_navigates_to_member_login_page() {
        NavigationManager.navigateToLogin(NavigationManager.FINANCE_WEBSITE + "/login");
        financeLoginPage = PageFactory.initElements(DriverManager.getDriver(), FinanceLoginPage.class);
    }

    @Given("^user is logged in with email '(.*)' and password '(.*)'$")
    public void user_logs_in_with_email_and_password(String email, String password) {
        user_enters_valid_email_and_password(email, password);
    }

    @When("^user enters valid email '(.*)' and password '(.*)'$")
    public void user_enters_valid_email_and_password(String email, String password) {
        financeLoginPage.enterUserName(email);
        financeLoginPage.enterPassword(password);
        financeLoginPage = financeLoginPage.submit();
    }

    @When("^user enters invalid email '(.*)' and password '(.*)'$")
    public void user_enters_invalid_email_and_password(String email, String password) {
        financeLoginPage.enterUserName(email);
        financeLoginPage.enterPassword(password);
        financeLoginPage.submitWithErrors();
    }

    @Then("^finance login page should pass accessibility checker$")
    public void checkPageAccessibility() throws InterruptedException {
        AccessibilityChecker.checkAccessibility(NavigationManager.FINANCE_WEBSITE + "/login");
    }

    @Then("^error text should be displayed on finance login page$")
    public void error_text_should_be_displayed_on_member_login_page() {
        String errorMessage = financeLoginPage.getErrorMessage();
        assertThat(errorMessage, is(equalTo("The username and password combination are not valid")));
    }
}
