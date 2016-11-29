package com.nhsbsa.finance.steps;

import com.nhsbsa.finance.pageobjects.*;
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
 * Created by MattHood on 02/11/2016.
 * This is the page after the Finance Login, title "Security" and has the A/C Name/Number and EA Reference
 */
public class FinanceSteps {

    @Given("^employer account info page is displayed$")
    public void employer_account_info_page_is_displayed() {
        employerAccountInfoPage = PageFactory.initElements(DriverManager.getDriver(), EmployerAccountInfoPage.class);
    }

    @Given("^contributions and payment page is displayed$")
    public void contributions_and_payment_page_is_displayed() {
        contributionsAndPaymentPage = PageFactory.initElements(DriverManager.getDriver(), ContributionsAndPaymentPage.class);
    }

    @When("^user enters '(.*)', '(.*)' and '(.*)' into Date of Transfer field$")
    public void user_enters_values_into_date_of_transfer_field(String day, String month, String year) {
        schedulePaymentPage.enterDateOfTransferDay(day);
        schedulePaymentPage.enterDateOfTransferMonth(month);
        schedulePaymentPage.enterDateOfTransferYear(year);
        schedulePaymentPage = financeLoginPage.submit();
    }

    @When("^user enters tomorrows date into Date of Transfer field$")
    public void user_enters_values_into_date_of_transfer_field() {
        LocalDate date = new LocalDate().plusDays(1);
        schedulePaymentPage.enterDateOfTransferDay(date.getDayOfMonth());
        schedulePaymentPage.enterDateOfTransferMonth(date.getMonthOfYear());
        schedulePaymentPage.enterDateOfTransferYear(date.getYear());
        schedulePaymentPage = financeLoginPage.submit();
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

    @When("^user clicks submit button with errors$")
    public void user_clicks_submit_button_with_errors() {
        schedulePaymentPage.submitWIthErrors();
    }

    @When("^user clicks submit button$")
    public void user_clicks_submit_button() {
        schedulePaymentPage.submit();
    }

    @Then("^schedule payment page should be displayed$")
    public void schedule_payment_page_should_be_displayed() {
        schedulePaymentPage = PageFactory.initElements(DriverManager.getDriver(), SchedulePaymentPage.class);
    }

    @Then("^validation summary should be displayed$")
    public void validation_summary_should_be_displayed() {
        assertThat(schedulePaymentPage.getValidationSummary(), is(equalTo("Some questions have not been answered correctly.\nPlease see the errors below.")));
    }

    @Then("^employer account info page should be displayed$")
    public void employer_account_info_page_should_be_displayed() {
        employer_account_info_page_is_displayed();
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

    @When("^'(.*)' employer's contributions are entered and valid$")
    public void employers_contributions_are_entered_and_valid() {

    }

    @When("^user enters '(.*)' into total pensionable pay field$")
    public void user_enters_values_into_total_pensionable_pay_field(String totalPensionablePay) {
        contributionsAndPaymentPage.enterTotalPensionablePay(totalPensionablePay);
    }

    @When("^user enters '(.*)' into employee contributions field$")
    public void user_enters_values_into_employee_contributions_field(String employeeContributions) {
        contributionsAndPaymentPage.enterEmployeeContributions(employeeContributions);
    }

    @When("^user enters '(.*)' into employer contributions field$")
    public void user_enters_values_into_employer_contributions_field(String employersContributions) {
        contributionsAndPaymentPage.enterEmployerContributions(employersContributions);
    }

    @When("^yes is selected on adjustments required")
    public void yes_is_selected_on_adjustments_required() {
        contributionsAndPaymentPage.clickAdjustmentsRequired();
    }

    @When("^user enters '(.*)' into employer contributions adjustment field$")
    public void user_enters_values_into_employer_contributions_adjustment_field(String employersContributionsAdjustment) {
        contributionsAndPaymentPage.enterEmployerContributionsAdjustment(employersContributionsAdjustment);
    }

    @When("^user enters '(.*)' into errbo adjustment field$")
    public void user_enters_values_into_errbo_adjustment_field(String errboAdjustment) {
        contributionsAndPaymentPage.enterErrboAdjustment(errboAdjustment);
    }

    @When("^user enters '(.*)' into additional pension adjustment field$")
    public void user_enters_values_into_additional_pension_adjustment_field(String additionalPensionAdjustment) {
        contributionsAndPaymentPage.enterAdditionalPensionAdjustment(additionalPensionAdjustment);
    }

    @When("^user enters '(.*)' into employee added years adjustment field$")
    public void user_enters_values_into_employee_added_years_adjustment_field(String employeeAddedYearsAdjustment) {
        contributionsAndPaymentPage.enterEmployeeAddedYearsAdjustment(employeeAddedYearsAdjustment);
    }

    @When("^user enters '(.*)' into employee contributions adjustment field$")
    public void user_enters_values_into_employee_contributions_adjustment_field(String employeeContributionsAdjustment) {
        contributionsAndPaymentPage.enterEmployeeContributionsAdjustment(employeeContributionsAdjustment);
    }

    @Then("^user clicks next button$")
    public void user_clicks_next_button() {
        contributionsAndPaymentPage.submit();
    }

    @Then("^user clicks next button with errors")
    public void user_clicks_next_button_with_errors() { contributionsAndPaymentPage.submitWIthErrors(); }

    @Then("^'(.*)' error is displayed for employer contribution adjustment$")
    public void error_is_displayed_for_employer_contribution_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage.getEmployerContributionsAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^'(.*)' error is displayed for errbo adjustment$")
    public void error_is_displayed_for_errbo_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage.getErrboAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^'(.*)' error is displayed for additional pension adjustment$")
    public void error_is_displayed_for_additional_pension_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage.getAdditionalPensionAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^'(.*)' error is displayed for employee added years adjustment$")
    public void error_is_displayed_for_employee_added_years_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage.getEmployeeAddedYearsAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^'(.*)' error is displayed for employee contributions adjustment$")
    public void error_is_displayed_for_employee_contributions_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage.getEmployeeContributionsAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^feature is not yet available page should be displayed$")
    public void feature_is_not_yet_available_page_should_be_displayed() {
        featureIsNotYetAvailablePage = PageFactory.initElements(DriverManager.getDriver(), FeatureIsNotYetAvailablePage.class);
    }

}