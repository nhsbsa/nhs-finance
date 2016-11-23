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

    // Add tpp Error Element here once validations have been merged in

    @FindBy(id = "employee-contributions")
    private WebElement employeeContributionsElement;

    // Add employee conts Error Element here once validations have been merged in

    @FindBy(id = "employer-contributions")
    private WebElement employerContributionsElement;

    // Add employer conts Error Element here once validations have been merged in

    @FindBy(id = "additional-pension")
    private WebElement additionalPensionElement;

    @FindBy(id = "errbo")
    private WebElement errboElement;

    @FindBy(id = "total-amount-debited")
    private WebElement totalAmountDebitedElement;

    @FindBy(className = "button")
    private WebElement submitButtonElement;

    public ContributionsAndPaymentPage(WebDriver driver) {
        super(driver, "Contributions and payment");
    }

    // Validation Summary

    public String getValidationSummary() {
        return validationSummaryElement.getText();
    }

    // Date of Transfer

    public void enterDateOfTransferDay(final String dateOfTransferDay) {
        enterValue(dateOfTransferDayElement, dateOfTransferDay);
    }

    public void enterDateOfTransferDay(final int dateOfTransferDay) {
        enterDateOfTransferDay(String.valueOf(dateOfTransferDay));
    }

    public void enterDateOfTransferMonth(final String dateOfTransferMonth) {
        enterValue(dateOfTransferMonthElement, dateOfTransferMonth);
    }

    public void enterDateOfTransferMonth(final int dateOfTransferMonth) {
        enterDateOfTransferMonth(String.valueOf(dateOfTransferMonth));
    }

    public void enterDateOfTransferYear(final String dateOfTransferYear) {
        enterValue(dateOfTransferYearElement, dateOfTransferYear);
    }

    public void enterDateOfTransferYear(final int dateOfTransferYear) {
        enterDateOfTransferYear(String.valueOf(dateOfTransferYear));
    }

    public String getDateOfTransferObjectErrorMessage() {
        return dateOfTransferObjectErrorElement.getText();
    }

    public String getDateOfTransferDateErrorMessage() {
        return dateOfTransferDateErrorElement.getText();
    }

    public String getContributionPaymentErrorMessage() {
        return contributionPaymentErrorElement.getText();
    }

    // Staff or GP

    public void clickStaff() {
        staffElement.click();
    }

    public void clickGp() {
        gpElement.click();
    }

    // Contribution Date

    public void enterContributionDateMonth(final String contributionDateMonth) {
        enterValue(contributionDateMonthElement, contributionDateMonth);
    }

    public void enterContributionDateYear(final String contributionDateYear) {
        enterValue(contributionDateYearElement, contributionDateYear);
    }

    public String getContributionDateObjectErrorMessage() {
        return contributionDateObjectErrorElement.getText();
    }

    public String getContributionDateMonthErrorMessage() {
        return contributionDateMonthErrorElement.getText();
    }

    public String getContributionDateYearErrorMessage() {
        return contributionDateYearErrorElement.getText();
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