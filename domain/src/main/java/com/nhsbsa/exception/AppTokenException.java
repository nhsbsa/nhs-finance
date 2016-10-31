package com.nhsbsa.exception;

/**
 * Created by jeffreya on 27/09/2016.
 * AppTokenException
 */

public class AppTokenException extends IllegalArgumentException {
    public AppTokenException() {
        super("App token invalid");
    }
}
