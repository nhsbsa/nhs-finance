package com.nhsbsa.model.validation;

import com.nhsbsa.model.validaton.DateIsAfterTodayValidator;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


/**
 * Created by nataliehulse on 11/11/2016.
 */
public class DateIsAfterTodayValidatorTest {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    DateIsAfterTodayValidator dateIsAfterTodayValidator;
    ConstraintValidatorContext context;

    @Before
    public void setUp() {
        dateIsAfterTodayValidator = new DateIsAfterTodayValidator() {
            @Override
            public LocalDate getDate() {
                return LocalDate.of(2016, 12, 1);
            }
        };
    }

    @Test
    public void dateIsAfterTodayValidatorReturnTrue() throws Exception{
        final Date afterToday = localDateToDate(LocalDate.of(2016, 12, 2));
        final Boolean value = dateIsAfterTodayValidator.isValid(afterToday, context);
        assertTrue(value);
    }

    @Test
    public void dateIsAfterTodayValidatorReturnFalse() throws Exception {
        final Date afterToday = localDateToDate(LocalDate.of(2016, 11, 1));
        final Boolean value = dateIsAfterTodayValidator.isValid(afterToday, context);
        assertFalse(value);
    }

    @Test
    public void dateIsAfterTodayValidatorReturnNull() {
        final Date date = null;
        final Boolean value = dateIsAfterTodayValidator.isValid(date,context);
        assertThat(value, is(equalTo(true)));
    }

    private Date localDateToDate(final LocalDate lessThan31) {
        return Date.from(lessThan31.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    }
