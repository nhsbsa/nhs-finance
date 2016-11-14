package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Mark Lishman on 11/11/2016.
 */
public class SchedulePaymentPage extends BasePage {

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

    public SchedulePaymentPage(WebDriver driver) {
        super(driver, "Schedule your payment");
    }

    public void enterDateOfTransferDay(final String dateOfTransferDay) {
        enterValue(dateOfTransferDayElement, dateOfTransferDay);
    }

    public void enterDateOfTransferMonth(final String dateOfTransferMonth) {
        enterValue(dateOfTransferMonthElement, dateOfTransferMonth);
    }

    public void enterDateOfTransferYear(final String dateOfTransferYear) {
        enterValue(dateOfTransferYearElement, dateOfTransferYear);
    }

    public String getDateOfTransferObjectErrorMessage() {
        return dateOfTransferObjectErrorElement.getText();
    }

    public String getDateOfTransferDateErrorMessage() {
        return dateOfTransferDateErrorElement.getText();
    }


}