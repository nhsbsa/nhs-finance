package com.nhsbsa.model.validaton;

import com.nhsbsa.model.ContributionDate;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.validation.Payload;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by jeffreya on 14/11/2016.
 * ContributionDateValidatorTest
 */


@RunWith(Parameterized.class)
public class ContributionDateValidatorTest {


    private static final ContributionDateValidator CONTRIBUTION_DATE_VALIDATOR = new ContributionDateValidator() {
        @Override
        public DateTime getNow() {
            return DateTime.now().withYear(2000).withMonthOfYear(1).withDayOfMonth(1);
        }
    };

    static {
        CONTRIBUTION_DATE_VALIDATOR.initialize(new ContributionDateValid() {
            @Override
            public int monthsInAdvanceLimit() {
                return 2;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public String message() {
                return null;
            }

            @Override
            public Class<?>[] groups() {
                return new Class<?>[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return null;
            }
        });
    }

    @Parameterized.Parameters
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
                        .build(), true},

                {ContributionDate.builder()
                        .contributionMonth(2)
                        .contributionYear(2000)
                        .build(), true},

                {ContributionDate.builder()
                        .contributionMonth(3)
                        .contributionYear(2000)
                        .build(), true},

                {ContributionDate.builder()
                        .contributionMonth(1)
                        .contributionYear(1999)
                        .build(), true},
        });
    }

    @Parameterized.Parameter
    public ContributionDate contributionDate;

    @Parameterized.Parameter(value = 1)
    public boolean valid;

    @Test
    public void test() {

        final boolean isValid = CONTRIBUTION_DATE_VALIDATOR.isValid(contributionDate, null);
        assertEquals("Should match", valid, isValid);
    }


}