package com.nhsbsa.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Natalie Hulse 24/11/2016
 */

@Target( { TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = AdjustmentContributionDateValidator.class)
@Documented
public @interface AdjustmentContributionDateValid {

    String message() default "";

    int monthsInAdvanceLimit() default 2;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
