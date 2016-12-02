package com.nhsbsa.finance.steps;

import com.nhsbsa.finance.pageobjects.ContributionsAndPaymentPage;
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

    @When("^user enters '(.*)' into total pensionable pay field$")
    public void user_enters_values_into_total_pensionable_pay_field(String totalPensionablePay) {
        contributionsAndPaymentPage().enterTotalPensionablePay(totalPensionablePay);
    }

    @When("^user enters '(.*)' into employee contributions field$")
    public void user_enters_values_into_employee_contributions_field(String employeeContributions) {
        contributionsAndPaymentPage().enterEmployeeContributions(employeeContributions);
    }

    @When("^user enters '(.*)' into employer contributions field$")
    public void user_enters_values_into_employer_contributions_field(String employersContributions) {
        contributionsAndPaymentPage().enterEmployerContributions(employersContributions);
    }

    @When("^yes is selected on adjustments required")
    public void yes_is_selected_on_adjustments_required() {
        contributionsAndPaymentPage().clickAdjustmentsRequired();
    }

    @When("^user enters '(.*)' into adjustment period month field$")
    public void user_enters_values_into_adjustment_period_month_field(String adjustmentPeriodMonth) {
        contributionsAndPaymentPage().enterAdjustmentsPeriodMonth(adjustmentPeriodMonth);
    }

    @When("^user enters '(.*)' into adjustment period year field$")
    public void user_enters_values_into_adjustment_period_year_field(String adjustmentPeriodYear) {
        contributionsAndPaymentPage().enterAdjustmentsPeriodYear(adjustmentPeriodYear);
    }

    @When("^user enters '(.*)' into employee contributions adjustment field$")
    public void user_enters_values_into_employee_contributions_adjustment_field(String employeeContributionsAdjustment) {
        contributionsAndPaymentPage().enterEmployeeContributionsAdjustment(employeeContributionsAdjustment);
    }

    @When("^user enters '(.*)' into employer contributions adjustment field$")
    public void user_enters_values_into_employer_contributions_adjustment_field(String employersContributionsAdjustment) {
        contributionsAndPaymentPage().enterEmployerContributionsAdjustment(employersContributionsAdjustment);
    }

    @When("^user enters '(.*)' into employee added years adjustment field$")
    public void user_enters_values_into_employee_added_years_adjustment_field(String employeeAddedYearsAdjustment) {
        contributionsAndPaymentPage().enterEmployeeAddedYearsAdjustment(employeeAddedYearsAdjustment);
    }

    @When("^user enters '(.*)' into additional pension adjustment field$")
    public void user_enters_values_into_additional_pension_adjustment_field(String additionalPensionAdjustment) {
        contributionsAndPaymentPage().enterAdditionalPensionAdjustment(additionalPensionAdjustment);
    }

    @When("^user enters '(.*)' into errbo adjustment field$")
    public void user_enters_values_into_errbo_adjustment_field(String errboAdjustment) {
        contributionsAndPaymentPage().enterErrboAdjustment(errboAdjustment);
    }

    @Then("^'(.*)' error is displayed for adjustment period$")
    public void error_is_displayed_for_adjustment_period(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getAdjustmentPeriodErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^'(.*)' error is displayed for employee contributions adjustment$")
    public void error_is_displayed_for_employee_contributions_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployeeContributionsAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^'(.*)' error is displayed for employer contribution adjustment$")
    public void error_is_displayed_for_employer_contribution_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployerContributionsAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^'(.*)' error is displayed for employee added years adjustment$")
    public void error_is_displayed_for_employee_added_years_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployeeAddedYearsAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^'(.*)' error is displayed for additional pension adjustment$")
    public void error_is_displayed_for_additional_pension_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getAdditionalPensionAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }

    @Then("^'(.*)' error is displayed for errbo adjustment$")
    public void error_is_displayed_for_errbo_adjustment(final String errorMessage) {
        assertThat(contributionsAndPaymentPage().getErrboAdjustmentErrorMessage(), is(equalTo((errorMessage))));
    }
}