package com.nhsbsa.model;

import com.nhsbsa.model.validaton.ContributionsValidationGroup;
import com.nhsbsa.model.validaton.Currency;
import com.nhsbsa.model.validaton.SchedulePaymentValidationGroup;
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
    @Convert(converter = TransferFormDateConverter.class)
    private TransferFormDate transferDate = new TransferFormDate();

    @NotNull(message = "{isGp.notNull}", groups = SchedulePaymentValidationGroup.class)
    private Boolean isGp;

    @Valid
    @Embedded
    private ContributionDate contributionDate = ContributionDate.builder().build();

    /* TODO implement Currency

        - Allow (optional) range to be entered.
        - Provide default range in annotation.`
        - Null value is valid (use @NotNull to define optional / mandatory)

        See examples below

     */

    @Currency
//    @NotNull(groups = ContributionsValidationGroup.class)
    private BigDecimal totalPensionablePay;

    @Currency(min = "0", max = "99999")
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
