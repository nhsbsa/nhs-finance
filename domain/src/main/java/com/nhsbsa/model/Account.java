package com.nhsbsa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @Column(name = "account_id", insertable = false, updatable = false)
    private Long id;
    private String accountNumber;
    private String accountName;
    private String eaReference;

    @OneToMany()
    @JoinColumn(name = "account_id")
    private List<RequestForTransfer> requestForTransferList;

}
