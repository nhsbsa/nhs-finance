package com.nhsbsa.controllers;

import com.nhsbsa.model.FinanceUser;
import com.nhsbsa.security.LoginRequest;
import com.nhsbsa.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by jeffreya on 16/08/2016.
 *
 */

@RequestMapping("/finance")
@RestController
public class FinanceUserController {

    private final AuthenticationService<FinanceUser> financeUserAuthenticationService;

    @Autowired
    public FinanceUserController(final AuthenticationService<FinanceUser> financeUserAuthenticationService) {
        this.financeUserAuthenticationService = financeUserAuthenticationService;
    }

    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public ResponseEntity<FinanceUser> login(@RequestBody @Valid final LoginRequest loginRequest,
                                             final HttpServletRequest httpServletRequest) {
        final FinanceUser authenticateUser = financeUserAuthenticationService.authenticateUser(loginRequest);
        return ResponseEntity.ok(authenticateUser);
    }
}