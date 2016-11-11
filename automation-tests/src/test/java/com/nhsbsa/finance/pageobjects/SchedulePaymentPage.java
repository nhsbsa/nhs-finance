package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mark Lishman on 11/11/2016.
 */
public class SchedulePaymentPage extends BasePage {

    public SchedulePaymentPage(WebDriver driver) {
        super(driver, "Schedule your payment");
    }
}