package com.nhsbsa.model;

import com.nhsbsa.model.validaton.ContributionDateValid;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Mark Lishman on 31/10/2016.
 * RequestForTransfer
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

    @Valid
    @Convert(converter = FormDateConverter.class)
    private TransferFormDate transferDate = TransferFormDate.builder().build();

    @NotNull(message = "{isGp.notNull}")
    private Boolean isGp;

    @Valid
    @Embedded
    private ContributionDate contributionDate = ContributionDate.builder().build();

    private BigDecimal totalPensionablePay;
    private BigDecimal employeeContributions;
    private BigDecimal employeeAddedYears;
    private BigDecimal additionalPension;
    private BigDecimal errbo;
    private BigDecimal employerContributions;
    private BigDecimal totalDebitAmount;
    private Date receiveDate = new Date();

    @OneToMany()
    @JoinColumn(name = "rft_id")
    private List<Adjustment> adjustmentList;

}
