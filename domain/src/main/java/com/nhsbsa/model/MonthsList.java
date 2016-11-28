package com.nhsbsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

/**
 * Created by nataliehulse on 28/11/2016.
 */
public class MonthsList {

    int monthNum;
    String monthName;

    MonthsList(int monthNum, String monthName) {

        this.monthNum = monthNum;
        this.monthName = monthName;
    }

    //@JsonIgnore
    public int getMonthNum(String monthName) {
        List<MonthsList> monthsList = new ArrayList<MonthsList>();

        MonthsList janEnglish = new MonthsList(1, "January");
        monthsList.add(janEnglish);
        MonthsList febEnglish = new MonthsList(2, "February");
        monthsList.add(febEnglish);
        MonthsList marEnglish = new MonthsList(3, "March");
        monthsList.add(marEnglish);
        MonthsList aprEnglish = new MonthsList(4, "April");
        monthsList.add(aprEnglish);
        MonthsList mayEnglish = new MonthsList(5, "May");
        monthsList.add(mayEnglish);
        MonthsList junEnglish = new MonthsList(6, "June");
        monthsList.add(junEnglish);
        MonthsList julEnglish = new MonthsList(7, "July");
        monthsList.add(julEnglish);
        MonthsList augEnglish = new MonthsList(8, "August");
        monthsList.add(augEnglish);
        MonthsList sepEnglish = new MonthsList(9, "September");
        monthsList.add(sepEnglish);
        MonthsList octEnglish = new MonthsList(10, "October");
        monthsList.add(octEnglish);
        MonthsList novEnglish = new MonthsList(11, "November");
        monthsList.add(novEnglish);
        MonthsList decEnglish = new MonthsList(12, "December");
        monthsList.add(decEnglish);

        MonthsList janWelsh = new MonthsList(1, "Ionawr");
        monthsList.add(janWelsh);
        MonthsList febWelsh = new MonthsList(2, "Chwefror");
        monthsList.add(febWelsh);
        MonthsList marWelsh = new MonthsList(3, "Mawrth");
        monthsList.add(marWelsh);
        MonthsList aprWelsh = new MonthsList(4, "Ebrill");
        monthsList.add(aprWelsh);
        MonthsList mayWelsh = new MonthsList(5, "Mai");
        monthsList.add(mayWelsh);
        MonthsList junWelsh = new MonthsList(6, "Mehefin");
        monthsList.add(junWelsh);
        MonthsList julWelsh = new MonthsList(7, "Gorffennaf");
        monthsList.add(julWelsh);
        MonthsList augWelsh = new MonthsList(8, "Awst");
        monthsList.add(augWelsh);
        MonthsList sepWelsh = new MonthsList(9, "Medi");
        monthsList.add(sepWelsh);
        MonthsList octWelsh = new MonthsList(10, "Hydref");
        monthsList.add(octWelsh);
        MonthsList novWelsh = new MonthsList(11, "Tachwedd");
        monthsList.add(novWelsh);
        MonthsList decWelsh = new MonthsList(12, "Rhagfyr");
        monthsList.add(decWelsh);

        for(MonthsList m: monthsList)
            if(m.equals(monthName))
                return monthNum;

        return 0;

    }

}