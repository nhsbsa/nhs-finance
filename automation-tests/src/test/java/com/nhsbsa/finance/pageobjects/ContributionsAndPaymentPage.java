package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Mark Lishman on 14/11/2016.
 */
public class ContributionsAndPaymentPage extends FormPage {

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

    public ContributionsAndPaymentPage(WebDriver driver) {
        super(driver, "Contributions and payment");
    }

    // Validation Summary

    public String getValidationSummary() {
        return validationSummaryElement.getText();
    }

    // Total Pensionable Pay

    public void enterTotalPensionablePayValue(final String totalPensionablePay) {
        enterValue(totalPensionablePayElement, totalPensionablePay);
    }

    public String getTotalPensionablePayErrorMessage() {
        return totalPensionablePayErrorElement.getText();
    }
}