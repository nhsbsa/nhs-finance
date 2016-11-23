package com.nhsbsa.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by nataliehulse on 08/11/2016.
 */
public class DateIsAfterTodayValidator implements ConstraintValidator<DateIsAfterToday, Date> {
    public final void initialize(final DateIsAfterToday annotation) {
    }

    public final boolean isValid(final Date value,
                                 final ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }
        LocalDate today = getDate();
        // Have to create an Instant to convert Java.Util.Date to Java.Time LocalDate
        Instant instant = Instant.ofEpochMilli(value.getTime());
        // Create variable of Instance
        LocalDate futureDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();


        return futureDate.isAfter(today);
    }

    public LocalDate getDate() {
        return LocalDate.now();
    }


}