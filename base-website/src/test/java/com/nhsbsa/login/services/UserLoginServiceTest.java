package com.nhsbsa.login.services;

import com.nhsbsa.login.exceptions.LoginAuthenticationException;
import com.nhsbsa.login.exceptions.UserNotFoundAuthenticationException;
import com.nhsbsa.security.LoginRequest;
import org.junit.Test;


/**
 * Created by jeffreya on 24/10/2016.
 *
 */

public class UserLoginServiceTest {

    private static final UserLoginService USER_LOGIN = new UserLoginService(null);

    private static final UserLoginService USER_LOGIN_SERVICE = new UserLoginService(new AuthorizationService(null) {
        @Override
        public String authenticate(LoginRequest loginRequest) {
            return null;
        }
    });

    @Test(expected = LoginAuthenticationException.class)
    public void financeUserLoginNoCredentials() throws Exception {
        USER_LOGIN.financeLogin(null, null);
    }
    @Test(expected = LoginAuthenticationException.class)
    public void financeUserLoginBlankUserCredentials() throws Exception {
        USER_LOGIN.financeLogin("", null);
    }

    @Test(expected = LoginAuthenticationException.class)
    public void financeUserLoginBlankPswCredentials() throws Exception {
        USER_LOGIN.financeLogin(null, "");
    }

    @Test(expected = LoginAuthenticationException.class)
    public void financeUserLoginBlankCredentials() throws Exception {
        USER_LOGIN.financeLogin("", "");
    }

    @Test(expected = UserNotFoundAuthenticationException.class)
    public void financeUserNotFound() throws Exception {
        USER_LOGIN_SERVICE.financeLogin("abc", "123");
    }

}