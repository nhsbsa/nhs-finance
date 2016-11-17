package com.nhsbsa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeffreya on 16/11/2016.
 * Controller for debug mode
 */

@RestController
public class DebugController {

    @GetMapping(value = "debug")
    public String getDebug() {
        return "hello world";
    }
}
