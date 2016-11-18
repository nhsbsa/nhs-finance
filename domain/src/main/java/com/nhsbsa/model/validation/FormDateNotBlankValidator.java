package com.nhsbsa.model.validation;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

import com.nhsbsa.model.FormDate;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

public class FormDateNotBlankValidator implements ConstraintValidator<FormDateNotBlank, FormDate> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void initialize(FormDateNotBlank constraintAnnotation) {
    }

    @Override
    public boolean isValid(FormDate formDateValidator, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(formDateValidator.getDays()) &&
                StringUtils.isEmpty(formDateValidator.getMonth()) &&
                StringUtils.isEmpty(formDateValidator.getYear())) {
            return false;
        }
        return true;
    }
}
