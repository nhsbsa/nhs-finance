package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mark Lishman on 14/11/2016.
 */
public class ContributionsAndPaymentPage extends BasePage {

    @FindBy(className = "validation-summary")
    private WebElement validationSummaryElement;

    @FindBy(id = "total-pensionable-pay")
    private WebElement totalPensionablePayElement;

    @FindBy(id = "totalPensionablePay.error")
    private WebElement totalPensionablePayErrorElement;

    @FindBy(id = "employee-contributions")
    private WebElement employeeContributionsElement;

    @FindBy(id = "employeeContributions.error")
    private WebElement employeeContributionsErrorElement;

    @FindBy(id = "employee-avcs")
    private WebElement employeeAvcsElement;

    @FindBy(id = "employeeAvcs.error")
    private WebElement employeeAvcsErrorElement;

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

    @FindBy(className = "button")
    private WebElement submitButtonElement;

    public ContributionsAndPaymentPage(WebDriver driver) {
        super(driver, "Contributions and payment");
    }

    // Validation Summary

    public String getValidationSummary() {
        return validationSummaryElement.getText();
    }

    // Total Pensionable Pay

    public void enterTotalPensionablePay(final BigDecimal totalPensionablePay) {
        enterValue(totalPensionablePayElement, totalPensionablePay);
    }

    public String getTotalPensionablePayObjectErrorMessage() {
        return totalPensionablePayErrorElement.getText();
    }

    // Employee Contributions

    public void enterEmployeeContributions(final BigDecimal totalPensionablePay) {
        enterValue(employeeContributionsElement, totalPensionablePay);
    }

    public String getTotalPensionablePayObjectErrorMessage() {
        return totalPensionablePayErrorElement.getText();
    }
    

    // Submit

    public ContributionsAndPaymentPage submit() {
        submitButtonElement.click();
        return PageFactory.initElements(DriverManager.getDriver(), ContributionsAndPaymentPage.class);
    }

    public void submitWIthErrors() {
        submitButtonElement.click();
    }

}