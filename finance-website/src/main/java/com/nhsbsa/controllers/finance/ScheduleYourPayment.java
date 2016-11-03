package com.nhsbsa.controllers.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nataliehulse on 03/11/2016.
 */
@Controller
public class ScheduleYourPayment {

    @RequestMapping(value = "/scheduleyourpayment")
    public ModelAndView scheduleyourpayment() {
        final Map<String, Object> modelMap = new HashMap<>();
        return new ModelAndView("/scheduleyourpayment", modelMap);
    }

}
