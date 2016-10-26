package com.nhsbsa.service.authentication;

import com.nhsbsa.service.BackendApiUriService;
import com.nhsbsa.service.BackendUri;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jeffreya on 19/08/2016.
 *
 */
@Log4j
@Service
public class FinanceAuthenticationService {

    private static final String ENDPOINT = "member/authentication/login";
    private static final String NOT_A_VALID_USER = "not a valid user";
    private final BackendUri backendUri;
    private final RestTemplate restTemplate;

    @Autowired
    public FinanceAuthenticationService(final BackendApiUriService backendApiUriService,
                                        final RestTemplate restTemplate) {
        this.backendUri = backendApiUriService.path(ENDPOINT);
        this.restTemplate = restTemplate;
    }

    public Authentication getUser(final String name, final String password) {
//        final AuthenticationRequest authenticationRequest = AuthenticationRequest.builder()
//                .username(name)
//                .password(password)
//                .build();
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

        throw new AuthenticationException(NOT_A_VALID_USER) {
        };
    }
}
