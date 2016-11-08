package com.nhsbsa.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
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

    // TODO pick up converter globally

    @Valid
    @Convert(converter = FormDateConverter.class)
    private TransferFormDate transferDate = new TransferFormDate();

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

    @Valid
    @Convert(converter = FormDateConverter.class)
    private FormDate receiveDate = new FormDate();

    @OneToMany()
    @JoinColumn(name = "rft_id")
    private List<Adjustment> adjustmentList;

}
