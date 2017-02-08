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

    @Currency(message = "{employeeContributions.invalid}")
    @NotNull(message = "{employeeContributions.notNull}", groups = ContributionsValidationGroup.class)
    private BigDecimal employeeContributions;

    @Currency
    @NotNull(message = "{employerContributions.notNull}", groups = ContributionsValidationGroup.class)
    private BigDecimal employerContributions;

    @Currency(message = "{employeeAddedYears.invalid}")
    private BigDecimal employeeAddedYears;

    @Currency(message = "{additionalPension.invalid}")
    private BigDecimal additionalPension;

    @Currency(message = "{errbo.invalid}")
    private BigDecimal errbo;

    @Transient
    @NotNull(message = "{adjustmentsRequired.notNull}", groups = ContributionsValidationGroup.class)
    private Boolean adjustmentsRequired;


    // Nothing in story about validating the Total Amount To Be Debited so commented out for now.
    // @Currency
    private BigDecimal totalDebitAmount;

    private Date receiveDate = new Date();

    // Where any adjustments are stored, table (see class definition) is "adjustment" and linked on rft_id
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "rft_id")
    @Valid
    private Adjustment adjustment;

    private String rftUuid;

    public void removeAdjustment() {
        this.adjustment = null;
    }

}