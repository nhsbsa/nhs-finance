package com.nhsbsa.model.validaton;

/**
 * Created by
 */

import com.nhsbsa.model.ContributionDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class ContributionDateValidator implements ConstraintValidator<FormDateNotBlank, ContributionDate> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void initialize(FormDateNotBlank constraintAnnotation) {
    }

    @Override
    public boolean isValid(ContributionDate contributionDate, ConstraintValidatorContext context) {


        if (checkForNull(contributionDate)) return false;

        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime twoMonthsFromNow = now.withDayOfMonth(now.getMonthValue() + 2);
        //new LocalDateTime().with

        return true;
    }

    private boolean checkForNull(ContributionDate contributionDate) {
        if (contributionDate.getContributionMonth() == null || contributionDate.getContributionYear() == null) {
            return true;

        }
        return false;
    }
}
