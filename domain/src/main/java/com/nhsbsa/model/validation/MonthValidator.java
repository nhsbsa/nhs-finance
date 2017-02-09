package com.nhsbsa.model.validation;

import com.nhsbsa.model.ContributionDate;
import com.nhsbsa.model.MonthNum;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MonthValidator implements ConstraintValidator<ContributionDateValid, ContributionDate> {

    @Value("${contributionDate.not.valid}")
    private String monthNotValid = "placeholder";
    private MonthNum monthNum = new MonthNum();

    @Override
    public void initialize(ContributionDateValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(ContributionDate contributionDate, ConstraintValidatorContext context) {
        return containsinvalidMonth(contributionDate, context);
    }

    private boolean containsinvalidMonth(final ContributionDate contributionDate, final ConstraintValidatorContext context) {
        final String monthEntered = contributionDate.getContributionMonth();
        final int monthNumber = monthNum.getMonthNumFromName(monthEntered);

            if(monthNumber != 0)
                return false;

        context.buildConstraintViolationWithTemplate(
                monthNotValid.replace("$", ""))
                .addConstraintViolation();
        return true;
    }

}