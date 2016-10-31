package com.nhsbsa.login;

import com.nhsbsa.login.controllers.UserLoginService;
import com.nhsbsa.login.exceptions.LoginAuthenticationException;
import org.junit.Test;


/**
 * Created by jeffreya on 24/10/2016.
 *
 */

public class UserLoginServiceTest {

    private static final UserLoginService USER_LOGIN = new UserLoginService(null);

    @Test(expected = LoginAuthenticationException.class)
    public void memberLoginNoCredentials() throws Exception {
        USER_LOGIN.financeLogin(null, null);
    }

    @Test(expected = LoginAuthenticationException.class)
    public void memberLoginBlankUserCredentials() throws Exception {
        USER_LOGIN.financeLogin("", null);
    }

    @Test(expected = LoginAuthenticationException.class)
    public void memberLoginBlankPswCredentials() throws Exception {
        USER_LOGIN.financeLogin(null, "");
    }

    @Test(expected = LoginAuthenticationException.class)
    public void memberLoginBlankCredentials() throws Exception {
        USER_LOGIN.financeLogin("", "");
    }

}