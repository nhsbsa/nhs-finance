package com.nhsbsa.login.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by jeffreya on 24/10/2016.
 *
 */

public class LoginAuthenticationException extends AuthenticationException {

    private static final String NOT_A_VALID_USER = "Blank login credentials";

    public LoginAuthenticationException() {
        super(NOT_A_VALID_USER, null);
    }
}