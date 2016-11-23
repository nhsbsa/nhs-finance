package com.nhsbsa.service.authentication;

import com.nhsbsa.login.exceptions.LoginAuthenticationException;
import com.nhsbsa.login.services.UserLoginService;
import com.nhsbsa.model.FinanceUser;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Created by jeffreya on 19/08/2016.
 * FinanceAuthenticationService
 */

@Log4j
@Service
public class FinanceAuthenticationService {

    private final UserLoginService userLoginService;

    @Autowired
    public FinanceAuthenticationService(final UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    public Authentication getUser(final String name, final String password) {
        log.debug("Login request started for user: " + name);
        try {
            final FinanceUser financeUser = userLoginService.financeLogin(name, password);
            if (financeUser != null) {
                final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(name, password, financeUser.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(financeUser);
                return usernamePasswordAuthenticationToken;
            } else {
                throw new LoginAuthenticationException();
            }
        } catch (LoginAuthenticationException e) {
            log.error(e);
            throw new LoginAuthenticationException();
        } finally {
            log.debug("Login request ended for user: " + name);
        }
    }
}
