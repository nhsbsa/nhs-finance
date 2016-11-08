package com.nhsbsa.model;

import com.nhsbsa.model.validaton.DateIsAfterToday;
import com.nhsbsa.model.validaton.DateLessThan31DaysFromToday;

import java.util.Date;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

public class TransferFormDate extends FormDate {

    @DateIsAfterToday
    @DateLessThan31DaysFromToday
    public Date getDate() {
        return super.getDate();
    }

}