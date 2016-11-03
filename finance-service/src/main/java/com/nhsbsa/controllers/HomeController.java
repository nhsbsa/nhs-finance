package com.nhsbsa.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeffreya on 16/08/2016.
 *
 */

@RequestMapping("/")
@RestController
public class HomeController {
    @RequestMapping(value = "")
    public HttpEntity<String> homeController() {
        return ResponseEntity.ok("FinanceService");
    }

}