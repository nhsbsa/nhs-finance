package com.nhsbsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nhsbsa.model.validation.DateIsAfterToday;
import com.nhsbsa.model.validation.DateLessThan31DaysFromToday;
import com.nhsbsa.model.validation.FormDateNotBlank;
import com.nhsbsa.model.validation.SchedulePaymentValidationGroup;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

@FormDateNotBlank(groups = SchedulePaymentValidationGroup.class)
@Data
@NoArgsConstructor
public class TransferFormDate extends FormDate implements Serializable{

    @Builder
    private TransferFormDate(final String days, final String month, final String year) {
        super(days, month, year);
    }

    @Override
    @DateIsAfterToday(groups = SchedulePaymentValidationGroup.class)
    @DateLessThan31DaysFromToday(groups = SchedulePaymentValidationGroup.class)
    public Date getDate() {
        return super.getDate();
    }

    @JsonIgnore
    public LocalDate getLocalDate() {
        return LocalDate.now();
    }

}