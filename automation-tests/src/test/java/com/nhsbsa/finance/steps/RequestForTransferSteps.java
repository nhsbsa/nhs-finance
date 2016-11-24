package com.nhsbsa.finance.steps;

import com.nhsbsa.finance.pageobjects.FinancePages;
import com.nhsbsa.finance.pageobjects.SchedulePaymentPage;
import com.nhsbsa.finance.pageobjects.ContributionsAndPaymentPage;
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

public class RequestForTransferSteps {

    @Given("^schedule your payment page is displayed$")
    public void schedule_your_payment_page_is_displayed() {
        schedulePaymentPage = PageFactory.initElements(DriverManager.getDriver(), SchedulePaymentPage.class);
    }

    @When("^user enters '(.*)', '(.*)' and '(.*)' into Date of Transfer field$")
    public void user_enters_values_into_date_of_transfer_field(String day, String month, String year) {
        schedulePaymentPage.enterDateOfTransferDay(day);
        schedulePaymentPage.enterDateOfTransferMonth(month);
        schedulePaymentPage.enterDateOfTransferYear(year);
//        schedulePaymentPage = financeLoginPage.submit();
    }

    @When("^user enters tomorrows date into Date of Transfer field$")
    public void user_enters_values_into_date_of_transfer_field() {
        LocalDate date = new LocalDate().plusDays(1);
        schedulePaymentPage.enterDateOfTransferDay(date.getDayOfMonth());
        schedulePaymentPage.enterDateOfTransferMonth(date.getMonthOfYear());
        schedulePaymentPage.enterDateOfTransferYear(date.getYear());
//        schedulePaymentPage = financeLoginPage.submit();
    }

    @When("^user clicks on staff$")
    public void user_clicks_on_staff() {
        schedulePaymentPage.clickStaff();
    }

    @When("^user enters '(.*)' and '(.*)' into Contribution Date field$")
    public void user_enters_values_into_contribution_date_field(String month, String year) {
        schedulePaymentPage.enterContributionDateMonth(month);
        schedulePaymentPage.enterContributionDateYear(year);
    }

    @When("^user clicks schedule submit button with errors$")
    public void user_clicks_submit_button_with_errors() {
        schedulePaymentPage.submitWIthErrors();
    }

    @When("^user clicks schedule submit button$")
    public void user_clicks_submit_button() {
        schedulePaymentPage.submit();
    }

    // ------------------------------------------------------------------------------

    // Total Pensionable Pay

    @When("^'(.*)' is entered into into Total Pensionable Pay$")
    public void value_is_entered_into_total_pensionable_pay(String totalPensionablePay) {
        contributionsAndPaymentPage.enterTotalPensionablePayValue(totalPensionablePay);
    }

    @When("^Total Pensionable Pay shows '(.*)' validation error$")
    public void total_pensionable_pay_shows_validation_error(String totalPensionablePay) {
        contributionsAndPaymentPage.enterTotalPensionablePayValue(totalPensionablePay);
    }

    // ------------------------------------------------------------------------------

    @Then("^schedule payment page should be displayed$")
    public void schedule_payment_page_should_be_displayed() {
        schedulePaymentPage = PageFactory.initElements(DriverManager.getDriver(), SchedulePaymentPage.class);
    }

    @Then("^validation summary should be displayed$")
    public void validation_summary_should_be_displayed() {
        assertThat(schedulePaymentPage.getValidationSummary(), is(equalTo("Some questions have not been answered correctly.\nPlease see the errors below.")));
    }

    @Then("^'(.*)' error is displayed for Date of Transfer$")
    public void error_is_displayed_for_date_of_transfer(final String errorMessage) {
        assertThat(schedulePaymentPage.getDateOfTransferObjectErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @Then("^'(.*)' error is displayed for Date of Transfer date value$")
    public void error_is_displayed_for_date_of_transfer_date_value(final String errorMessage) {
        assertThat(schedulePaymentPage.getDateOfTransferDateErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @Then("^Error is displayed when Payment Contribution is not set")
    public void error_is_displayed_if_payment_contribution_is_not_set() {
        assertThat(schedulePaymentPage.getContributionPaymentErrorMessage(), is(equalTo("Contribution payment is required")));
        validation_summary_should_be_displayed();
    }

    @Then("^'(.*)' error is displayed for Contribution Date$")
    public void error_is_displayed_for_contribution_date(final String errorMessage) {
        assertThat(schedulePaymentPage.getContributionDateObjectErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @Then("^'(.*)' error is displayed for Contribution Date month$")
    public void error_is_displayed_for_contribution_date_month(final String errorMessage) {
        assertThat(schedulePaymentPage.getContributionDateMonthErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @Then("^'(.*)' error is displayed for Contribution Date year$")
    public void error_is_displayed_for_contribution_date_year(final String errorMessage) {
        assertThat(schedulePaymentPage.getContributionDateYearErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    /**
     * Contributions and Payment Tests
     */

    @Given("^contributions and payment page is displayed$")
    public void contributions_and_payment_is_displayed() {
        FinancePages.contributionsAndPaymentPage = PageFactory.initElements(DriverManager.getDriver(), ContributionsAndPaymentPage.class);
    }

}