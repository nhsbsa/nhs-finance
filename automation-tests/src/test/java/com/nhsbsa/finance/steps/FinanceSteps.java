package com.nhsbsa.finance.steps;

import com.nhsbsa.finance.pageobjects.EmployerAccountInfoPage;
import com.nhsbsa.finance.pageobjects.SchedulePaymentPage;
import com.nhsbsa.webdriver.DriverManager;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.support.PageFactory;

import static com.nhsbsa.finance.pageobjects.FinancePages.employerAccountInfoPage;
import static com.nhsbsa.finance.pageobjects.FinancePages.financeLoginPage;
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

    @When("^user enters '(.*)', '(.*)' and '(.*)' into Date of Transfer field$")
    public void user_enters_values_into_date_of_transfer_field(String day, String month, String year) {
        schedulePaymentPage.enterDateOfTransferDay(day);
        schedulePaymentPage.enterDateOfTransferMonth(month);
        schedulePaymentPage.enterDateOfTransferYear(year);
        schedulePaymentPage = financeLoginPage.submit();
    }

    @When("^user clicks submit button$")
    public void user_clicks_submit_button() {
//        schedulePaymentPage = schedulePaymentPage.submit();
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