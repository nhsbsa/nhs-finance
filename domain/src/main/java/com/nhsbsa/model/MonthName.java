package com.nhsbsa.model;

/**
 * Created by nataliehulse on 28/11/2016.
 * Class to transform the Month name in English and Welsh to a number
 */
public class MonthName {


    public String getMonthNameFromNum (Integer monthNum) {
        String monthName = null;
        switch (monthNum) {
            case 1:
                monthName ="January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;

        }
        return monthName;
    }

}
