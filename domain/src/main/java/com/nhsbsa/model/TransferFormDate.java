package com.nhsbsa.model;

import com.nhsbsa.model.validaton.DateIsAfterToday;
import com.nhsbsa.model.validaton.DateLessThan31DaysFromToday;
import com.nhsbsa.model.validaton.FormDateNotBlank;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

@FormDateNotBlank
@Builder
@Data
public class TransferFormDate extends FormDate implements Serializable{

    @Override
    @DateIsAfterToday
    @DateLessThan31DaysFromToday
    public Date getDate() {
        return super.getDate();
    }

    public LocalDate getLocalDate() {
        return LocalDate.now();
    }

}