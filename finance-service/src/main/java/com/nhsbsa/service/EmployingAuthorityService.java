package com.nhsbsa.service;

import com.nhsbsa.controllers.EmployingAuthorityRepository;
import com.nhsbsa.model.EmployingAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mark Lishman on 18/08/2016.
 */

@Service
public class EmployingAuthorityService {

    private EmployingAuthorityRepository employingAuthorityRepository;

    @Autowired
    public EmployingAuthorityService(final EmployingAuthorityRepository employingAuthorityRepository) {
        this.employingAuthorityRepository = employingAuthorityRepository;
    }

    public EmployingAuthority getMembers(String employingAuthorityCode) {
        return this.employingAuthorityRepository.findByCode(employingAuthorityCode);
    }
}
