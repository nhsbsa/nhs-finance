package com.nhsbsa.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by nataliehulse on 11/11/2016.
 */
public class TransferFormDateTest {

    private TransferFormDate transferFormDate;
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
        transferFormDate.setDays("10");
        transferFormDate.setMonth("11");
        transferFormDate.setYear("2016");

        Set<ConstraintViolation<TransferFormDate>> constraintViolations = validator.validate(transferFormDate);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{transferDate.notAfterToday}"))));
    }

    @Test
    public void DateIsLessThan31DaysFromTodayValidationError() throws Exception {
        transferFormDate.setDays("13");
        transferFormDate.setMonth("12");
        transferFormDate.setYear("2016");

        Set<ConstraintViolation<TransferFormDate>> constraintViolations = validator.validate(transferFormDate);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{transferDate.greaterThan31Days}"))));
    }
}
