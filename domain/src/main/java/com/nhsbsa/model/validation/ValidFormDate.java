package com.nhsbsa.model.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

@Target( { TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidFormDateValidator.class)
@Documented
public @interface ValidFormDate {

    String message() default "{validation.validFormDate}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
