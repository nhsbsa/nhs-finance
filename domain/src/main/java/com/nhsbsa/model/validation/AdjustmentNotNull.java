package com.nhsbsa.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Natalie Hulse 01/12/2016
 *
 * Annotation @AdjustmentNotNull is used around the class
 */
@Target({ TYPE  })
@Retention(RUNTIME)
@Constraint(validatedBy = AdjustmentNotNullValidator.class)
@Documented
@ReportAsSingleViolation
public @interface AdjustmentNotNull {

    String message() default "{adjustment.notBlank }";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
