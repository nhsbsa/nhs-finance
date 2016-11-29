package com.nhsbsa.model;

import com.nhsbsa.model.validation.ContributionsValidationGroup;
import com.nhsbsa.model.validation.Currency;
import lombok.*;

import javax.persistence.*;
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

    private int contributionMonth;
    private int contributionYear;
    private BigDecimal employeeContributions;
    private BigDecimal employeeAddedYears;
    private BigDecimal additionalPension;

    @Currency(message = "{adjustment.errbo.invalid}", groups = ContributionsValidationGroup.class)
    private BigDecimal errbo;

    @Currency(message = "{adjustment.employerContributions.invalid}", groups = ContributionsValidationGroup.class)
    private BigDecimal employerContributions;

}
