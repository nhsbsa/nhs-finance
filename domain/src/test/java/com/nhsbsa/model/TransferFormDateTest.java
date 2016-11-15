package com.nhsbsa.model;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by nataliehulse on 11/11/2016.
 */
public class TransferFormDateTest {

    private TransferFormDate transferFormDate;
    private FormDate formDate;
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void setUp() {
        transferFormDate = new TransferFormDate();

    }

    @Test
    public void FormDateNotBlankValidationError() throws Exception {
        transferFormDate.setDays("");
        transferFormDate.setMonth("");
        transferFormDate.setYear("");

        Set<ConstraintViolation<TransferFormDate>> constraintViolations = validator.validate(transferFormDate);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{formDate.notBlank}"))));
    }

    @Test
    public void DateIsAfterTodayValidationError() throws Exception {

        final LocalDateTime localDateTime = LocalDateTime.now();
        final int dayOfMonth = (localDateTime.getDayOfMonth() == 1 ? 1 : localDateTime.getDayOfMonth() - 1);
        transferFormDate.setDays(Integer.toString(dayOfMonth));
        transferFormDate.setMonth(Integer.toString(localDateTime.getMonthOfYear()));
        transferFormDate.setYear(Integer.toString(localDateTime.getYear()));

        final Set<ConstraintViolation<TransferFormDate>> constraintViolations = validator.validate(transferFormDate);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{transferDate.notAfterToday}"))));
    }

   @Test
    public void DateIsLessThan31DaysFromTodayValidationError() throws Exception {
       final LocalDateTime threeMonthsTime = LocalDateTime.now().plusMonths(3);
       transferFormDate.setDays(Integer.toString(threeMonthsTime.getDayOfMonth()));
       transferFormDate.setMonth(Integer.toString(threeMonthsTime.getMonthOfYear()));
       transferFormDate.setYear(Integer.toString(threeMonthsTime.getYear()));

        Set<ConstraintViolation<TransferFormDate>> constraintViolations = validator.validate(transferFormDate);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{transferDate.greaterThan31Days}"))));
    }

}
