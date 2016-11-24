package com.nhsbsa.model.validation;


import com.nhsbsa.model.ContributionDate;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContributionDateValidator implements ConstraintValidator<ContributionDateValid, ContributionDate> {


    private int monthsInAdvanceLimit;

    @Value("${contributionDate.not.blank}")
    private String contributionDateNotBlank = "placeholder";

    @Value("${contributionDate.not.valid}")
    private String contributionDateNotValid = "placeholder";

    @Value("${contributionDate.not.in.range}")
    private String contributionDateNotInRange = "placeholder";

    @Override
    public void initialize(ContributionDateValid constraintAnnotation) {
        monthsInAdvanceLimit = constraintAnnotation.monthsInAdvanceLimit();
    }

    @Override
    public boolean isValid(ContributionDate contributionDate, ConstraintValidatorContext context) {
        if (containsInvalidData(contributionDate, context)) {
            return false;
        }

        if (containsInvalidDate(contributionDate, context)) {
            return false;
        }
        return true;
    }

    private boolean containsInvalidDate(final ContributionDate contributionDate, final ConstraintValidatorContext context) {
        final DateTime now = getNow();
        final DateTime advanceLimitDate = now.plusMonths(monthsInAdvanceLimit);
        final DateTime dateEntered = contributionDateToDateTime(contributionDate, now);
        final int months = Months.monthsBetween(dateEntered, advanceLimitDate).getMonths();
        final boolean isValid = months >= 0;
        if (!isValid) {
            context.buildConstraintViolationWithTemplate(contributionDateNotInRange.replace("$", ""))
                    .addConstraintViolation();
        }
        return !isValid;
    }

    private boolean containsInvalidData(final ContributionDate contributionDate, final ConstraintValidatorContext context) {
        return handleNullValues(contributionDate, context) || handleInvalidValues(contributionDate, context);
    }

    private boolean handleInvalidValues(ContributionDate contributionDate, ConstraintValidatorContext context) {
        final boolean containsInvalidValue = containsInvalidValue(contributionDate);
        if (containsInvalidValue) {
            context.buildConstraintViolationWithTemplate(
                    contributionDateNotValid.replace("$", ""))
                    .addConstraintViolation();
            return true;
        }
        return false;
    }

    private boolean handleNullValues(ContributionDate contributionDate, ConstraintValidatorContext context) {
        final boolean containsNullValue = containsNullValue(contributionDate);
        if (containsNullValue) {
            context.buildConstraintViolationWithTemplate(
                    contributionDateNotBlank.replace("$", ""))
                    .addConstraintViolation();
            return true;
        }
        return false;
    }

    private boolean containsInvalidValue(final ContributionDate contributionDate) {
        final boolean validMonth = isValidMonth(contributionDate.getContributionMonth());
        final boolean validYear = isValidYear(contributionDate.getContributionYear());
        return !(validMonth && validYear);
    }

    private boolean isValidYear(final Integer year) {
        return year >= 2001;
    }

    private boolean isValidMonth(final Integer month) {
        return month > 0 && month <= 12;
    }

    private DateTime contributionDateToDateTime(final ContributionDate contributionDate, final DateTime now) {
        return getNow()
                .withYear(contributionDate.getContributionYear())
                .withMonthOfYear(contributionDate.getContributionMonth())
                .withDayOfMonth(now.getDayOfMonth());
    }

    private boolean containsNullValue(final ContributionDate contributionDate) {
        return contributionDate == null || contributionDate.getContributionMonth() == null || contributionDate.getContributionYear() == null;
    }

    public DateTime getNow() {
        return DateTime.now();
    }
}
