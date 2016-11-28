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

    @FindBy(className = "button")
    private WebElement nextButtonElement;

    @FindBy(id = "employer-contributions-adjustment-error")
    private WebElement employerContributionsAdjustmentErrorElement;

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

    public void clickAdjustmentsRequired() {
        adjustmentsRequiredElement.click();
    }

    public void enterEmployerContributionsAdjustment(final String employerContributionsAdjustment) {
        enterValue(employerContributionsAdjustmentElement, employerContributionsAdjustment);
    }

    public void enterEmployerContributionsAdjustment(final double employerContributionsAdjustment) {
        enterEmployerContributionsAdjustment(String.valueOf(employerContributionsAdjustment));
    }

    public String getEmployerContributionsAdjustmentErrorMessage() {
        return employerContributionsAdjustmentErrorElement.getText();
    }

    public void submitWIthErrors() {
        nextButtonElement.click();
    }
}