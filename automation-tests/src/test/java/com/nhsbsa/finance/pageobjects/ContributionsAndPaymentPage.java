package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Mark Lishman on 14/11/2016.
 */
public class ContributionsAndPaymentPage extends FormPage {

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

    public ContributionsAndPaymentPage(WebDriver driver) {
        super(driver, "Contributions and payment");
    }

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

}