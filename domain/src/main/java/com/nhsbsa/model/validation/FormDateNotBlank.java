package com.nhsbsa.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

@Target( { TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = FormDateNotBlankValidator.class)
@Documented
public @interface FormDateNotBlank {

    String message() default "{formDate.notBlank}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
