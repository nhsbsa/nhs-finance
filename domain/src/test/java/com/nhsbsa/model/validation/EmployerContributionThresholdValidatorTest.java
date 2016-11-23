package com.nhsbsa.model.validation;

import com.nhsbsa.model.RequestForTransfer;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Mark Lishman on 18/11/2016.
 */
public class EmployerContributionThresholdValidatorTest {

    private static final ConstraintValidatorContext NOT_REQUIRED = null;
    
    private EmployerContributionThresholdValidator validator;

    @Before
    public void before() {
        validator = new EmployerContributionThresholdValidator();
    }

    @Test
    public void isValidReturnsTrueWhenTotalPensionablePayIsNull() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .employerContributions(new BigDecimal("123.45"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(true)));
    }

    @Test
    public void isValidReturnsTrueWhenEmployerContributionsIsNull() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .totalPensionablePay(new BigDecimal("123.45"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(true)));
    }

    @Test
    public void isValidReturnsTrueWhenEmployerContributionsIsInsideThreshold() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .totalPensionablePay(new BigDecimal("100"))
                .employerContributions(new BigDecimal("14"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(true)));
    }

    @Test
    public void isValidReturnsFalseWhenEmployerContributionsIsOutsideThreshold() {
        RequestForTransfer rft = RequestForTransfer
                .builder()
                .totalPensionablePay(new BigDecimal("100"))
                .employerContributions(new BigDecimal("13.99"))
                .build();

        boolean actual = validator.isValid(rft, NOT_REQUIRED);

        assertThat(actual, is(equalTo(false)));
    }

}