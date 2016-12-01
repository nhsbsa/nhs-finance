package com.nhsbsa.model.validation;

import com.nhsbsa.model.Adjustment;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nat Hulse 01/12/2016
 */
public class AdjustmentNotNullValidator implements ConstraintValidator<AdjustmentNotNull, Adjustment> {

    public void initialize(AdjustmentNotNull constraint) {
    }

    public final boolean isValid(final Adjustment adjustment,
        final ConstraintValidatorContext context) {

        // If All of the adjustment values are null return Validation message
        if (adjustment.getEmployeeContributions() == null && adjustment.getEmployerContributions() == null &&
                adjustment.getEmployeeAddedYears() == null && adjustment.getAdditionalPension() == null && adjustment.getErrbo() == null)
            return false;

        // All ok, return true
        return true;
    }
}