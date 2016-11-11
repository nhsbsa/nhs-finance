package com.nhsbsa.model.validaton;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

import com.nhsbsa.model.FormDate;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidFormDateValidator implements ConstraintValidator<ValidFormDate, FormDate> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void initialize(ValidFormDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(FormDate formDateValidator, ConstraintValidatorContext context) {

        if (StringUtils.isEmpty(formDateValidator.getDays()) &&
                StringUtils.isEmpty(formDateValidator.getMonth()) &&
                StringUtils.isEmpty(formDateValidator.getYear())) {
            return true;
        }

        String date = formDateValidator.getDays() + "/" + formDateValidator.getMonth() + "/" + formDateValidator.getYear();

        try {
            DATE_FORMAT.setLenient(false);
            DATE_FORMAT.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }



}
