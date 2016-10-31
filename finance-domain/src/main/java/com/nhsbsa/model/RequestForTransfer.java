package com.nhsbsa.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mark Lishman on 31/10/2016.
 */
@Data
@Builder
@Entity
@Table(name = "account")
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

    private int contributionMonth;

    private int contributionYear;

    private BigDecimal totalPensionablePay;

    private BigDecimal employeeContributions;

    private BigDecimal employeeAddedYears;

    private BigDecimal additionalPension;

    private BigDecimal errbo;

    private BigDecimal employerContributions;

    private BigDecimal totalDebitAmount;

    private Date receivedDate;
}
