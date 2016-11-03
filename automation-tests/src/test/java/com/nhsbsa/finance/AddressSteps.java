package com.nhsbsa.finance;

import com.nhsbsa.webdriver.DriverManager;
import com.nhsbsa.webdriver.NavigationManager;
import cucumber.annotation.en.Then;
import junit.framework.Assert;

/**
 * Created by MattHood on 01/11/2016.
 */
public class AddressSteps {

    @Then("^finance login page should be displayed$")
    public void change_postal_address_page_should_be_displayed() {
        final String text = DriverManager.getDriver().getCurrentUrl();
        final String expected = NavigationManager.FINANCE_WEBSITE + "/login";
        Assert.assertEquals("Url should match", expected, text);
    }
}
