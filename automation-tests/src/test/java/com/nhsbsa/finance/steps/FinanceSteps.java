package com.nhsbsa.finance.steps;

import com.nhsbsa.finance.pageobjects.EmployerAccountInfoPage;
import com.nhsbsa.finance.pageobjects.SchedulePaymentPage;
import com.nhsbsa.webdriver.DriverManager;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import org.openqa.selenium.support.PageFactory;

import static com.nhsbsa.finance.pageobjects.FinancePages.employerAccountInfoPage;
import static com.nhsbsa.finance.pageobjects.FinancePages.schedulePaymentPage;

/**
 * Created by MattHood on 02/11/2016.
 * This is the page after the Finance Login, title "Security" and has the A/C Name/Number and EA Reference
 */
public class FinanceSteps {

    @Given("^employer account info page is displayed$")
    public void employer_account_info_page_is_displayed() {
        employerAccountInfoPage = PageFactory.initElements(DriverManager.getDriver(), EmployerAccountInfoPage.class);
    }

    @Then("^employer account info page should be displayed$")
    public void employer_account_info_page_should_be_displayed() {
        employer_account_info_page_is_displayed();
    }

    @Then("^schedule payment page should be displayed$")
    public void schedule_payment_page_should_be_displayed() {
        schedulePaymentPage = PageFactory.initElements(DriverManager.getDriver(), SchedulePaymentPage.class);
    }
}