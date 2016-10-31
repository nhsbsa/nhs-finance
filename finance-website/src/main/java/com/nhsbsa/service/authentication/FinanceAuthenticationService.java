package com.nhsbsa.service.authentication;

import com.nhsbsa.login.controllers.UserLoginService;
import com.nhsbsa.login.exceptions.LoginAuthenticationException;
import com.nhsbsa.model.FinanceUser;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Created by jeffreya on 19/08/2016.
 *
 */
@Log4j
@Service
public class FinanceAuthenticationService {

    private final UserLoginService userLoginService;

    @Autowired
    public FinanceAuthenticationService(final UserLoginService userLoginService ){
       this.userLoginService = userLoginService;
    }

    public Authentication getUser(final String name, final String password) {

        this.
        return null;
//
//        final String uri = this.backendUri.params();
//        try {
//            final Member member = restTemplate.postForObject(uri, authenticationRequest, Member.class);
//            if (member != null) {
//                final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(name, password, member.getAuthorities());
//                usernamePasswordAuthenticationToken.setDetails(member);
//                return usernamePasswordAuthenticationToken;
//            } else {
//                throw new AuthenticationException(NOT_A_VALID_USER) {
//                };
//            }
//        } catch (Exception e) {
//            log.error("Failed to log in", e);
//        }

        try {
            final FinanceUser financeUser = userLoginService.financeLogin(name,password);
            if (financeUser != null) {
                final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(name, password, member.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(financeUser);
                return usernamePasswordAuthenticationToken;
            } else {
                throw new LoginAuthenticationException();
            }
        } catch (Exception e) {
            log.error("Failed to log in", e);
        }

        throw new LoginAuthenticationException();


    }
}
