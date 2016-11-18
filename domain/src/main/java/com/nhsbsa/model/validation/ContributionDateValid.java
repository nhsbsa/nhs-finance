package com.nhsbsa.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by
 */

@Target( { TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ContributionDateValidator.class)
@Documented
public @interface ContributionDateValid {

    String message() default "{formDate.notBlank}";

    int monthsInAdvanceLimit() default 2;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
