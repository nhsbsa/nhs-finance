package com.nhsbsa.model.validation;

import com.nhsbsa.model.RequestForTransfer;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Mark Lishman on 18/11/2016.
 */
public class EmployeeContributionThresholdValidatorTest {

    private static final ConstraintValidatorContext NOT_REQUIRED = null;
    
    private EmployeeContributionThresholdValidator validator;

    @Before
    public void before() {
        validator = new EmployeeContributionThresholdValidator();
    }

    @Test
    public void isValidReturnsTrueWhenTotalPensionablePayIsNull() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .employeeContributions(new BigDecimal("123.45"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(true)));
    }

    @Test
    public void isValidReturnsTrueWhenEmployeeContributionsIsNull() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .totalPensionablePay(new BigDecimal("123.45"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(true)));
    }

    @Test
    public void isValidReturnsTrueWhenEmployeeContributionsIsAboveThreshold() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("5"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(true)));
    }

    @Test
    public void isValidReturnsTrueWhenEmployeeContributionsIsBelowThreshold() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("14.5"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(true)));
    }

    @Test
    public void isValidReturnsFalseWhenEmployeeContributionsIsBelowThreshold() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("4.99"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(false)));
    }

    @Test
    public void isValidReturnsFalseWhenEmployeeContributionsIsAboveThreshold() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("14.51"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(false)));
    }

}