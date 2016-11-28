package com.nhsbsa.model;

/**
 * Created by nataliehulse on 28/11/2016.
 * Class to transform the Month name in English and Welsh to a number
 */
public class MonthNum {


    public int getMonthNumFromName (String monthName) {
        int monthNum = 0;
        switch (monthName) {
            case "January":
            case "Ionawr":
                monthNum = 1;
                break;
            case "February":
            case "Chwefror":
                monthNum = 2;
                break;
            case "March":
            case "Mawrth":
                monthNum = 3;
                break;
            case "April":
            case "Ebrill":
                monthNum = 4;
                break;
            case "May":
            case "Mai":
                monthNum = 5;
                break;
            case "June":
            case "Mehefin":
                monthNum = 6;
                break;
            case "July":
            case "Gorffennaf":
                monthNum = 7;
                break;
            case "August":
            case "Awst":
                monthNum = 8;
                break;
            case "September":
            case "Medi":
                monthNum = 9;
                break;
            case "October":
            case "Hydref":
                monthNum = 10;
                break;
            case "November":
            case "Tachwedd":
                monthNum = 11;
                break;
            case "December":
            case "Rhagfyr":
                monthNum = 12;
                break;

        }
        return monthNum;
    }

}
