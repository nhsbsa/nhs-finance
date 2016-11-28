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
 * Created by Natalie Hulse 25/11/2016
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CurrencyValidator.class)
@Documented
@ReportAsSingleViolation
public @interface AdjustmentCurrency {

    String message() default "{contsAndPayments.adjustmentCurrencyRange}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
