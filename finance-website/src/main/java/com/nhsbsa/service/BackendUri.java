package com.nhsbsa.service;

import org.springframework.web.util.UriComponents;

/**
 * Created by Mark Lishman on 18/08/2016.
 */

public class BackendUri {

    private UriComponents uriComponents;

    BackendUri(final UriComponents uriComponents) {
        this.uriComponents = uriComponents;
    }

    public String params(Object... params) {
        return uriComponents
                .expand((Object[]) params)
                .encode()
                .toUriString();
    }

}
