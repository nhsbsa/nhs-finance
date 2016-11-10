package com.nhsbsa.model;

import com.nhsbsa.model.validaton.DateIsAfterToday;
import com.nhsbsa.model.validaton.DateLessThan31DaysFromToday;
import com.nhsbsa.model.validaton.FormDateNotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

@FormDateNotBlank
public class TransferFormDate extends FormDate {

    @Override
    @DateIsAfterToday
    @DateLessThan31DaysFromToday
    public Date getDate() {
        return super.getDate();
    }

}