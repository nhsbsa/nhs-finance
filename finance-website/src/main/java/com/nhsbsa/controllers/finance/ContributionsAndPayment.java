package com.nhsbsa.controllers.finance;

import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.service.RequestForTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ianfulcher on 16/11/2016.
 */
@Controller
public class ContributionsAndPayment {

    private final RequestForTransferService requestForTransferService;

    @Autowired
    public ContributionsAndPayment(final RequestForTransferService requestForTransferService) {
        this.requestForTransferService = requestForTransferService;
    }

    @GetMapping(value = "/contributionsandpayment")
    public ModelAndView contributionsandpayment() {
        ModelAndView modelAndView = new ModelAndView("contributionsandpayment");
        modelAndView.addObject("rft", new RequestForTransfer());
        return modelAndView;
    }

    @PostMapping(value = "/contributionsandpayment")
    public String savePaymentSchedule(@Validated @ModelAttribute("rft") final RequestForTransfer requestForTransfer,
                                      final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contributionsandpayment";
        }
        RequestForTransfer savedRequestForTransfer = requestForTransferService.saveRequestForTransfer(requestForTransfer);
        return "redirect:/notyetimplementedcontsandpay/" + savedRequestForTransfer.getId();
    }


}
