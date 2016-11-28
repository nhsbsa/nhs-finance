package com.nhsbsa.model;

import com.nhsbsa.model.MonthNum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nataliehulse on 10/11/2016.
 */

public class MonthNumTest {

    private final MonthNum months = new MonthNum();

    @Test
    public void englishMonthShouldReturnCorrectNumber() {

        int monthNum = months.getMonthNumFromName("February");
        assertEquals("Should be equal", monthNum, 2);
    }

    @Test
    public void welshMonthShouldReturnCorrectNumber() {

        int monthNum = months.getMonthNumFromName("Ebrill");
        assertEquals("Should be equal", monthNum, 4);
    }

    @Test
    public void incorrectEnglishMonthShouldReturn0() {

        int monthNum = months.getMonthNumFromName("jan");
        assertEquals("Should be equal", monthNum, 0);
    }

    @Test
    public void incorrectWelshMonthShouldReturn0() {

        int monthNum = months.getMonthNumFromName("Rhagfy");
        assertEquals("Should be equal", monthNum, 0);
    }

    @Test
    public void emptyMonthShouldReturn0() {

        int monthNum = months.getMonthNumFromName("");
        assertEquals("Should be equal", monthNum, 0);
    }

    }



