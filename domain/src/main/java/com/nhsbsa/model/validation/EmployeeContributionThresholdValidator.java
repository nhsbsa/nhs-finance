package com.nhsbsa.model.validation;

import com.nhsbsa.model.RequestForTransfer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * Created by Mark Lishman on 18/11/2016.
 */
public class EmployeeContributionThresholdValidator implements ConstraintValidator<EmployeeContributionThreshold, RequestForTransfer> {

   private static final BigDecimal MINIMUM_PERCENT = new BigDecimal("0.05");
   private static final BigDecimal MAXIMUM_PERCENT = new BigDecimal("0.145");

   public void initialize(EmployeeContributionThreshold constraint) {
   }

   public boolean isValid(RequestForTransfer rft, ConstraintValidatorContext context) {
      if (rft.getTotalPensionablePay() == null || rft.getEmployeeContributions() == null) {
         return true;
      }
      final BigDecimal minimumValue = rft.getTotalPensionablePay().multiply(MINIMUM_PERCENT);
      final BigDecimal maximumValue = rft.getTotalPensionablePay().multiply(MAXIMUM_PERCENT);
      return rft.getEmployeeContributions().compareTo(minimumValue) >= 0 && rft.getEmployeeContributions().compareTo(maximumValue) <= 0;
   }
}
