package com.nhsbsa.model.validaton;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by nataliehulse on 08/11/2016.
 */
public class DateLessThan31DaysFromTodayValidator implements ConstraintValidator<DateLessThan31DaysFromToday, Date>{
    public final void initialize(final DateLessThan31DaysFromToday annotation) {}

    public final boolean isValid(final Date value,
                                 final ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now           = LocalDate.now();
        LocalDate today         = LocalDate.parse(now.toString(), dateFormat);
        LocalDate futureDate    = LocalDate.parse(value.toString(),dateFormat);
        long daysBetween        = ChronoUnit.DAYS.between(today, futureDate);
        if (daysBetween > 31) {
            return false;
        }
        else {
            return true;
        }

    }

}
