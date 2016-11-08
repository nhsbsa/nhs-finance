package com.nhsbsa.model.validaton;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidFormDateValidator implements ConstraintValidator<ValidFormDate, FormDateValidator> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void initialize(ValidFormDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(FormDateValidator formDateValidator, ConstraintValidatorContext context) {

        try {
            DATE_FORMAT.parse("11/11/2016");
            return true;
        } catch (ParseException e) {
            // invalid
        }
        return false;
    }

}
