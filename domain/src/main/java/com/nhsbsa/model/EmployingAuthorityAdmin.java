package com.nhsbsa.model;

/*
  Created by Mark Lishman on 31/10/2016.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Builder
@Entity
@Table(name = "emp_auth_admin")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmployingAuthorityAdmin extends BaseEntity<Long> implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_hist_auth_id", insertable = false, updatable = false)
    private Long id;

    private String username;

    private String uuid;

    private String contactName;

    private String contactTelephone;

    private String contactEmail;

    @OneToOne
    @JoinColumn(name = "acc_id")
    private Account account;

    @Transient
    private static final String ROLE = "ROLE_USER";

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(ROLE));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return recStatus == 1;
    }

    @Override
    public String getPassword() {
        return "";
    }
}
