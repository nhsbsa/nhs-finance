package com.nhsbsa.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Mark Lishman on 26/08/2016.
 */

@Target({ TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EmployeeContributionThresholdValidator.class)
@Documented
@ReportAsSingleViolation
public @interface EmployeeContributionThreshold {

    String message() default "{employee.contribution.threshold}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
