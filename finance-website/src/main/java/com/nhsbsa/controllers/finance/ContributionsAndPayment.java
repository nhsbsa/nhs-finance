package com.nhsbsa.controllers.finance;

import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.model.validation.ContributionsValidationGroup;
import com.nhsbsa.service.RequestForTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/contributionsandpayment/{rftUuid}")
    public ModelAndView contributionsandpayment(@PathVariable("rftUuid") final String rftUuid) {
        final RequestForTransfer rft = requestForTransferService.getRequestForTransferByRftUuid(rftUuid);

        ModelAndView modelAndView = new ModelAndView("contributionsandpayment");
        modelAndView.addObject("rft", rft);
        return modelAndView;
    }

    @PostMapping(value = "/contributionsandpayment/{rftUuid}")
    public String saveContributionPayment( @PathVariable("rftUuid") final String rftUuid,
                                           @Validated(value = ContributionsValidationGroup.class)
                                           @ModelAttribute("rft") final RequestForTransfer requestForTransfer,
                                      final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return "contributionsandpayment/"+ rftUuid; // Fails and crashes
            return "/contributionsandpayment/"+ rftUuid; // Fails and crashes

            //return "redirect:/contributionsandpayment/" + rftUuid;  // Works...... but no error messages and blanks screen!
        }
        RequestForTransfer savedRequestForTransfer = requestForTransferService.saveContributionPayment(rftUuid,requestForTransfer);
        return "redirect:/notyetimplementedcontsandpay";
    }


}
