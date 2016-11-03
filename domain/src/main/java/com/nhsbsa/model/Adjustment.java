package com.nhsbsa.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    @Column(name="adj_contribution_month")
    private int contributionMonth;

    @Column(name="adj_contribution_year")
    private int contributionYear;

    @Column(name="adj_employee_contributions")
    private BigDecimal employeeContributions;

    @Column(name="adj_employee_added_years")
    private BigDecimal employeeAddedYears;

    @Column(name="adj_additional_pension")
    private BigDecimal additionalPension;

    @Column(name="adj_errbo")
    private BigDecimal errbo;

    @Column(name="adj_employer_contributions")
    private BigDecimal employerContributions;

}
