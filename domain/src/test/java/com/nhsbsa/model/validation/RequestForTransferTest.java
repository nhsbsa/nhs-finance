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
    private RequestForTransfer.RequestForTransferBuilder requestForTransferBuilder;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void before() {
        requestForTransferBuilder = RequestForTransfer
                .builder()
                .transferDate(tomorrow())
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("10"))
                .employerContributions(new BigDecimal("20"))
                .isGp(true);

    }

    @Test
    public void allDataIsValid() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer);

        assertThat(constraintViolations, hasSize(0));
    }

    @Test
    public void invalidTransferDateValidationError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .transferDate(
                    TransferFormDate
                            .builder()
                            .days("111")
                            .month("12")
                            .year("2016")
                            .build()
                    )
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("10"))
                .employerContributions(new BigDecimal("20"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{validation.validFormDate}"))));
    }

    @Test
    public void gpOrStaffNotSetValidationError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .isGp(null)
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, SchedulePaymentValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{isGp.notNull}"))));
    }

    @Test
    public void totalPensionablePayNotEnteredValidationError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .totalPensionablePay(null)
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, ContributionsValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{totalPensionablePay.notNull}"))));
    }

    @Test
    public void employeeContributionsNotEnteredValidationError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .employeeContributions(null)
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, ContributionsValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{employeeContributions.notNull}"))));
    }

    @Test
    public void employerContributionsNotEnteredValidationError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .employerContributions(null)
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, ContributionsValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{employerContributions.notNull}"))));
    }

    @Test
    public void employeeContributionBelowThresholdValidationError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("4.99"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, ContributionsValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{employee.contribution.threshold}"))));
    }

    @Test
    public void employeeContributionAboveThresholdValidationError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .totalPensionablePay(new BigDecimal("100"))
                .employeeContributions(new BigDecimal("14.51"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, ContributionsValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{employee.contribution.threshold}"))));
    }

    @Test
    public void employerContributionBelowThresholdValidationError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .totalPensionablePay(new BigDecimal("100"))
                .employerContributions(new BigDecimal("13.99"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer, ContributionsValidationGroup.class);

        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{employer.contribution.threshold}"))));
    }

    // Total pensionable pay/Employee contributions/Employer contributions/Employee added years/Additional pension/ERRBO are the same style
    // as use the @Currency annotation validator, so just used one for this testing, a few examples below.
    @Test
    public void totalPensionablePayBelowMinimumValueError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .totalPensionablePay(new BigDecimal("0.99"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer);
        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{contsAndPayments.currencyRange}"))));
    }

    @Test
    public void totalPensionablePayAboveMaximumValueError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .totalPensionablePay(new BigDecimal("99999999.991"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer);
        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{contsAndPayments.currencyRange}"))));
    }

    @Test
    public void totalPensionablePayNegativeValueError() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .totalPensionablePay(new BigDecimal("-3.99"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer);
        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo(("{contsAndPayments.currencyRange}"))));
    }

    @Test
    public void totalPensionablePayValidAmountValue() {
        RequestForTransfer requestForTransfer = requestForTransferBuilder
                .totalPensionablePay(new BigDecimal("12.99"))
                .build();

        Set<ConstraintViolation<RequestForTransfer>> constraintViolations = validator.validate(requestForTransfer);
        assertThat(constraintViolations, hasSize(0));
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
