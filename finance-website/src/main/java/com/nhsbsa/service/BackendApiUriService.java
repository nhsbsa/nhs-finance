package com.nhsbsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Mark Lishman on 18/08/2016.
 */

@Service
public class BackendApiUriService {

    private UriComponentsBuilder uriComponentsBuilder;

    @Autowired
    public BackendApiUriService(@Value("${api.backend.protocol}") final String backendProtocol,
                                @Value("${api.backend.host}") final String backendHost,
                                @Value("${api.backend.port}") final String backendPort) {

        uriComponentsBuilder = UriComponentsBuilder
                .newInstance()
                .scheme(backendProtocol)
                .host(backendHost)
                .port(backendPort);
    }

    public BackendUri path(String path) {
        UriComponents uriComponents = uriComponentsBuilder
                .cloneBuilder()
                .path(path)
                .build();
        return new BackendUri(uriComponents);
    }

}
