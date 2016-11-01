package com.nhsbsa.service.authentication.impl;

import com.nhsbsa.model.FinanceUser;
import com.nhsbsa.security.LoginRequest;
import com.nhsbsa.service.authentication.AuthenticationService;
import com.nhsbsa.service.authentication.AuthorizationService;
import repository.FinanceUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.FinanceUserService;


/**
 * Created by jeffreya on 22/08/2016.
 * EmployerAuthenticationService
 */

@Slf4j
@Service(value = "financeUserAuthenticationService")
public class FinanceUserAuthenticationService implements AuthenticationService<FinanceUser> {

    private final FinanceUserService financeUserService;

    private final AuthorizationService authorizationService;

    @Autowired
    public FinanceUserAuthenticationService(final FinanceUserService financeUserService,
                                            final AuthorizationService authorizationService) {
        this.financeUserService = financeUserService;
        this.authorizationService = authorizationService;
    }

    @Override
    public FinanceUser authenticateUser(final LoginRequest loginRequest) {
        return financeUserService.findByUuid(loginRequest.getUuid());
    }

    @Override
    public FinanceUser resetPassword(final LoginRequest loginRequest) {
        return null;
    }
}
