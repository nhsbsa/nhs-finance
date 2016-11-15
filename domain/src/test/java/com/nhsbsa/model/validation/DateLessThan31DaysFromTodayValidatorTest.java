package com.nhsbsa.model.validation;

import com.nhsbsa.model.validaton.DateIsAfterTodayValidator;
import com.nhsbsa.model.validaton.DateLessThan31DaysFromTodayValidator;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by nataliehulse on 11/11/2016.
 */
public class DateLessThan31DaysFromTodayValidatorTest {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    DateLessThan31DaysFromTodayValidator dateLessThan31DaysFromTodayValidator;
    ConstraintValidatorContext context;

    @Before
    public void setUp() {
        dateLessThan31DaysFromTodayValidator = new DateLessThan31DaysFromTodayValidator() {
            @Override
            public LocalDate getDate() {
                return LocalDate.of(2016, 12, 1);
            }
        };
    }

    @Test
    public void dateIsLessThan31DaysValidatorReturnTrue() throws Exception {
        final Date lessThan31 = localDateToDate(LocalDate.of(2016, 12, 2));
        final Boolean value = dateLessThan31DaysFromTodayValidator.isValid(lessThan31, context);
        assertTrue(value);
    }

    @Test
    public void dateIsMoreThan31DaysValidatorReturnTrue() throws Exception {
        final Date lessThan31 = localDateToDate(LocalDate.of(2017, 12, 1));
        final Boolean value = dateLessThan31DaysFromTodayValidator.isValid(lessThan31, context);
        assertFalse(value);
    }


    @Test
    public void dateIsLessThan31DaysValidatorReturnNull() {
        final Date date = null;
        final Boolean value = dateLessThan31DaysFromTodayValidator.isValid(date, context);
        assertThat(value, is(equalTo(true)));
    }

    private Date localDateToDate(final LocalDate lessThan31) {
        return Date.from(lessThan31.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
