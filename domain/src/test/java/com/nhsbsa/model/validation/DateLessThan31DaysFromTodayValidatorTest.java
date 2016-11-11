package com.nhsbsa.model.validation;

import com.nhsbsa.model.validaton.DateIsAfterTodayValidator;
import com.nhsbsa.model.validaton.DateLessThan31DaysFromTodayValidator;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by nataliehulse on 11/11/2016.
 */
public class DateLessThan31DaysFromTodayValidatorTest {
     DateLessThan31DaysFromTodayValidator dateLessThan31DaysFromTodayValidator;
     ConstraintValidatorContext context;

    @Before
    public void setUp() {
        dateLessThan31DaysFromTodayValidator = new DateLessThan31DaysFromTodayValidator();
    }

    @Test
    public void dateIsLessThan31DaysValidatorReturnTrue() throws Exception{
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = format.parse("12/11/2016");
      final Boolean value = dateLessThan31DaysFromTodayValidator.isValid(date,context);
        assertThat(value, is(equalTo(true)));
    }

    @Test
    public void dateIsGreaterThan31DaysValidatorReturnFalse() throws Exception {
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = format.parse("13/12/2016");
        final Boolean value = dateLessThan31DaysFromTodayValidator.isValid(date,context);
        assertThat(value, is(equalTo(false)));
    }

    @Test
    public void dateIsLessThan31DaysValidatorReturnNull() {
        final Date date = null;
        final Boolean value = dateLessThan31DaysFromTodayValidator.isValid(date,context);
        assertThat(value, is(equalTo(true)));
    }

    }
