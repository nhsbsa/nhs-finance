package com.nhsbsa.model.validation;

import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.model.TransferFormDate;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


/**
 * Created by nataliehulse on 11/11/2016.
 */
public class RequestForTransferTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void transferDateValidationError() throws Exception {
        RequestForTransfer requestForTransfer = RequestForTransfer
                .builder()
                .transferDate(
                        TransferFormDate
                                .builder()
                                .days("111")
                                .month("12")
                                .year("2016")
                                .build()
                )
                .build();
        requestForTransfer.setIsGp(true);

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{validation.validFormDate}"))));
    }

    @Test
    public void isGpValidationError() throws Exception {
        RequestForTransfer requestForTransfer = RequestForTransfer
                .builder()
                .transferDate(tomorrow())
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, SchedulePaymentValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{isGp.notNull}"))));
    }

    @Test
    public void employeeContributionBelowThreshold() throws Exception {
        RequestForTransfer requestForTransfer = RequestForTransfer
                .builder()
                .transferDate(tomorrow())
                .isGp(true)
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("4.99"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, ContributionsValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{employee.contribution.threshold}"))));
    }

    @Test
    public void employeeContributionAboveThreshold() throws Exception {
        RequestForTransfer requestForTransfer = RequestForTransfer
                .builder()
                .transferDate(tomorrow())
                .isGp(true)
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("14.51"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, ContributionsValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{employee.contribution.threshold}"))));
    }

    @Test
    public void employerContributionBelowThreshold() throws Exception {
        RequestForTransfer requestForTransfer = RequestForTransfer
                .builder()
                .transferDate(tomorrow())
                .isGp(true)
                .totalPensionablePay(new BigDecimal("100"))
                .employerContributions(new BigDecimal("13.99"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, ContributionsValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{employer.contribution.threshold}"))));
    }

    private TransferFormDate tomorrow() {
        LocalDate tomorrowsDate = new LocalDate().plusDays(1);
        return TransferFormDate
                .builder()
                .days(String.valueOf(tomorrowsDate.getDayOfMonth()))
                .month(String.valueOf(tomorrowsDate.getMonthOfYear()))
                .year(String.valueOf(tomorrowsDate.getYear()))
                .build();
    }



}
