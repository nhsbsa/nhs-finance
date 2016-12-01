package com.nhsbsa.model;


import static org.hibernate.annotations.common.util.StringHelper.toUpperCase;

/**
 * Created by nataliehulse on 28/11/2016.
 * Class to transform the Month name in English and Welsh to a number
 */
public class MonthNum {


    public int getMonthNumFromName (String monthName) {
        int monthNum = 0;
        String name = toUpperCase(monthName);
        switch (name) {
            case "JANUARY":
            case "IONAWR":
                monthNum = 1;
                break;
            case "FEBRUARY":
            case "CHWEFROR":
                monthNum = 2;
                break;
            case "MARCH":
            case "MAWRTH":
                monthNum = 3;
                break;
            case "APRIL":
            case "EBRILL":
                monthNum = 4;
                break;
            case "MAY":
            case "MAI":
                monthNum = 5;
                break;
            case "JUNE":
            case "MEHEFIN":
                monthNum = 6;
                break;
            case "JULY":
            case "GORRFFENNAF":
                monthNum = 7;
                break;
            case "AUGUST":
            case "AWST":
                monthNum = 8;
                break;
            case "SEPTEMBER":
            case "MEDI":
                monthNum = 9;
                break;
            case "OCTOBER":
            case "HYDREF":
                monthNum = 10;
                break;
            case "NOVEMBER":
            case "TACHWEDD":
                monthNum = 11;
                break;
            case "DECEMBER":
            case "RHAGFYR":
                monthNum = 12;
                break;

        }
        return monthNum;
    }

}
