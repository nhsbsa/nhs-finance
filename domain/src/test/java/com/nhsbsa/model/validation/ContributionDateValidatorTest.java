package com.nhsbsa.model.validation;

import com.nhsbsa.model.ContributionDate;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by jeffreya on 14/11/2016.
 * ContributionDateValidatorTest
 */


@RunWith(Parameterized.class)
public class ContributionDateValidatorTest {

    private static ContributionDateValidator contributionDateValidator;
    private static ConstraintValidatorContext constraintValidatorContext;


    @Before
    public void init() {
        final ContributionDateValid contributionDateValid = Mockito.mock(ContributionDateValid.class);
        when(contributionDateValid.monthsInAdvanceLimit()).thenReturn(2);

        contributionDateValidator = new ContributionDateValidator() {
            @Override
            public DateTime getNow() {
                return DateTime.now().withYear(2003).withMonthOfYear(1).withDayOfMonth(1);
            }
        };
        contributionDateValidator.initialize(contributionDateValid);

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
                {ContributionDate.builder()
                        .contributionMonth(null)
                        .contributionYear(2000)
                        .build(), false},

                {ContributionDate.builder()
                        .contributionMonth(1)
                        .contributionYear(null)
                        .build(), false},

                {ContributionDate.builder()
                        .contributionMonth(5)
                        .contributionYear(2000)
                        .build(), false},

                {ContributionDate.builder()
                        .contributionMonth(1)
                        .contributionYear(2000)
                        .build(), false},

                {ContributionDate.builder()
                        .contributionMonth(2)
                        .contributionYear(2003)
                        .build(), true},

                {ContributionDate.builder()
                        .contributionMonth(3)
                        .contributionYear(2000)
                        .build(), false},

                {ContributionDate.builder()
                        .contributionMonth(1)
                        .contributionYear(2003)
                        .build(), true},
                {ContributionDate.builder()
                        .contributionMonth(-1)
                        .contributionYear(2003)
                        .build(), false},
                {ContributionDate.builder()
                        .contributionMonth(1)
                        .contributionYear(-2003)
                        .build(), false},
                {ContributionDate.builder()
                        .contributionMonth(null)
                        .contributionYear(-2003)
                        .build(), false},
                {ContributionDate.builder()
                        .contributionMonth(-1)
                        .contributionYear(null)
                        .build(), false},

        });
    }

    @Parameterized.Parameter
    public ContributionDate contributionDate;

    @Parameterized.Parameter(value = 1)
    public boolean valid;

    @Test
    public void test() {

        final boolean isValid = contributionDateValidator.isValid(contributionDate, constraintValidatorContext);
        assertEquals("Should match", valid, isValid);
    }


}