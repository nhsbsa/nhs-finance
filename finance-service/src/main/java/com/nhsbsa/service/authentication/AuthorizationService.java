package com.nhsbsa.service.authentication;

import com.nhsbsa.rest.RestAuthentication;
import com.nhsbsa.security.AppToken;
import com.nhsbsa.security.LoginRequest;
import com.nhsbsa.security.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jeffreya on 30/09/2016.
 * AuthorizationService
 */

@Service
public class AuthorizationService {

    private final RestAuthentication restAuthentication;

    private final RestTemplate restTemplate;

    @Value("${authorization.authenticate.url}")
    private String authorizationBackendUri;

    public AuthorizationService(final RestAuthentication restAuthentication, final RestTemplate restTemplate) {
        this.restAuthentication = restAuthentication;
        this.restTemplate = restTemplate;
    }

    public String getUuid(final LoginRequest loginRequest) {
        final AppToken appToken = loginRequest.getAppToken();
        final HttpEntity<LoginRequest> requestWithAppToken = restAuthentication.createRequestWithAppToken(appToken, loginRequest);
        final AuthenticationResponse authenticationResponse = restTemplate.postForObject(authorizationBackendUri, requestWithAppToken, AuthenticationResponse.class);
        return authenticationResponse.getUuid();
    }

}
