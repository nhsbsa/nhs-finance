package com.nhsbsa.model;

import com.nhsbsa.model.validation.*;
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
@EmployeeContributionThreshold(groups = ContributionsValidationGroup.class)
@EmployerContributionThreshold(groups = ContributionsValidationGroup.class)
public class RequestForTransfer extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rft_id", insertable = false, updatable = false)
    private Long id;

    @Valid
    @Convert(converter = TransferFormDateConverter.class)
    private TransferFormDate transferDate = TransferFormDate.builder().build();

    @NotNull(message = "{isGp.notNull}", groups = SchedulePaymentValidationGroup.class)
    private Boolean isGp;

    @Valid
    @Embedded
    private ContributionDate contributionDate = ContributionDate.builder().build();

    @Currency
    @NotNull(message = "{totalPensionablePay.notNull}", groups = ContributionsValidationGroup.class)
    private BigDecimal totalPensionablePay;

    @Currency
    @NotNull(message = "{employeeContributions.notNull}", groups = ContributionsValidationGroup.class)
    private BigDecimal employeeContributions;

    @Currency
    @NotNull(message = "{employerContributions.notNull}", groups = ContributionsValidationGroup.class)
    private BigDecimal employerContributions;

    @Currency
    private BigDecimal employeeAddedYears;

    @Currency
    private BigDecimal additionalPension;

    @Currency
    private BigDecimal errbo;

    // Nothing in story about validating the Total Amount To Be Debited so commented out for now.
    // @Currency
    private BigDecimal totalDebitAmount;

    private Date receiveDate = new Date();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "rft_id")
    private List<Adjustment> adjustmentList;

    private String rftUuid;


}