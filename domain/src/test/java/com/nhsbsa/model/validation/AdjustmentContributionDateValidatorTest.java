package com.nhsbsa.model.validation;

import com.nhsbsa.model.AdjustmentContributionDate;
import com.nhsbsa.model.ContributionDate;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Nat Hulse on 30/11/2016.
 * ContributionDateValidatorTest
 */


@RunWith(Parameterized.class)
public class AdjustmentContributionDateValidatorTest {

    private static AdjustmentContributionDateValidator adjustmentContributionDateValidator;
    private static ConstraintValidatorContext constraintValidatorContext;


    @Before
    public void init() {
        final AdjustmentContributionDateValid adjustmentContributionDateValid = Mockito.mock(AdjustmentContributionDateValid.class);

        adjustmentContributionDateValidator = new AdjustmentContributionDateValidator() {
            @Override
            public DateTime getNow() {
                return DateTime.now().withYear(2003).withMonthOfYear(1).withDayOfMonth(1);
            }
        };
        adjustmentContributionDateValidator.initialize(adjustmentContributionDateValid);

        constraintValidatorContext = Mockito.mock(ConstraintValidatorContext.class);

        final ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder =
                Mockito.mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
        when(constraintValidatorContext.buildConstraintViolationWithTemplate(Mockito.anyString()))
                .thenReturn(constraintViolationBuilder);

    }

    @Parameterized.Parameters(name = "{index}: contribution({0}) expected: {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, false},
                {AdjustmentContributionDate.builder()
                        .contributionMonth(null)
                        .contributionYear(2000)
                        .build(), false},

                {AdjustmentContributionDate.builder()
                        .contributionMonth("January")
                        .contributionYear(null)
                        .build(), false},

                {AdjustmentContributionDate.builder()
                        .contributionMonth("May")
                        .contributionYear(2000)
                        .build(), false},

                {AdjustmentContributionDate.builder()
                        .contributionMonth("January")
                        .contributionYear(2000)
                        .build(), false},

                {AdjustmentContributionDate.builder()
                        .contributionMonth("February")
                        .contributionYear(2003)
                        .build(), false},

                {AdjustmentContributionDate.builder()
                        .contributionMonth("March")
                        .contributionYear(2000)
                        .build(), false},

                {AdjustmentContributionDate.builder()
                        .contributionMonth("January")
                        .contributionYear(2003)
                        .build(), true},

                {AdjustmentContributionDate.builder()
                        .contributionMonth("-1")
                        .contributionYear(2003)
                        .build(), false},
                {AdjustmentContributionDate.builder()
                        .contributionMonth("1")
                        .contributionYear(-2003)
                        .build(), false},
                {AdjustmentContributionDate.builder()
                        .contributionMonth(null)
                        .contributionYear(-2003)
                        .build(), false},
                {AdjustmentContributionDate.builder()
                        .contributionMonth("-1")
                        .contributionYear(null)
                        .build(), false},

        });
    }

    @Parameterized.Parameter
    public AdjustmentContributionDate adjustmentContributionDate;

    @Parameterized.Parameter(value = 1)
    public boolean valid;

    @Test
    public void test() {

        final boolean isValid = adjustmentContributionDateValidator.isValid(adjustmentContributionDate, constraintValidatorContext);
        assertEquals("Should match", valid, isValid);
    }


}