package com.nhsbsa.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import static org.junit.Assert.assertEquals;

/**
 * Created by nataliehulse on 10/11/2016.
 */
@RunWith(Parameterized.class)
public class FormDateTest {

    private FormDate formDate;

    @Parameterized.Parameters(name = "{index}: {0}, {1}. {2}. {3}")
    public static Collection<Object[]> data() throws Exception{
        return Arrays.asList(new Object[][]{
                {"", "", "", null},
                {"10", "11", "", null},
                {"10", "11", "2016", createDate("10/11/2016")},
                {"99", "11", "2016", null},
        });
    }

        private Date date;

    public FormDateTest(final String day, final String month, final String year, final Date date) {
        formDate = new FormDate();
        formDate.setDays(day);
        formDate.setMonth(month);
        formDate.setYear(year);
        this.date = date;
    }

    @Test
    public void formDateIsValidShouldMatchExpectedOutcome() {
        final Date dateValue = formDate.getDate();
        assertEquals("Should be equal", date, dateValue);
    }

    private static Date createDate(String value) throws Exception{
        final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        Date dateValue = DATE_FORMAT.parse(value);

        return dateValue;
    }


    }




