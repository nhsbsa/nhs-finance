package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Mark Lishman on 11/11/2016.
 */
public class SchedulePaymentPage extends FormPage {

    @FindBy(className = "validation-summary")
    private WebElement validationSummaryElement;

    @FindBy(id = "dob-day")
    private WebElement dateOfTransferDayElement;

    @FindBy(id = "dob-month")
    private WebElement dateOfTransferMonthElement;

    @FindBy(id = "dob-year")
    private WebElement dateOfTransferYearElement;

    @FindBy(id = "transferDate.error")
    private WebElement dateOfTransferObjectErrorElement;

    @FindBy(id = "transferDate.date.error")
    private WebElement dateOfTransferDateErrorElement;

    @FindBy(id = "staff")
    private WebElement staffElement;

    @FindBy(id = "gp")
    private WebElement gpElement;

    @FindBy(id = "isGp.error")
    private WebElement contributionPaymentErrorElement;

    @FindBy(id = "contribution-month")
    private WebElement contributionDateMonthElement;

    @FindBy(id = "contribution-year")
    private WebElement contributionDateYearElement;

    @FindBy(id = "contributionDate.error")
    private WebElement contributionDateObjectErrorElement;

    public SchedulePaymentPage(WebDriver driver) {
        super(driver, "Schedule your payment");
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

}