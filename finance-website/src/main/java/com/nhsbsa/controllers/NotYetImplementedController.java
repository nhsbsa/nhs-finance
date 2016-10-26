package com.nhsbsa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jeffreya on 16/08/2016.
 */

@Controller
@RequestMapping("/notyetimplemented")
public class NotYetImplementedController {

    @RequestMapping(value = "")
    public String homeController() {
        return "notyetimplemented";
    }

}
