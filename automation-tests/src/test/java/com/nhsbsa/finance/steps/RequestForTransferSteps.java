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

    @When("^'(.*)', '(.*)' and '(.*)' is entered into Date of Transfer field$")
    public void user_enters_values_into_date_of_transfer_field(String day, String month, String year) {
        schedulePaymentPage().enterDateOfTransferDay(day);
        schedulePaymentPage().enterDateOfTransferMonth(month);
        schedulePaymentPage().enterDateOfTransferYear(year);
    }

    @When("^tomorrows date is entered into Date of Transfer field$")
    public void user_enters_values_into_date_of_transfer_field() {
        LocalDate date = new LocalDate().plusDays(1);
        schedulePaymentPage().enterDateOfTransferDay(date.getDayOfMonth());
        schedulePaymentPage().enterDateOfTransferMonth(date.getMonthOfYear());
        schedulePaymentPage().enterDateOfTransferYear(date.getYear());
    }

    @When("^user clicks on staff$")
    public void user_clicks_on_staff() {
        schedulePaymentPage().clickStaff();
    }

    @When("^user enters '(.*)' and '(.*)' into Contribution Date field$")
    public void user_enters_values_into_contribution_date_field(String month, String year) {
        schedulePaymentPage().enterContributionDateMonth(month);
        schedulePaymentPage().enterContributionDateYear(year);
    }

    @Then("^'(.*)' error is displayed for Contribution Payment$")
    public void error_is_displayed_for_contribution_payment(final String errorMessage) {
        assertThat(schedulePaymentPage().getContributionPaymentErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @Then("^'(.*)' error is displayed for Date of Transfer$")
    public void error_is_displayed_for_date_of_transfer(final String errorMessage) {
        assertThat(schedulePaymentPage().getDateOfTransferObjectErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @Then("^'(.*)' error is displayed for Date of Transfer date value$")
    public void error_is_displayed_for_date_of_transfer_date_value(final String errorMessage) {
        assertThat(schedulePaymentPage().getDateOfTransferDateErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    @Then("^'(.*)' error is displayed for Contribution Date$")
    public void error_is_displayed_for_contribution_date(final String errorMessage) {
        assertThat(schedulePaymentPage().getContributionDateObjectErrorMessage(), is(equalTo(errorMessage)));
        validation_summary_should_be_displayed();
    }

    // ------------------------------------------------------------------------------

    // Pages

    @Then("^contributions and payment page is displayed$")
    public void contributions_and_payment_page_is_displayed() {
        ContributionsAndPaymentPage contributionsAndPaymentPage = PageFactory.initElements(DriverManager.getDriver(), ContributionsAndPaymentPage.class);
        FinancePages.setCurrentPage(contributionsAndPaymentPage);
    }

    @Then("^schedule payment page is displayed$")
    public void schedule_payment_page_is_displayed() {
        SchedulePaymentPage schedulePaymentPage = PageFactory.initElements(DriverManager.getDriver(), SchedulePaymentPage.class);
        FinancePages.setCurrentPage(schedulePaymentPage);
    }

    // ------------------------------------------------------------------------------

    // General

    @When("^submit button is clicked$")
    public void submit_button_is_clicked() {
        currentFormPage().submit();
    }

    @Then("^validation summary should be displayed$")
    public void validation_summary_should_be_displayed() {
        assertThat(currentFormPage().getValidationSummary(), is(equalTo("Some questions have not been answered correctly.\nPlease see the errors below.")));
    }

    // ------------------------------------------------------------------------------

    // Contributions and payment page

    // Total Pensionable Pay

    @When("^'(.*)' is entered into into Total Pensionable Pay$")
    public void value_is_entered_into_total_pensionable_pay(final String totalPensionablePay) {
        contributionsAndPaymentPage().enterTotalPensionablePayValue(totalPensionablePay);
    }

    @Then("^Total Pensionable Pay shows '(.*)' validation error$")
    public void total_pensionable_pay_has_validation_error(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getTotalPensionablePayErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    // Employee Contributions

    @When("^'(.*)' is entered into into Employee Contributions$")
    public void value_is_entered_into_employee_contributions(final String employeeContributions) {
        contributionsAndPaymentPage().enterEmployeeContributionsValue(employeeContributions);
    }

    @Then("^Employee Contributions shows '(.*)' validation error$")
    public void employee_contributions_pay_has_validation_error(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployeeContributionsErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    // Employer Contributions

    @When("^'(.*)' is entered into into Employer Contributions$")
    public void value_is_entered_into_employer_contributions(final String employerContributions) {
        contributionsAndPaymentPage().enterEmployerContributionsValue(employerContributions);
    }

    @Then("^Employer Contributions shows '(.*)' validation error$")
    public void employer_contributions_pay_has_validation_error(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployerContributionsErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    // Employee Added Years

    @When("^'(.*)' is entered into into Employee Added Years$")
    public void value_is_entered_into_employee_added_years(final String employeeAddedYears) {
        contributionsAndPaymentPage().enterEmployeeAddedYearsValue(employeeAddedYears);
    }

    @Then("^Employee Added Years shows '(.*)' validation error$")
    public void employee_added_years_has_validation_error(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getEmployeeAddedYearsErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    // Additional Pension

    @When("^'(.*)' is entered into into Additional Pension$")
    public void value_is_entered_into_additional_pension(final String additionalPension) {
        contributionsAndPaymentPage().enterAdditionalPensionValue(additionalPension);
    }

    @Then("^Additional Pension shows '(.*)' validation error$")
    public void additional_pension_has_validation_error(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getAdditionalPensionErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }

    // ERRBO

    @When("^'(.*)' is entered into into ERRBO$")
    public void value_is_entered_into_errbo(final String errbo) {
        contributionsAndPaymentPage().enterErrboValue(errbo);
    }

    @Then("^ERRBO shows '(.*)' validation error$")
    public void errbo_has_validation_error(final String expectedErrorMessage) {
        assertThat(contributionsAndPaymentPage().getErrboErrorMessage(), is(equalTo(expectedErrorMessage)));
        validation_summary_should_be_displayed();
    }
}