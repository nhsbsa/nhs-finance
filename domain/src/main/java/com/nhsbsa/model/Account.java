package com.nhsbsa.model;

import lombok.*;

import javax.persistence.*;

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
public class Account extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id", insertable = false, updatable = false)
    private Long id;

    @Column(name = "acc_number")
    private String number;

    @Column(name = "acc_name")
    private String name;

    @Column(name = "ea_ref")
    private String eaReference;

}
