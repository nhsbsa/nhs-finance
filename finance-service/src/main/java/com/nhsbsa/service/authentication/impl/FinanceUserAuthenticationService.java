package com.nhsbsa.service.authentication.impl;

import com.nhsbsa.model.EmployingAuthorityAdmin;
import com.nhsbsa.model.FinanceUser;
import com.nhsbsa.security.LoginRequest;
import com.nhsbsa.service.authentication.AuthenticationService;
import com.nhsbsa.service.authentication.AuthorizationService;
import controllers.FinanceUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by jeffreya on 22/08/2016.
 * EmployerAuthenticationService
 */

@Slf4j
@Service
public class FinanceUserAuthenticationService implements AuthenticationService<FinanceUser> {

    private final FinanceUserRepository financeUserRepository;

    private final AuthorizationService authorizationService;

    @Autowired
    public FinanceUserAuthenticationService(final FinanceUserRepository financeUserRepository,
                                            final AuthorizationService authorizationService) {
        this.financeUserRepository = financeUserRepository;
        this.authorizationService = authorizationService;
    }

    @Override
    public FinanceUser authenticateUser(final LoginRequest loginRequest) {
        return financeUserRepository.findByUuid(loginRequest.getUuid());
    }

    @Override
    public FinanceUser resetPassword(final LoginRequest loginRequest) {
        return null;
    }
}
