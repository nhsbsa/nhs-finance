package com.nhsbsa.pageobjects;

import com.nhsbsa.BasePage;
import com.nhsbsa.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ianfulcher on 01/11/2016.
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

    @FindBy(className = "log-out-link")
    private WebElement logoutElement;

    @FindBy(css = ".notification.error p")
    private WebElement errorMessage;

    public void enterUserName(String value) {
        enterValue(usernameElement, value);
    }

    public void enterPassword(String value) {
        enterValue(passwordElement, value);
    }

    public void submitWithErrors() {
        loginElement.click();
    }

    // Clicked on "Logout" in the Finance Login Page which takes us to the Finance Login Page
    public FinanceLoginPage logoutButton() {
        logoutElement.click();
        return PageFactory.initElements(DriverManager.getDriver(), FinanceLoginPage.class);
    }

}

