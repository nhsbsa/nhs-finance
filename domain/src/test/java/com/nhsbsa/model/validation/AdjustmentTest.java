package com.nhsbsa.model.validation;

import com.nhsbsa.model.Adjustment;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by MattHood on 29/11/2016.
 */
public class AdjustmentTest {

    private Adjustment adjustment;
    private static Validator validator;
    private Adjustment.AdjustmentBuilder adjustmentBuilder;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void before() {
        adjustmentBuilder = Adjustment
                .builder();
    }

    @Test
    public void employeeContributionsAdjustmentsNotEnteredValidationError() {
        Adjustment adjustment = adjustmentBuilder
                .employeeContributions(new BigDecimal("0.50"))
                .build();

        Set<ConstraintViolation<Adjustment>> constraintViolations = validator.validate(adjustment, ContributionsValidationGroup.class);

        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{adjustment.employeeContributions.invalid}"))));
    }

    @Test
    public void employerContributionsAdjustmentsNotEnteredValidationError() {
        Adjustment adjustment = adjustmentBuilder
                .employerContributions(new BigDecimal("57.423"))
                .build();

        Set<ConstraintViolation<Adjustment>> constraintViolations = validator.validate(adjustment, ContributionsValidationGroup.class);

        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{adjustment.employerContributions.invalid}"))));
    }

    @Test
    public void employeeAddedYearsAdjustmentsNotEnteredValidationError() {
        Adjustment adjustment = adjustmentBuilder
                .employeeAddedYears(new BigDecimal("1.5432"))
                .build();

        Set<ConstraintViolation<Adjustment>> constraintViolations = validator.validate(adjustment, ContributionsValidationGroup.class);

        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{adjustment.employeeAddedYears.invalid}"))));
    }

    @Test
    public void additionalPensionAdjustmentsNotEnteredValidationError() {
        Adjustment adjustment = adjustmentBuilder
                .additionalPension(new BigDecimal("12.532"))
                .build();

        Set<ConstraintViolation<Adjustment>> constraintViolations = validator.validate(adjustment, ContributionsValidationGroup.class);

        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{adjustment.additionalPension.invalid}"))));
    }

    @Test
    public void errboAdjustmentsNotEnteredValidationError() {
        Adjustment adjustment = adjustmentBuilder
                .errbo(new BigDecimal("0.99"))
                .build();

        Set<ConstraintViolation<Adjustment>> constraintViolations = validator.validate(adjustment, ContributionsValidationGroup.class);

        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{adjustment.errbo.invalid}"))));
    }

}
