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
@Table(name = "adjustment")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Adjustment extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adj_id", insertable = false, updatable = false)
    private Long id;

    private int contributionMonth;
    private int contributionYear;
    private BigDecimal employeeContributions;
    private BigDecimal employeeAddedYears;
    private BigDecimal additionalPension;
    private BigDecimal errbo;
    private BigDecimal employerContributions;
}
