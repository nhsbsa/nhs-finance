package com.nhsbsa.model.validation;

import com.nhsbsa.model.RequestForTransfer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * Created by Mark Lishman on 18/11/2016.
 */
public class EmployerContributionThresholdValidator implements ConstraintValidator<EmployerContributionThreshold, RequestForTransfer> {

   private static final BigDecimal MINIMUM_PERCENT = new BigDecimal("0.14");

   public void initialize(EmployerContributionThreshold constraint) {
   }

   public boolean isValid(RequestForTransfer rft, ConstraintValidatorContext context) {
      if (rft.getTotalPensionablePay() == null || rft.getEmployerContributions() == null) {
         return true;
      }
      final BigDecimal minimumValue = rft.getTotalPensionablePay().multiply(MINIMUM_PERCENT);
      return rft.getEmployerContributions().compareTo(minimumValue) >= 0;
   }
}
