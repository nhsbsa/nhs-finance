package com.nhsbsa.controllers.finance;

import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.service.RequestForTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nataliehulse on 15/11/2016.
 */
/*
    TO DO
    Remove Comments from Controller annotation
    Change view name to new screen name
    Change redirect on ScheduleYourPayment controller to go to new screen instead of result page
*/
//@Controller
public class ContributionsAndPayments {

    private final RequestForTransferService requestForTransferService;

    @Autowired
    public ContributionsAndPayments(final RequestForTransferService requestForTransferService) {
        this.requestForTransferService = requestForTransferService;
    }

    @GetMapping(value = "/contributionsandpayments")
    public ModelAndView contributionsandpayments() {
        ModelAndView modelAndView = new ModelAndView("contributionsandpayments");
        modelAndView.addObject("rft", new RequestForTransfer());
        return modelAndView;
    }

    @PostMapping(value = "/contributionsandpayments")
    public String savePaymentSchedule(@Validated @ModelAttribute("rft") final RequestForTransfer requestForTransfer,
                                      final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contributionsandpayments";
        }
        RequestForTransfer savedRequestForTransfer = requestForTransferService.saveRequestForTransfer(requestForTransfer);
        return "redirect:/scheduleyourpaymentresult/" + savedRequestForTransfer.getId();
    }
}
