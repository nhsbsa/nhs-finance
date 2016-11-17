package com.nhsbsa.model.validaton;


import com.nhsbsa.model.ContributionDate;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContributionDateValidator implements ConstraintValidator<ContributionDateValid, ContributionDate> {


    private int monthsInAdvanceLimit;

    @Value("${contributionDate.not.valid}")
    private String contributionDateNotValid;

    @Value("${contributionDate.not.in.range}")
    private String contributionDateNotInRange;

    @Override
    public void initialize(ContributionDateValid constraintAnnotation) {
        monthsInAdvanceLimit = constraintAnnotation.monthsInAdvanceLimit();
    }

    @Override
    public boolean isValid(ContributionDate contributionDate, ConstraintValidatorContext context) {
        return !(containsInvalidData(contributionDate, context) || containsInvalidDate(contributionDate, context));
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
        final boolean isDataInvalid = containsNullValue(contributionDate) || containsInvalidValue(contributionDate);
        if (isDataInvalid) {
            context.buildConstraintViolationWithTemplate(contributionDateNotValid.replace("$", ""))
                    .addConstraintViolation();
        }
        return isDataInvalid;
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
