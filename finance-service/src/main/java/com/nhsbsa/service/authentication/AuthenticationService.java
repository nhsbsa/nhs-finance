package com.nhsbsa.service.authentication;


import com.nhsbsa.security.LoginRequest;

/**
 * Created by jeffreya on 22/08/2016.
 */
public interface AuthenticationService<T> {

    T authenticateUser(final LoginRequest loginRequest);

    T resetPassword(final LoginRequest loginRequest);


}
