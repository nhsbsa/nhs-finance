package com.nhsbsa.security;

import com.nhsbsa.model.FinanceUser;
import com.nhsbsa.service.authentication.FinanceAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by jeffreya on 19/08/2016.
 */

@Component
public class FinanceAuthenticationProvider implements AuthenticationProvider {

    @Value("${use.member.mocked.login:false}")
    private boolean mockLogin = false;


    private final FinanceAuthenticationService memberAuthenticationService;

    @Autowired
    public FinanceAuthenticationProvider(final FinanceAuthenticationService memberAuthenticationService) {
        this.memberAuthenticationService = memberAuthenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        return getAuthentication(name, password);
    }

    private Authentication getAuthentication(final String name, final String password) {
        return mockLogin ? getMockedAuthentication(name, password) : memberAuthenticationService.getUser(name, password);
    }

    private Authentication getMockedAuthentication(final String name, final String password) {
        if ("invalid" .equals(password)) {
            throw new AuthenticationException("not a valid user") {
            };
        }
        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        usernamePasswordAuthenticationToken.setDetails(FinanceUser.builder().build());
        return usernamePasswordAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}