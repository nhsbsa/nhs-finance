package com.nhsbsa;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

/**
 * Created by Mark Lishman on 05/09/2016.
 */
public class BasePage {
    protected WebDriver driver;

    /*
     * driver - WebDriver for calls to the browser for information
     * title  - User entered text for comparison with actual browser text (in titles)
     */
    public BasePage(WebDriver driver, String title) {
        this.driver = driver;
        if (!StringUtils.equals(driver.getTitle(), title)) {
            throw new IllegalStateException(format("Page title is %s, title looking for is %s", driver.getTitle(), title));
        }
    }

    protected void enterValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}