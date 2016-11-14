package com.nhsbsa.model.validaton;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by nataliehulse on 08/11/2016.
 */
public class DateLessThan31DaysFromTodayValidator implements ConstraintValidator<DateLessThan31DaysFromToday, Date> {
    public final void initialize(final DateLessThan31DaysFromToday annotation) {
    }

    public final boolean isValid(final Date value,
                                 final ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        final LocalDate today = getDate();
        // Have to create an Instant to convert Java.Util.Date to Java.Time LocalDate
        Instant instant = Instant.ofEpochMilli(value.getTime());
        // Create variable of Instance
        LocalDate futureDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        long daysBetween = ChronoUnit.DAYS.between(today, futureDate);
        return daysBetween <= 31;

    }

    public LocalDate getDate() {
        return LocalDate.now();
    }

}
