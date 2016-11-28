package com.nhsbsa.model.validation;


import com.nhsbsa.model.AdjustmentContributionDate;
import com.nhsbsa.model.MonthNum;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.springframework.beans.factory.annotation.Value;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AdjustmentContributionDateValidator implements ConstraintValidator<AdjustmentContributionDateValid, AdjustmentContributionDate> {

    private MonthNum monthNum;

    @Value("${adjustmentContributionDate.not.blank}")
    private String adjustmentContributionDateNotBlank = "placeholder";

    @Value("${adjustmentContributionDate.not.valid}")
    private String adjustmentContributionDateNotValid = "placeholder";

    @Value("${adjustmentContributionDate.not.in.range}")
    private String adjustmentContributionDateNotInRange = "placeholder";

    @Override
    public void initialize(AdjustmentContributionDateValid constraintAnnotation) {
        monthNum = new MonthNum();
    }

    @Override
    public boolean isValid(AdjustmentContributionDate adjustmentContributionDate, ConstraintValidatorContext context) {
        return !(containsInvalidData(adjustmentContributionDate, context) || containsInvalidDate(adjustmentContributionDate, context));
    }

    private boolean containsInvalidDate(final AdjustmentContributionDate adjustmentContributionDate, final ConstraintValidatorContext context) {
        final DateTime now = getNow();
        final DateTime dateEntered = contributionDateToDateTime(adjustmentContributionDate, now);
        final int months = Months.monthsBetween(now, dateEntered).getMonths();
        final boolean isValid = months == 0;
        if (!isValid) {
            context.buildConstraintViolationWithTemplate(adjustmentContributionDateNotInRange.replace("$", ""))
                    .addConstraintViolation();
        }
        return !isValid;
    }

    private boolean containsInvalidData(final AdjustmentContributionDate adjustmentContributionDate, final ConstraintValidatorContext context) {
        return handleNullValues(adjustmentContributionDate, context) || handleInvalidValues(adjustmentContributionDate, context);
    }

    private boolean handleInvalidValues(AdjustmentContributionDate adjustmentContributionDate, ConstraintValidatorContext context) {
        final boolean containsInvalidValue = containsInvalidValue(adjustmentContributionDate);
        if (containsInvalidValue) {
            context.buildConstraintViolationWithTemplate(
                    adjustmentContributionDateNotValid.replace("$", ""))
                    .addConstraintViolation();
            return true;
        }
        return false;
    }

    private boolean handleNullValues(AdjustmentContributionDate adjustmentContributionDate, ConstraintValidatorContext context) {
        final boolean containsNullValue = containsNullValue(adjustmentContributionDate);
        if (containsNullValue) {
            context.buildConstraintViolationWithTemplate(
                    adjustmentContributionDateNotBlank.replace("$", ""))
                    .addConstraintViolation();
            return true;
        }
        return false;
    }

    private boolean containsInvalidValue(final AdjustmentContributionDate adjustmentContributionDate) {
        final boolean validMonth = isValidMonth(monthNum.getMonthNumFromName(adjustmentContributionDate.getContributionMonth()));
        final boolean validYear = isValidYear(adjustmentContributionDate.getContributionYear());
        return !(validMonth && validYear);
    }

    private boolean isValidYear(final Integer year) {
        return year >= 2001;
    }

    private boolean isValidMonth(final Integer month) {
        return month > 0 && month <= 12;
    }

    private DateTime contributionDateToDateTime(final AdjustmentContributionDate adjustmentContributionDate, final DateTime now) {
        return getNow()
                .withYear(adjustmentContributionDate.getContributionYear())
                .withMonthOfYear(monthNum.getMonthNumFromName(adjustmentContributionDate.getContributionMonth()))
                .withDayOfMonth(now.getDayOfMonth());
    }

    private boolean containsNullValue(final AdjustmentContributionDate adjustmentContributionDate) {
        return adjustmentContributionDate == null || adjustmentContributionDate.getContributionMonth() == null || adjustmentContributionDate.getContributionYear() == null;
    }

    public DateTime getNow() {
        return DateTime.now();
    }
}
