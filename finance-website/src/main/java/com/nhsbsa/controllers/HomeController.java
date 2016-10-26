package com.nhsbsa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeffreya on 16/08/2016.
 *
 */

@Controller
@RequestMapping("/home")
public class HomeController {


    public HomeController() {

    }
    @GetMapping
    public ModelAndView getForm(@RequestParam(required = false) String username) {
        final Map<String, Object> model = new HashMap<>();
        model.put("username", username);
        return new ModelAndView("index", model);
    }

}
