package com.nhsbsa.controllers.finance;

import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.service.RequestForTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    private final RequestForTransferService requestForTransferService;

    @Autowired
    public ScheduleYourPayment(final RequestForTransferService requestForTransferService) {
        this.requestForTransferService = requestForTransferService;
    }

    @GetMapping(value = "/scheduleyourpayment")
    public ModelAndView scheduleyourpayment() {
        ModelAndView modelAndView = new ModelAndView("scheduleyourpayment");
        modelAndView.addObject("rft", new RequestForTransfer());
        return modelAndView;
    }

    @PostMapping(value = "/scheduleyourpayment")
    public String savePaymentSchedule(@Validated @ModelAttribute("rft") final RequestForTransfer requestForTransfer,
                                      final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "scheduleyourpayment";
        }
        RequestForTransfer savedRequestForTransfer = requestForTransferService.saveRequestForTransfer(requestForTransfer);
        return "redirect:/contributionsandpayment";
    }
}