package com.nhsbsa.model.validaton;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Mark Lishman on 26/08/2016.
 */

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = DateLessThan31DaysFromTodayValidator.class)
@Documented
@ReportAsSingleViolation
public @interface DateLessThan31DaysFromToday {

    String message() default "{transferDate.greaterThan31Days}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
