package com.nhsbsa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Mark Lishman on 24/11/2016.
 */
public class FormPage extends BasePage {

    // TODO login does not have type 'submit'
//    @FindBy(css = "input[type=submit]")
    @FindBy(className = "button")
    private WebElement submitButtonElement;

    public FormPage(WebDriver driver, String title) {
        super(driver, title);
    }

    protected void enterValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void submit() {
        submitButtonElement.submit();
    }
}