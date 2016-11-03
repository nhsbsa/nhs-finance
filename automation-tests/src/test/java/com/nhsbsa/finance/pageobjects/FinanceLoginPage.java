package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.BasePage;
import com.nhsbsa.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by MattHood on 01/11/2016.
 */
public class FinanceLoginPage extends BasePage {

    public FinanceLoginPage(WebDriver driver) {
        super(driver, "Finance login");
    }

    @FindBy(id = "username")
    private WebElement usernameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(className = "button")
    private WebElement loginElement;

    @FindBy(css = ".notification.error p")
    private WebElement errorMessage;

    public void enterUserName(String value) {
        enterValue(usernameElement, value);
    }

    public void enterPassword(String value) {
        enterValue(passwordElement, value);
    }

    public FinanceLoginPage submit() {
        loginElement.click();
        return PageFactory.initElements(DriverManager.getDriver(), FinanceLoginPage.class);
    }

    public void submitWithErrors() {
        loginElement.click();
    }

    public String getErrorMessage() { return errorMessage.getText(); }

}


