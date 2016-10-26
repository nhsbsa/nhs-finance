package com.nhsbsa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeffreya on 16/08/2016.
 */
@Controller
public class LandingPageController {


    @RequestMapping(value = "/member/landingPage1")
    public ModelAndView landingPage1() {
        final Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("name", "landingpage1");
        return new ModelAndView("landingpages/landingPage1", modelMap);
    }

    @RequestMapping(value = "/member/landingPage2")
    public ModelAndView landingPage2() {
        final Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("name", "landingPage2");
        return new ModelAndView("landingpages/landingPage2", modelMap);
    }

    @RequestMapping(value = "/landingPage3")
    public ModelAndView landingPage3() {
        final Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("name", "landingPage3");
        return new ModelAndView("landingpages/landingPage3", modelMap);
    }

    @RequestMapping(value = "/landingPage4")
    public ModelAndView landingPage4() {
        final Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("name", "landingPage4");
        return new ModelAndView("landingpages/landingPage4", modelMap);
    }

}
