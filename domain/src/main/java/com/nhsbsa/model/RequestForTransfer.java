package com.nhsbsa.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    // TODO pick up converter globally

    @Valid
    @Convert(converter = FormDateConverter.class)
    private TransferFormDate transferDate = new TransferFormDate();

    @NotNull(message = "{isGp.notNull}")
    private Boolean isGp;

    @Range(min = 1, max = 12, message = "{contributionMonth.valid}")
    @NotNull(message = "{contributionMonth.notBlank}")
    private Integer contributionMonth;

    @Range(min = 2001, max = 9999, message = "{contributionYear.valid}")
    @NotNull(message = "{contributionYear.notBlank}")
    private Integer contributionYear;

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
