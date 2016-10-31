package com.nhsbsa.security;

import com.nhsbsa.exception.AppTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static com.nhsbsa.rest.RestAuthentication.AUTH_APP_ID;
import static com.nhsbsa.rest.RestAuthentication.AUTH_APP_TOKEN;

/**
 * Created by jeffreya on 27/09/2016.
 * AppTokenBuilder
 */

@Slf4j
@Service
public class AppTokenBuilder {


    public AppToken getAppToken(final HttpServletRequest httpServletRequest) throws AppTokenException {
        final String appId = httpServletRequest.getHeader(AUTH_APP_ID);
        final String appToken = httpServletRequest.getHeader(AUTH_APP_TOKEN);
        if (StringUtils.isEmpty(appId) || StringUtils.isEmpty(appToken)) {
            log.error("App token is invalid");
            throw new AppTokenException();
        }

        return AppToken
                .builder()
                .id(appId)
                .token(appToken)
                .build();
    }
}
