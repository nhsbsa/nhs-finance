package com.nhsbsa;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by jeffreya on 23/08/2016.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"pretty", "html:reports/test-report"},

        tags = {"@adjustments"})

public class CucumberRunnerTest {


}
