package com.nhsbsa.controllers.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeffreya on 26/10/2016.
 *
 */

@Controller
@RequestMapping("/finance")
public class FinanceController {

    public FinanceController() {

    }

    @GetMapping
    public ModelAndView getForm() {
        final Map<String, Object> model = new HashMap<>();
        return new ModelAndView("finance", model);
    }
}
