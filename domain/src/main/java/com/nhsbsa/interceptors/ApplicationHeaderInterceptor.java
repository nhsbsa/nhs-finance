package com.nhsbsa.interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by jeffreya on 27/09/2016.
 * ApplicationHeaderInterceptor
 */

public class ApplicationHeaderInterceptor implements ClientHttpRequestInterceptor {

    @Value("${auth.app}")
    private String appName;

    @Value("${auth.token}")
    private String token;

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        final HttpHeaders headers = request.getHeaders();
        headers.add("AUTH-APP-ID", appName);
        headers.add("AUTH-APP-TOKEN", token);
        return execution.execute(request, body);
    }

}