package com.nhsbsa.service;

import com.nhsbsa.controllers.EmployingAuthorityAdminRepository;
import com.nhsbsa.model.EmployingAuthorityAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployingAuthorityAdminService {

    private EmployingAuthorityAdminRepository employingAuthorityAdminRepository;

    @Autowired
    public EmployingAuthorityAdminService(final EmployingAuthorityAdminRepository employingAuthorityAdminRepository) {
        this.employingAuthorityAdminRepository = employingAuthorityAdminRepository;
    }

    public EmployingAuthorityAdmin loadByName(final String username) {
        return employingAuthorityAdminRepository.findByUsername(username);
    }

    public EmployingAuthorityAdmin loadByUuid(final String uuid) {
        return employingAuthorityAdminRepository.findByUuid(uuid);
    }
}
