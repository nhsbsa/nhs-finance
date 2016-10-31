package com.nhsbsa.login.controllers;

import com.nhsbsa.login.exceptions.UserNotFoundAuthenticationException;
import com.nhsbsa.login.services.AuthorizationService;
import com.nhsbsa.security.LoginRequest;
import org.junit.Test;


/**
 * Created by jeffreya on 24/10/2016.
 *
 */

public class UserLoginServiceLoginTest {

    private static final UserLoginService USER_LOGIN_SERVICE = new UserLoginService(new AuthorizationService(null) {
        @Override
        public String authenticate(LoginRequest loginRequest) {
            return null;
        }
    });

    @Test(expected = UserNotFoundAuthenticationException.class)
    public void employerUserNotFound() throws Exception {
        USER_LOGIN_SERVICE.financeLogin("abc", "123");
    }

    @Test(expected = UserNotFoundAuthenticationException.class)
    public void memberUserNotFound() throws Exception {
    }

}