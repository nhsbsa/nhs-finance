package com.nhsbsa.finance.steps;

import com.nhsbsa.finance.pageobjects.EmployerAccountInfoPage;
import com.nhsbsa.finance.pageobjects.SchedulePaymentPage;
import com.nhsbsa.webdriver.DriverManager;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.joda.time.LocalDate;
import org.openqa.selenium.support.PageFactory;

import static com.nhsbsa.finance.pageobjects.FinancePages.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * This page hasnt been developed yet
 */
public class AccountSteps {

    @Given("^employer account info page is displayed$")
    public void employer_account_info_page_is_displayed() {
        employerAccountInfoPage = PageFactory.initElements(DriverManager.getDriver(), EmployerAccountInfoPage.class);
    }

    @Then("^employer account info page should be displayed$")
    public void employer_account_info_page_should_be_displayed() {
        employer_account_info_page_is_displayed();
    }
}