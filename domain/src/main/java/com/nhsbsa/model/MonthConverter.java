package com.nhsbsa.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Natalie Hulse 29/11/2016
 * This converter is required to transpose a Month value of String into an Int and vice versa
 */

@Converter
public class MonthConverter implements AttributeConverter<String, Integer> {

    @Override
    public Integer convertToDatabaseColumn(String month) {
        if (month == null) {
            return 0;
        }

        MonthNum monthNum = new MonthNum();
        int monthInt = monthNum.getMonthNumFromName(month);
        return monthInt;
    }


    @Override
    public String convertToEntityAttribute(Integer month) {
        if (month == null) {
            return null;
        }
        MonthName monthName = new MonthName();
        String monthString = monthName.getMonthNameFromNum(month);

        return monthString;
    }


}

