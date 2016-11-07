package com.nhsbsa.finance.pageobjects.steps;

import com.nhsbsa.finance.pageobjects.FinanceStartPage;
import com.nhsbsa.finance.pageobjects.FinanceLoginPage;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import com.nhsbsa.webdriver.NavigationManager;
import com.nhsbsa.webdriver.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import junit.framework.Assert;
import org.openqa.selenium.By;
import static com.nhsbsa.finance.pageobjects.FinancePages.financeStartPage;
import static com.nhsbsa.finance.pageobjects.FinancePages.financeLoginPage;
import com.nhsbsa.webdriver.accessibility.AccessibilityChecker;

/**
 * Created by ianfulcher on 01/11/2016.
 */
public class AuthenticationSteps {


    // Given

    @Given("^user navigates to finance start page$")
    public void user_navigates_to_finance_start_page() {
        NavigationManager.navigateToStartPage(NavigationManager.FINANCE_WEBSITE);
        financeStartPage = PageFactory.initElements(DriverManager.getDriver(), FinanceStartPage.class);

        // Let the user actually see something! Comment out when not required. Value is in milliseconds.
        //try {
        //    Thread.sleep(5000);
        //} catch (InterruptedException ex) { }
    }

    @Given("^user navigates to finance start page slash$")
    public void user_navigates_to_finance_start_page_slash() {
        NavigationManager.navigateToStartPageSlash(NavigationManager.FINANCE_WEBSITE);
        financeStartPage = PageFactory.initElements(DriverManager.getDriver(), FinanceStartPage.class);
    }

    // Then

    @Then("^driver shutdown at end of test$")
    public void driver_shutdown_at_end_of_test() {
        DriverManager.shutdown();
    }

    @Then("^finance start page is displayed$")
    public void finance_start_page_is_displayed() {
        financeStartPage = PageFactory.initElements(DriverManager.getDriver(), FinanceStartPage.class);
    }

    @Then("^click start now button on finance start page")
    public void click_start_now_button_on_finance_start_page () {
        financeLoginPage = financeStartPage.startNowButton();
    }

    @Then("^finance login page is displayed$")
    public void finance_login_page_is_displayed() {
        financeLoginPage = PageFactory.initElements(DriverManager.getDriver(), FinanceLoginPage.class);
    }

    @Then("^error text should be displayed on finance login page$")
    public void error_text_should_be_displayed_on_finance_login_page() {
        final WebElement notification = DriverManager.getDriver().findElement(By.id("financeLoginErrorMessage"));
        final String text = notification.getText();
        Assert.assertEquals("Error message should match", "The username and password combination are not valid", text);
        DriverManager.shutdown();
    }

    @Then("^user clicks on logout button in finance login page")
    public void user_clicks_on_logout_button_in_finance_login_page() {
        financeLoginPage = financeLoginPage.logoutButton();
    }

    @Then("^logout text should be displayed on finance login page$")
    public void logout_text_should_be_displayed_on_finance_login_page() {
        final WebElement notification = DriverManager.getDriver().findElement(By.id("financeLogoutMessage"));
        final String text = notification.getText();
        Assert.assertEquals("Logout message should match", "You have been logged out.", text);
        DriverManager.shutdown();
    }

    @Then("^finance login page should pass accessibility checker$")
    public void checkPageAccessibility() throws InterruptedException {
        AccessibilityChecker.checkAccessibility(NavigationManager.FINANCE_WEBSITE + "/login");
    }

    // When

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


}
