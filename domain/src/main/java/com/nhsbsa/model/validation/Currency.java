package com.nhsbsa.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Mark Lishman on 17/11/2016.
 *
 * Annotation @Currency is used around the class member
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CurrencyValidator.class)
@Documented
@ReportAsSingleViolation
public @interface Currency {

    String message() default "{contsAndPayments.currencyRange}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
