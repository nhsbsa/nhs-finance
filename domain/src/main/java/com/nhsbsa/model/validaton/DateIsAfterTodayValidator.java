package com.nhsbsa.model.validaton;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nataliehulse on 08/11/2016.
 */
public class DateIsAfterTodayValidator implements ConstraintValidator<DateIsAfterToday, Date>{
    public final void initialize(final DateIsAfterToday annotation) {}

    public final boolean isValid(final Date value,
                                 final ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();

        return value.after(today);
    }

}
