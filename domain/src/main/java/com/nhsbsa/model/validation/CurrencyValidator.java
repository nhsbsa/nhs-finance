package com.nhsbsa.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ianfulcher on 21/11/2016.
 * Uses @Currency annotation and does the basic validations for currency inputs, validation of
 * input characters (and before/after decimal point limitations) and maximum/minimum amount.
 * NOTE: No checking for null/blank as done elsewhere so if found valid for now.
 *
 * ConstraintValidator<@AnnotationNameUsing, ['Type' as defined in class for the member]>
 */
public class CurrencyValidator implements ConstraintValidator<Currency, BigDecimal> {


    private static final BigDecimal MINIMUM_AMOUNT = new BigDecimal("1.00");
    private static final BigDecimal MAXIMUM_AMOUNT = new BigDecimal("99999999.99");

    public final void initialize(final Currency annotation) {
    }

    public final boolean isValid(final BigDecimal amountValueBigDecimal,
        final ConstraintValidatorContext context) {

        // If null/blank then ok, not checking for this here so just return.
        if (amountValueBigDecimal == null)
            return true;

        // Validates characters entered, convert to a String for evaluation
        final String amountValueString = amountValueBigDecimal.toString();
        if (!isValidCharacters(amountValueString))
            return false;

        // Range checking now, inclusive of the Minimum/Maximum values
        if (!isValidRange(amountValueBigDecimal))
            return false;

        // All ok, return true
        return true;
    }
/*
 * Checks for valid characters in the input, numerics/decimal point and minimum/maximum length (before/after .)
 * If all ok return true
 * Invalid character/format return false
 */
    private boolean isValidCharacters(String inputAmount) {

        // It matches 1-8 digits, followed by optional: full stop, followed by 0 to 2 digits.
        final String regExp = "([0-9]{1,8})?+([.][0-9]{0,2})?";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(inputAmount);
        if(matcher.matches())
            return true;
        else
            return false;
    }
/*
 * Basic range checking, Minimum Value >= amount <= Maximum Value
 * If in range, return true
 * Outside range, return false
 */
    private boolean isValidRange(BigDecimal inputAmount) {

        if ((inputAmount.compareTo(MINIMUM_AMOUNT)) >= 0)
            if ((inputAmount.compareTo(MAXIMUM_AMOUNT)) <= 0)
                return true;
            else
                return false;
        else
            return false;

    }
}