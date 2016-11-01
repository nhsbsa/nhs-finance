package com.nhsbsa.service.authentication.impl;

import com.nhsbsa.model.EmployingAuthorityAdmin;
import com.nhsbsa.security.LoginRequest;
import com.nhsbsa.service.EmployingAuthorityAdminService;
import com.nhsbsa.service.authentication.AuthenticationService;
import com.nhsbsa.service.authentication.AuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by jeffreya on 22/08/2016.
 * EmployerAuthenticationService
 */

@Slf4j
@Service
public class EmployerAuthenticationService implements AuthenticationService<EmployingAuthorityAdmin> {

    private final EmployingAuthorityAdminService employingAuthorityAdminService;

    private final AuthorizationService authorizationService;

    @Autowired
    public EmployerAuthenticationService(final EmployingAuthorityAdminService employingAuthorityAdminService,
                                         final AuthorizationService authorizationService) {
        this.employingAuthorityAdminService = employingAuthorityAdminService;
        this.authorizationService = authorizationService;
    }

    @Override
    public EmployingAuthorityAdmin authenticateUser(final LoginRequest loginRequest) {
        return employingAuthorityAdminService.loadByUuid(loginRequest.getUuid());
    }

    @Override
    public EmployingAuthorityAdmin resetPassword(final LoginRequest loginRequest) {
        return null;
    }
}
