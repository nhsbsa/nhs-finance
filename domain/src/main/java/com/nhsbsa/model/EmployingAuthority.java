package com.nhsbsa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mark Lishman on 7/11/2016.
 */

@Data
@Entity
@Table(name="employing_authority")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(of = {"id"})
public class EmployingAuthority extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_auth_id", insertable=false, updatable=false)
    private Long id;

    private String reference;
    private String name;

    @OneToMany()
    @JoinColumn(name = "emp_auth_id")
    private List<Account> accountList;

    @OneToMany()
    @JoinColumn(name = "emp_auth_id")
    private List<RequestForTransfer> requestForTransferList;

}
