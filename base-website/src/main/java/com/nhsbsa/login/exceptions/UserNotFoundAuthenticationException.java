package com.nhsbsa.login.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by jeffreya on 24/10/2016.
 *
 */

public class UserNotFoundAuthenticationException extends AuthenticationException {

    private static final String NOT_A_VALID_USER = "Not a valid user";

    public UserNotFoundAuthenticationException() {
        super(NOT_A_VALID_USER, null);
    }
}