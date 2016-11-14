package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.BasePage;
import com.nhsbsa.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ianfulcher on 01/11/2016.
 */
public class FinanceStartPage extends BasePage {

    public FinanceStartPage(WebDriver driver) {
        super(driver, "NHS Financial Information Collection");
    }

    @FindBy(className = "button")
    private WebElement loginElement;

    // Clicked on "Start now" in the Finance Start Page which takes us to the Finance Login Page
    public FinanceLoginPage startNowButton() {
        loginElement.click();
        return PageFactory.initElements(DriverManager.getDriver(), FinanceLoginPage.class);
    }


}
