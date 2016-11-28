package com.nhsbsa.model;

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
    @Currency
    private BigDecimal employeeContributions;
    private BigDecimal employeeAddedYears;
    private BigDecimal additionalPension;
    private BigDecimal errbo;
    private BigDecimal employerContributions;

}
