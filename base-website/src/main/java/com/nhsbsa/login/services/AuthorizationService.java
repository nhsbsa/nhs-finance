package com.nhsbsa.login.services;

import com.nhsbsa.login.exceptions.UserNotFoundAuthenticationException;
import com.nhsbsa.model.FinanceUser;
import com.nhsbsa.security.AuthenticationResponse;
import com.nhsbsa.security.LoginRequest;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jeffreya on 24/10/2016.
 */

@Log4j
@Service
public class AuthorizationService {

    private final RestTemplate restTemplate;

    @Value("${authorization.authenticate.url}")
    private String authorizationBackendUri;

    @Value("${finance.authenticate.url}")
    private String financeAuthUrl;


    @Autowired
    protected AuthorizationService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String authenticate(final LoginRequest loginRequest) {
        return getUuid(loginRequest);
    }

    public FinanceUser getFinanceLogin(final LoginRequest loginRequest) {
        setUuidIfPresent(loginRequest);
        return restTemplate.postForObject(financeAuthUrl, loginRequest, FinanceUser.class);
    }

    private void setUuidIfPresent(LoginRequest loginRequest) {
        final String uuid = authenticate(loginRequest);
        isUUIDPresent(uuid);
        loginRequest.setUuid(uuid);
    }

    private String getUuid(final LoginRequest loginRequest) {
        try {
            final AuthenticationResponse authenticationResponse =
                    restTemplate.postForObject(authorizationBackendUri, loginRequest, AuthenticationResponse.class);
            return authenticationResponse.getUuid();
        } catch (Throwable e) {
            log.error(e);
        }
        log.error("Failed to authenticate login request");
        return null;
    }

    private void isUUIDPresent(final String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new UserNotFoundAuthenticationException();
        }
    }


}
