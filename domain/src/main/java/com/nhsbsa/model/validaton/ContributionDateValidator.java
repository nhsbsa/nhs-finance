package com.nhsbsa.model.validaton;


import com.nhsbsa.model.ContributionDate;
import org.apache.tomcat.jni.Local;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
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

        final LocalDateTime now = getNow();
        final LocalDateTime advanceLimitDate = now.plusMonths(monthsInAdvanceLimit);
        final LocalDateTime dateEntered = advanceLimitDate
                .withYear(contributionDate.getContributionYear())
                .withMonth(contributionDate.getContributionMonth());

        Months.

        final int months = Period.between(dateEntered.toLocalDate(), advanceLimitDate.toLocalDate()).getMonths();
        if (months <= monthsInAdvanceLimit) {
            return true;
        }

        return true;
    }

    private boolean checkForNull(final ContributionDate contributionDate) {
        return contributionDate.getContributionMonth() == null || contributionDate.getContributionYear() == null;
    }

    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
