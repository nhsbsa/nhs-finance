package com.nhsbsa.finance.steps;

import com.nhsbsa.finance.pageobjects.ContributionsAndPaymentPage;
import com.nhsbsa.finance.pageobjects.FeatureIsNotYetAvailablePage;
import com.nhsbsa.finance.pageobjects.FinancePages;
import com.nhsbsa.finance.pageobjects.SchedulePaymentPage;
import com.nhsbsa.webdriver.DriverManager;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.joda.time.LocalDate;
import org.openqa.selenium.support.PageFactory;

import static com.nhsbsa.finance.pageobjects.FinancePages.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RequestForTransferSteps {

    // General

    @When("^submit button is clicked$")
    public void submit_button_is_clicked() {
        currentFormPage().submit();
    }

    @Then("^validation summary should be displayed$")
    public void validation_summary_should_be_displayed() {
        assertThat(currentFormPage().getValidationSummary(), is(equalTo("Some questions have not been answered correctly.\nPlease see the errors below.")));
    }

    // Schedule Payment

    @Then("^schedule payment page is displayed$")
    public void schedule_payment_page_is_displayed() {
        SchedulePaymentPage schedulePaymentPage = PageFactory.initElements(DriverManager.getDriver(), SchedulePaymentPage.class);
        FinancePages.setCurrentPage(schedulePaymentPage);
    }

    @When("^'(.*)', '(.*)' and '(.*)' is entered into Date of Transfer$")
    public void value_is_entered_into_date_of_transfer(String day, String month, String year) {
        schedulePaymentPage().enterDateOfTransferDay(day);
        schedulePaymentPage().enterDateOfTransferMonth(month);
        schedulePaymentPage().enterDateOfTransferYear(year);
    }

    @When("^tomorrows date is entered into Date of Transfer$")
    public void tomorrows_date_is_entered_into_date_of_transfer() {
        LocalDate date = new LocalDate().plusDays(1);
        schedulePaymentPage().enterDateOfTransferDay(date.getDayOfMonth());
        schedulePaymentPage().enterDateOfTransferMonth(date.getMonthOfYear());
        schedulePaymentPage().enterDateOfTransferYear(date.getYear());
    }

    @Then("^Error message '(.*)' is displayed for Date of Transfer$")
    public void error_message_is_displayed_for_date_of_transfer(final String errorMessage) {
        assertThat(schedulePaymentPage().getDateOfTransferObjectErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @When("^staff radio button is clicked$")
    public void staff_radio_button_is_clicked() {
        schedulePaymentPage().clickStaff();
    }

    @When("^GPs radio button is clicked$")
    public void gp_radio_button_is_clicked() {
        schedulePaymentPage().clickStaff();
    }

    @Then("^Error message '(.*)' is displayed for Contribution Payment$")
    public void error_message_is_displayed_for_contribution_payment(final String errorMessage) {
        assertThat(schedulePaymentPage().getContributionPaymentErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @When("^'(.*)' and '(.*)' is entered into Contribution Date$")
    public void value_is_entered_into_contribution_date(String month, String year) {
        schedulePaymentPage().enterContributionDateMonth(month);
        schedulePaymentPage().enterContributionDateYear(year);
    }

    @Then("^Error message '(.*)' is displayed for Contribution Date$")
    public void error_message_is_displayed_for_contribution_date(final String errorMessage) {
        assertThat(schedulePaymentPage().getContributionDateObjectErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @Then("^Error message '(.*)' is displayed for Date of Transfer date value$")
    public void error_message_is_displayed_for_date_of_transfer_date_value(final String errorMessage) {
        assertThat(schedulePaymentPage().getDateOfTransferDateErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    // Contributions and payment

    @Then("^contributions and payment page is displayed$")
    public void contributions_and_payment_page_is_displayed() {
        ContributionsAndPaymentPage contributionsAndPaymentPage = PageFactory.initElements(DriverManager.getDriver(), ContributionsAndPaymentPage.class);
        FinancePages.setCurrentPage(contributionsAndPaymentPage);
    }

    @When("^'(.*)' is entered into into Total Pensionable Pay$")
    public void value_is_entered_into_total_pensionable_pay(final String totalPensionablePay) {
        contributionsAndPaymentPage().enterTotalPensionablePay(totalPensionablePay);
    }

    @Then("^Error message '(.*)' is displayed for Total Pensionable Pay$")
    public void error_message_is_displayed_for_total_pensionable_pay(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getTotalPensionablePayErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    @When("^'(.*)' is entered into into Employee Contributions$")
    public void value_is_entered_into_employee_contributions(final String employeeContributions) {
        contributionsAndPaymentPage().enterEmployeeContributions(employeeContributions);
    }

    @Then("^Error message '(.*)' is displayed for Employee Contributions$")
    public void error_message_is_displayed_for_employee_contributions(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployeeContributionsErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    @When("^'(.*)' is entered into into Employer Contributions$")
    public void value_is_entered_into_employer_contributions(final String employerContributions) {
        contributionsAndPaymentPage().enterEmployerContributions(employerContributions);
    }

    @Then("^Error message '(.*)' is displayed for Employer Contributions$")
    public void error_message_is_displayed_for_employer_contributions(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployerContributionsErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    @When("^'(.*)' is entered into into Employee Added Years$")
    public void value_is_entered_into_employee_added_years(final String employeeAddedYears) {
        contributionsAndPaymentPage().enterEmployeeContributions(employeeAddedYears);
    }

    @Then("^Error message '(.*)' is displayed for Employee Added Years$")
    public void error_message_is_displayed_for_employee_added_years(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployeeAddedYearsErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    @When("^'(.*)' is entered into into Additional Pension$")
    public void value_is_entered_into_additional_pension(final String additionalPension) {
        contributionsAndPaymentPage().enterAdditionalPensionValue(additionalPension);
    }

    @Then("^Error message '(.*)' is displayed for Additional Pension$")
    public void error_message_is_displayed_for_additional_pension(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getAdditionalPensionErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    @When("^'(.*)' is entered into into ERRBO$")
    public void value_is_entered_into_errbo(final String errbo) {
        contributionsAndPaymentPage().enterErrboValue(errbo);
    }

    @Then("^Error message '(.*)' is displayed for ERRBO$")
    public void error_message_is_displayed_for_errbo(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getErrboErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    @When("^yes radio button is clicked for adjustments required$")
    public void adjustments_required_radio_button_is_clicked() {
        contributionsAndPaymentPage().clickAdjustmentsRequired();
    }

    @When("^no radio button is clicked for adjustments required$")
    public void adjustments_not_required_radio_button_is_clicked() {
        contributionsAndPaymentPage().clickAdjustmentsNotRequired();
    }


    //Adjustments

    @When("^'(.*)' is entered into Adjustment Period month$")
    public void value_is_entered_into_adjustment_period_month(String adjustmentPeriodMonth) {
        contributionsAndPaymentPage().enterAdjustmentsPeriodMonth(adjustmentPeriodMonth);
    }

    @When("^'(.*)' is entered into Adjustment Period year$")
    public void value_is_entered_into_adjustment_period_year(String adjustmentPeriodYear) {
        contributionsAndPaymentPage().enterAdjustmentsPeriodYear(adjustmentPeriodYear);
    }

    @When("^'(.*)' is entered into Employee Contributions adjustment$")
    public void value_is_entered_into_employee_contributions_adjustment(String employeeContributionsAdjustment) {
        contributionsAndPaymentPage().enterEmployeeContributionsAdjustment(employeeContributionsAdjustment);
    }

    @When("^'(.*)' is entered into Employer Contributions adjustment$")
    public void value_is_entered_into_employer_contributions_adjustment(String employersContributionsAdjustment) {
        contributionsAndPaymentPage().enterEmployerContributionsAdjustment(employersContributionsAdjustment);
    }

    @When("^'(.*)' is entered into Employee Added Years adjustment$")
    public void value_is_entered_into_employee_added_years_adjustment(String employeeAddedYearsAdjustment) {
        contributionsAndPaymentPage().enterEmployeeAddedYearsAdjustment(employeeAddedYearsAdjustment);
    }

    @When("^'(.*)' is entered into Additional Pension adjustment$")
    public void value_is_entered_into_additional_pension_adjustment(String additionalPensionAdjustment) {
        contributionsAndPaymentPage().enterAdditionalPensionAdjustment(additionalPensionAdjustment);
    }

    @When("'(.*)' is entered into ERRBO adjustment$")
    public void value_is_entered_into_errbo_adjustment(String errboAdjustment) {
        contributionsAndPaymentPage().enterErrboAdjustment(errboAdjustment);
    }

    @Then("^Error message '(.*)' is displayed for Adjustment Period$")
    public void error_is_displayed_for_adjustment_period(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getAdjustmentPeriodErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^Error message '(.*)' is displayed for Employee Contributions adjustment$")
    public void error_is_displayed_for_employee_contributions_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployeeContributionsAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^Error message '(.*)' is displayed for Employer Contributions adjustment$")
    public void error_is_displayed_for_employer_contributions_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployerContributionsAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^Error message '(.*)' is displayed for Employee Added Years adjustment$")
    public void error_is_displayed_for_employee_added_years_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployeeAddedYearsAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^Error message '(.*)' is displayed for Additional Pension adjustment$")
    public void error_is_displayed_for_additional_pension_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getAdditionalPensionAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^Error message '(.*)' is displayed for ERRBO adjustment$")
    public void error_is_displayed_for_errbo_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getErrboAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    //feature not available

    @Then("^feature is not yet available page is displayed$")
    public void feature_is_not_yet_available_page_is_displayed() {
        FeatureIsNotYetAvailablePage featureIsNotYetAvailablePage = PageFactory.initElements(DriverManager.getDriver(), FeatureIsNotYetAvailablePage.class);
        FinancePages.setCurrentPage(featureIsNotYetAvailablePage);
    }
}