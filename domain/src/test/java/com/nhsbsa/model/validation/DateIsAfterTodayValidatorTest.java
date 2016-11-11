package com.nhsbsa.model.validation;

import com.nhsbsa.model.validaton.DateIsAfterTodayValidator;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by nataliehulse on 11/11/2016.
 */
public class DateIsAfterTodayValidatorTest {
     DateIsAfterTodayValidator dateIsAfterTodayValidator;
     ConstraintValidatorContext context;

    @Before
    public void setUp() {
        dateIsAfterTodayValidator = new DateIsAfterTodayValidator();
    }

    @Test
    public void dateIsAfterTodayValidatorReturnTrue() throws Exception{
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = format.parse("12/11/2016");
      final Boolean value = dateIsAfterTodayValidator.isValid(date,context);
        assertThat(value, is(equalTo(true)));
    }

    @Test
    public void dateIsAfterTodayValidatorReturnFalse() throws Exception {
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = format.parse("10/11/2016");
        final Boolean value = dateIsAfterTodayValidator.isValid(date,context);
        assertThat(value, is(equalTo(false)));
    }

    @Test
    public void dateIsAfterTodayValidatorReturnNull() {
        final Date date = null;
        final Boolean value = dateIsAfterTodayValidator.isValid(date,context);
        assertThat(value, is(equalTo(true)));
    }

    }
