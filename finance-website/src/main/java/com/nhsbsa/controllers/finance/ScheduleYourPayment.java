package com.nhsbsa.controllers.finance;

import com.nhsbsa.model.RequestForTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nataliehulse on 03/11/2016.
 */
@Controller
public class ScheduleYourPayment {

    @RequestMapping(value = "/scheduleyourpayment")
    public ModelAndView scheduleyourpayment() {
        ModelAndView modelAndView = new ModelAndView("/scheduleyourpayment");
        modelAndView.addObject("rft", new RequestForTransfer());
        return modelAndView;
    }

    @RequestMapping(value = "/scheduleyourpayment", method = RequestMethod.POST)
    public String savePaymentSchedule( final RequestForTransfer requestForTransfer,
                                            final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "scheduleyourpayment";
        }
        return "redirect:/scheduleyourpayment";
    }
}