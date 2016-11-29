package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.BasePage;
import com.nhsbsa.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Mark Lishman on 14/11/2016.
 */
public class ContributionsAndPaymentPage extends BasePage {

    public ContributionsAndPaymentPage(WebDriver driver) {
        super(driver, "Contributions and payment");
    }

    @FindBy(id = "total-pensionable-pay")
    private WebElement totalPensionablePayElement;

    @FindBy(id = "employee-contributions")
    private WebElement employeeContributionsElement;

    @FindBy(id = "employer-contributions")
    private WebElement employerContributionsElement;

    @FindBy(id = "employee-avcs")
    private WebElement employeeAvcsElement;

    @FindBy(id = "additional-pension")
    private WebElement additionalPensionElement;

    @FindBy(id = "errbo")
    private WebElement errboElement;

    @FindBy(id = "add-outstanding-payments")
    private WebElement adjustmentsRequiredElement;

    @FindBy(id = "employer-contributions-adjustment")
    private WebElement employerContributionsAdjustmentElement;

    @FindBy(id = "errbo-adjustment")
    private WebElement errboAdjustmentElement;

    @FindBy(id = "additional-pension-adjustment")
    private WebElement additionalPensionAdjustmentElement;

    @FindBy(id = "employee-added-years-adjustment")
    private WebElement employeeAddedYearsAdjustmentElement;

    @FindBy(id = "employee-contributions-adjustment")
    private WebElement employeeContributionsAdjustmentElement;

    @FindBy(className = "button")
    private WebElement nextButtonElement;

    @FindBy(id = "employer-contributions-adjustment-error")
    private WebElement employerContributionsAdjustmentErrorElement;

    @FindBy(id = "errbo-adjustment-error")
    private WebElement errboAdjustmentErrorElement;

    @FindBy(id = "additional-pension-adjustment-error")
    private WebElement additionalPensionAdjustmentErrorElement;

    @FindBy(id = "employee-added-years-adjustment-error")
    private WebElement employeeAddedYearsAdjustmentErrorElement;

    @FindBy(id = "employee-contributions-adjustment-error")
    private WebElement employeeContributionsAdjustmentErrorElement;


    public FeatureIsNotYetAvailablePage submit() {
        nextButtonElement.click();
        return PageFactory.initElements(DriverManager.getDriver(), FeatureIsNotYetAvailablePage.class);
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

    public void clickAdjustmentsRequired() {
        adjustmentsRequiredElement.click();
    }

    public void submitWIthErrors() {
        nextButtonElement.click();
    }
}