package com.nhsbsa.model.validaton;

/**
 * Created by
 */

import com.nhsbsa.model.ContributionDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.Period;

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

        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime advanceLimitDate = now.plusMonths(monthsInAdvanceLimit);
        final int months = Period.between(now.toLocalDate(), advanceLimitDate.toLocalDate()).getMonths();
        if (months <= monthsInAdvanceLimit) {
            return true;
        }

        return true;
    }

    private boolean checkForNull(final ContributionDate contributionDate) {
        return contributionDate.getContributionMonth() == null || contributionDate.getContributionYear() == null;
    }
}
