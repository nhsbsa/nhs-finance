package com.nhsbsa.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "{transferDate.notBlank}")
    private TransferFormDate transferDate = new TransferFormDate();
  //  @NotBlank(message = "{isGp.notBlank}")
    private boolean isGp;
    @NotNull (message = "{contributionMonth.notBlank}")
    private int contributionMonth;
    @NotNull (message = "{contributionYear.notBlank}")
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
