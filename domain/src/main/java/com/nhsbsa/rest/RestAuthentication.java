package com.nhsbsa.rest;

import com.nhsbsa.security.AppToken;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Created by jeffreya on 28/09/2016.
 * RestAuthentication
 */

@Service
public class RestAuthentication {
    public static final String AUTH_APP_ID = "AUTH-APP-ID";
    public static final String AUTH_APP_TOKEN = "AUTH-APP-TOKEN";


    private MultiValueMap<String, String> createHeaders(final String appId, final String appToken) {
        final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(AUTH_APP_ID, appId);
        headers.add(AUTH_APP_TOKEN, appToken);
        return headers;
    }

    public <T> HttpEntity<T> createRequestWithAppToken(final AppToken appToken, final T request){
        final MultiValueMap<String, String> headers = createHeaders(appToken.getId(), appToken.getToken());
        return new HttpEntity<>(request, headers);

    }
}
