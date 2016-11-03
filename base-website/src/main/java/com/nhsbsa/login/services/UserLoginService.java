package com.nhsbsa.login.services;

import com.nhsbsa.login.exceptions.LoginAuthenticationException;
import com.nhsbsa.model.FinanceUser;
import com.nhsbsa.security.LoginRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeffreya on 24/10/2016.
 *
 */

@Service
public class UserLoginService {


    private final AuthorizationService authorizationService;

    @Autowired
    public UserLoginService(final AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    private void areCredentialsPresent(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new LoginAuthenticationException();
        }
    }

    private LoginRequest buildAuthenticationRequest(String username, String password) {
        return LoginRequest.builder()
                .username(username)
                .password(password)
                .build();
    }

    public FinanceUser financeLogin(final String username, final String password) {
        areCredentialsPresent(username, password);
        final LoginRequest loginRequest = buildAuthenticationRequest(username, password);
        return authorizationService.getFinanceLogin(loginRequest);
    }
}
