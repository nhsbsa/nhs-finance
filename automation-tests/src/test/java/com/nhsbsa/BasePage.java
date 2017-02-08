package com.nhsbsa;

import com.nhsbsa.finance.pageobjects.FinancePages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;

/**
 * Created by Mark Lishman on 05/09/2016.
 */
public class BasePage {
    protected WebDriver driver;

    // "English" link from common footer
    @FindBy(linkText = "English")
    private WebElement viewInEnglishElement;

    // "Cymraeg" link from common footer
    @FindBy(linkText = "Cymraeg")
    private WebElement viewInWelshElement;

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

    /**
     * Switch to displaying the site in the English locale
     */
    public void viewInEnglish() {
        viewInEnglishElement.click();
        FinancePages.setViewEnglishPage();
    }

    /**
     * Switch to displaying the site in the Welsh locale
     */
    public void viewInWelsh() {
        viewInWelshElement.click();
        FinancePages.setViewWelshPage();
    }
}