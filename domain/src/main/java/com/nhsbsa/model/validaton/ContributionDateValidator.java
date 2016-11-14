package com.nhsbsa.model.validaton;


import com.nhsbsa.model.ContributionDate;
import org.joda.time.DateTime;
import org.joda.time.Months;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContributionDateValidator implements ConstraintValidator<ContributionDateValid, ContributionDate> {


    private int monthsInAdvanceLimit;

    @Override
    public void initialize(ContributionDateValid constraintAnnotation) {
        monthsInAdvanceLimit = constraintAnnotation.monthsInAdvanceLimit();
    }

    @Override
    public boolean isValid(ContributionDate contributionDate, ConstraintValidatorContext context) {

        if (checkForNull(contributionDate)) {
            return false;
        }

        final DateTime now = getNow();
        final DateTime advanceLimitDate = now.plusMonths(monthsInAdvanceLimit);
        final DateTime dateEntered = contributionDateToDateTime(contributionDate, now);

        final int months = Months.monthsBetween(dateEntered, advanceLimitDate).getMonths();
        return months >= 0;
    }

    private DateTime contributionDateToDateTime(final ContributionDate contributionDate, final DateTime now) {
        return getNow()
                .withYear(contributionDate.getContributionYear())
                .withMonthOfYear(contributionDate.getContributionMonth())
                .withDayOfMonth(now.getDayOfMonth());
    }

    private boolean checkForNull(final ContributionDate contributionDate) {
        return contributionDate == null || contributionDate.getContributionMonth() == null || contributionDate.getContributionYear() == null;
    }

    public DateTime getNow() {
        return DateTime.now();
    }
}
