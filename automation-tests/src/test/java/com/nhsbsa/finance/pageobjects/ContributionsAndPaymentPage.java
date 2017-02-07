package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Mark Lishman on 14/11/2016.
 */
public class ContributionsAndPaymentPage extends FormPage {

    public ContributionsAndPaymentPage(WebDriver driver) {
        super(driver, "Contributions and payment");
    }

    @FindBy(id = "total-pensionable-pay")
    private WebElement totalPensionablePayElement;

    @FindBy(id = "totalPensionablePay.error")
    private WebElement totalPensionablePayErrorElement;

    @FindBy(id = "employee-contributions")
    private WebElement employeeContributionsElement;

    @FindBy(id = "employeeContributions.error")
    private WebElement employeeContributionsErrorElement;

    @FindBy(id = "employer-contributions")
    private WebElement employerContributionsElement;

    @FindBy(id = "employerContributions.error")
    private WebElement employerContributionsErrorElement;

    @FindBy(id = "employee-avcs")
    private WebElement employeeAddedYearsElement;

    @FindBy(id = "employeeAvcs.error")
    private WebElement employeeAddedYearsErrorElement;

    @FindBy(id = "additional-pension")
    private WebElement additionalPensionElement;

    @FindBy(id = "additionalPension.error")
    private WebElement additionalPensionErrorElement;

    @FindBy(id = "errbo")
    private WebElement errboElement;

    @FindBy(id = "errbo.error")
    private WebElement errboErrorElement;

    @FindBy(id = "total-amount-debited")
    private WebElement totalAmountDebitedElement;

    @FindBy(id = "totalDebitAmount.error")
    private WebElement totalAmountDebitedErrorElement;

    @FindBy(id = "add-outstanding-payments")
    private WebElement adjustmentsRequiredElement;

    @FindBy(id = "no-outstanding-payments")
    private WebElement adjustmentsNotRequiredElement;

    @FindBy(id = "adj-contribution-month")
    private WebElement adjustmentsPeriodMonthElement;

    @FindBy(id = "adj-contribution-year")
    private WebElement adjustmentsPeriodYearElement;

    @FindBy(id = "employee-contributions-adjustment")
    private WebElement employeeContributionsAdjustmentElement;

    @FindBy(id = "employer-contributions-adjustment")
    private WebElement employerContributionsAdjustmentElement;

    @FindBy(id = "employee-added-years-adjustment")
    private WebElement employeeAddedYearsAdjustmentElement;

    @FindBy(id = "additional-pension-adjustment")
    private WebElement additionalPensionAdjustmentElement;

    @FindBy(id = "errbo-adjustment")
    private WebElement errboAdjustmentElement;

    @FindBy(id = "adjustment-error")
    private WebElement adjustmentErrorElement;

    @FindBy(id = "employee-contributions-adjustment-error")
    private WebElement employeeContributionsAdjustmentErrorElement;

    @FindBy(id = "employer-contributions-adjustment-error")
    private WebElement employerContributionsAdjustmentErrorElement;

    @FindBy(id = "employee-added-years-adjustment-error")
    private WebElement employeeAddedYearsAdjustmentErrorElement;

    @FindBy(id = "additional-pension-adjustment-error")
    private WebElement additionalPensionAdjustmentErrorElement;

    @FindBy(id = "errbo-adjustment-error")
    private WebElement errboAdjustmentErrorElement;

    @FindBy(id = "adjustment-period-error")
    private WebElement adjustmentPeriodErrorElement;


    // Total Pensionable Pay

    public void enterTotalPensionablePayValue(final String totalPensionablePay) {
        enterValue(totalPensionablePayElement, totalPensionablePay);
    }

    public String getTotalPensionablePayErrorMessage() {
        return totalPensionablePayErrorElement.getText();
    }

    // Employee Contributions

    public void enterEmployeeContributionsValue(final String employeeContributions) {
        enterValue(employeeContributionsElement, employeeContributions);
    }

    public String getEmployeeContributionsErrorMessage() {
        return employeeContributionsErrorElement.getText();
    }

    // Employer Contributions

    public void enterEmployerContributionsValue(final String employerContributions) {
        enterValue(employerContributionsElement, employerContributions);
    }

    public String getEmployerContributionsErrorMessage() {
        return employerContributionsErrorElement.getText();
    }

    // Employee Added Years

    public void enterEmployeeAddedYearsValue(final String employeeAddedYears) {
        enterValue(employeeAddedYearsElement, employeeAddedYears);
    }

    public String getEmployeeAddedYearsErrorMessage() {
        return employeeAddedYearsErrorElement.getText();
    }

    // Additional Pension

    public void enterAdditionalPensionValue(final String additionalPension) {
        enterValue(additionalPensionElement, additionalPension);
    }

    public String getAdditionalPensionErrorMessage() {
        return additionalPensionErrorElement.getText();
    }

    // ERRBO

    public void enterErrboValue(final String errbo) {
        enterValue(errboElement, errbo);
    }

    public String getErrboErrorMessage() {
        return errboErrorElement.getText();
    }

    public void enterTotalPensionablePay(final String totalPensionablePay) {
        enterValue(totalPensionablePayElement, totalPensionablePay);
    }

    public void enterTotalPensionablePay(final double totalPensionablePay) {
        enterTotalPensionablePay(String.valueOf(totalPensionablePay));
    }

    public void enterEmployeeContributions(final String employeeContributions) {
        enterValue(employeeContributionsElement, employeeContributions);
    }

    public void enterEmployeeContributions(final double employeeContributions) {
        enterEmployeeContributions(String.valueOf(employeeContributions));
    }

    public void enterEmployerContributions(final String employerContributions) {
        enterValue(employerContributionsElement, employerContributions);
    }

    public void enterEmployerContributions(final double employerContributions) {
        enterEmployerContributions(String.valueOf(employerContributions));
    }

    public void enterAdjustmentsPeriodMonth(final String adjustmentsPeriodMonth) {
        enterValue(adjustmentsPeriodMonthElement, adjustmentsPeriodMonth);
    }

    public void enterAdjustmentsPeriodYear(final String adjustmentsPeriodYear) {
        enterValue(adjustmentsPeriodYearElement, adjustmentsPeriodYear);
    }

    public void enterEmployerContributionsAdjustment(final String employerContributionsAdjustment) {
        enterValue(employerContributionsAdjustmentElement, employerContributionsAdjustment);
    }

    public void enterErrboAdjustment(final String errboAdjustment) {
        enterValue(errboAdjustmentElement, errboAdjustment);
    }

    public void enterAdditionalPensionAdjustment(final String additionalPensionAdjustment) {
        enterValue(additionalPensionAdjustmentElement, additionalPensionAdjustment);
    }

    public void enterEmployeeAddedYearsAdjustment(final String employeeAddedYearsAdjustment) {
        enterValue(employeeAddedYearsAdjustmentElement, employeeAddedYearsAdjustment);
    }

    public void enterEmployeeContributionsAdjustment(final String employeeContributionsAdjustment) {
        enterValue(employeeContributionsAdjustmentElement, employeeContributionsAdjustment);
    }

    public String getAdjustmentPeriodErrorMessage() {
        return adjustmentPeriodErrorElement.getText();
    }

    public String getEmployerContributionsAdjustmentErrorMessage() {
        return employerContributionsAdjustmentErrorElement.getText();
    }

    public String getErrboAdjustmentErrorMessage() {
        return errboAdjustmentErrorElement.getText();
    }

    public String getAdditionalPensionAdjustmentErrorMessage() {
        return additionalPensionAdjustmentErrorElement.getText();
    }

    public String getEmployeeAddedYearsAdjustmentErrorMessage() {
        return employeeAddedYearsAdjustmentErrorElement.getText();
    }

    public String getEmployeeContributionsAdjustmentErrorMessage() {
        return employeeContributionsAdjustmentErrorElement.getText();
    }

    public String getAdjustmentErrorMessage() {
        return adjustmentErrorElement.getText();
    }

    public void clickAdjustmentsRequired() {
        adjustmentsRequiredElement.click();
    }

    public void clickAdjustmentsNotRequired() {
        adjustmentsNotRequiredElement.click();
    }

}