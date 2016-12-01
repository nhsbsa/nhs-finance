package com.nhsbsa.model;

import com.nhsbsa.model.validation.AdjustmentValidationGroup;
import com.nhsbsa.model.validation.Currency;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * Created by Mark Lishman on 31/10/2016.
 */
@Data
@Builder
@Entity
@Table(name = "adjustment")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Adjustment extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adj_id", insertable = false, updatable = false)
    private Long id;

    @Valid
    @Embedded
    private AdjustmentContributionDate adjustmentContributionDate = AdjustmentContributionDate.builder().build();

    @Currency(message = "{adjustment.employeeContributions.invalid}", groups = AdjustmentValidationGroup.class)
    private BigDecimal employeeContributions;

    @Currency(message = "{adjustment.employeeAddedYears.invalid}", groups = AdjustmentValidationGroup.class)
    private BigDecimal employeeAddedYears;

    @Currency(message = "{adjustment.additionalPension.invalid}", groups = AdjustmentValidationGroup.class)
    private BigDecimal additionalPension;

    @Currency(message = "{adjustment.errbo.invalid}", groups = AdjustmentValidationGroup.class)
    private BigDecimal errbo;

    @Currency(message = "{adjustment.employerContributions.invalid}", groups = AdjustmentValidationGroup.class)
    private BigDecimal employerContributions;

}
