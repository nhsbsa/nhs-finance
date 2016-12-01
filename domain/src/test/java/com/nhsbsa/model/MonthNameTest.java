package com.nhsbsa.model;

import com.nhsbsa.model.MonthName;
import com.nhsbsa.model.MonthNum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nataliehulse on 10/11/2016.
 */

public class MonthNameTest {

    private final MonthName months = new MonthName();

    @Test
    public void MonthNoShouldReturnCorrectName() {

        String monthName = months.getMonthNameFromNum(2);
        assertEquals("Should be equal", monthName, "February");
    }

    @Test
    public void IncorrectMonthNoShouldReturnNull() {

        String monthName = months.getMonthNameFromNum(0);
        assertEquals("Should be equal", monthName, null);
    }

    }



