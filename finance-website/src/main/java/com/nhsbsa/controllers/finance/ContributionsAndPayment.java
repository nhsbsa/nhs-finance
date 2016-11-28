package com.nhsbsa.controllers.finance;

import com.nhsbsa.model.Adjustment;
import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.model.validation.ContributionsValidationGroup;
import com.nhsbsa.service.RequestForTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ianfulcher on 16/11/2016.
 */
@Controller
public class ContributionsAndPayment {

    private final RequestForTransferService requestForTransferService;
    private static final String CONTRIBUTIONS_AND_PAYMENT_VIEW = "contributionsandpayment";

    @Autowired
    public ContributionsAndPayment(final RequestForTransferService requestForTransferService) {
        this.requestForTransferService = requestForTransferService;
    }

    // Loading of the "Contributions and payment" page, use the UUID and get rft details what entered in "Schedule your payment"
    @GetMapping(value = "/contributionsandpayment/{rftUuid}")
    public ModelAndView contributionsandpayment(@PathVariable("rftUuid") final String rftUuid) {
        final RequestForTransfer rft = requestForTransferService.getRequestForTransferByRftUuid(rftUuid);

        ModelAndView modelAndView = new ModelAndView("contributionsandpayment");
        modelAndView.addObject("rft", rft);
        return modelAndView;
    }

    // Click on "Next step" on the "Contributions and payment" page, time to do validation checking....
    @PostMapping(value = "/contributionsandpayment/{rftUuid}")
    public String saveContributionPayment( @PathVariable("rftUuid") final String rftUuid,
                                           @Validated(value = ContributionsValidationGroup.class)
                                           @ModelAttribute("rft") final RequestForTransfer requestForTransfer,
                                      final BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return CONTRIBUTIONS_AND_PAYMENT_VIEW;
        }

        // All data ok, save what is in "requestForTransfer" into rft and then store in DB
        RequestForTransfer savedRequestForTransfer = requestForTransferService.saveContributionPayment(rftUuid,requestForTransfer);
        return "redirect:/notyetimplementedcontsandpay";
    }
}
