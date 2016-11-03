package com.nhsbsa.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Mark Lishman on 31/10/2016.
 */
@Data
@Builder
@Entity
@Table(name = "request_for_transfer")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RequestForTransfer extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rft_id", insertable = false, updatable = false)
    private Long id;

    private Date transferDate;

    private boolean isGp;

    @Column(name="rft_contribution_month")
    private int contributionMonth;

    @Column(name="rft_contribution_year")
    private int contributionYear;

    @Column(name="rft_total_pensionable_pay")
    private BigDecimal totalPensionablePay;

    @Column(name="rft_employee_contributions")
    private BigDecimal employeeContributions;

    @Column(name="rft_employee_added_years")
    private BigDecimal employeeAddedYears;

    @Column(name="rft_additional_pension")
    private BigDecimal additionalPension;

    @Column(name="rft_errbo")
    private BigDecimal errbo;

    @Column(name="rft_employer_contributions")
    private BigDecimal employerContributions;

    @Column(name="rft_total_debit_amount")
    private BigDecimal totalDebitAmount;

    private Date receivedDate;

    @OneToMany()
    @JoinColumn(name = "rft_id")
    private List<Adjustment> adjustmentList;

}
