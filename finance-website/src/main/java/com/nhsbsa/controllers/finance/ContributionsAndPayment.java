package com.nhsbsa.controllers.finance;

import com.nhsbsa.model.Adjustment;
import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.model.validation.AdjustmentValidationGroup;
import com.nhsbsa.model.validation.ContributionsValidationGroup;
import com.nhsbsa.service.RequestForTransferService;
import lombok.extern.log4j.Log4j;
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
@Log4j
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

    // Click on "Next step" on the "Contributions and payment" page, with Adjustment Required set to YES
    @PostMapping(value = "/contributionsandpayment/{rftUuid}", params = "adjustmentsRequired=1")
    public String saveContributionPaymentWithAdjustment( @PathVariable("rftUuid") final String rftUuid,
                                           @Validated(value = {ContributionsValidationGroup.class, AdjustmentValidationGroup.class})
                                           @ModelAttribute("rft") final RequestForTransfer requestForTransfer,
                                      final BindingResult bindingResult) {

        return saveContributionPayment(rftUuid, requestForTransfer, bindingResult);
    }

    // Click on "Next step" on the "Contributions and payment" page, with Adjustment Required set to NO
    @PostMapping(value = "/contributionsandpayment/{rftUuid}", params = {"adjustmentsRequired=0"})
    public String saveContributionPaymentWithoutAdjustment( @PathVariable("rftUuid") final String rftUuid,
                                           @Validated(value = ContributionsValidationGroup.class)
                                           @ModelAttribute("rft") final RequestForTransfer requestForTransfer,
                                           final BindingResult bindingResult) {
        if (!requestForTransfer.getAdjustmentsRequired()) {
            requestForTransfer.setAdjustment(Adjustment.builder().build());
        }
        return saveContributionPayment(rftUuid, requestForTransfer, bindingResult);
    }

    // Click on "Next step" on the "Contributions and payment" page, with Adjustment Required set to NULL
    @PostMapping(value = "/contributionsandpayment/{rftUuid}", params = {"!adjustmentsRequired"})
    public String saveContributionPaymentNoAdjustment( @PathVariable("rftUuid") final String rftUuid,
                                                            @Validated(value = ContributionsValidationGroup.class)
                                                            @ModelAttribute("rft") final RequestForTransfer requestForTransfer,
                                                            final BindingResult bindingResult) {
        if (!requestForTransfer.getAdjustmentsRequired()) {
            requestForTransfer.setAdjustment(Adjustment.builder().build());
        }

        return saveContributionPayment(rftUuid, requestForTransfer, bindingResult);
    }

    private String saveContributionPayment( final String rftUuid,
                                            final RequestForTransfer requestForTransfer,
                                            final BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return CONTRIBUTIONS_AND_PAYMENT_VIEW;
        }

        // All data ok, save what is in "requestForTransfer" into rft and then store in DB
        log.debug("About to save data from Finance 'Contributions and payment' page in the Database");
        RequestForTransfer savedRequestForTransfer = requestForTransferService.saveContributionPayment(rftUuid,requestForTransfer);
        log.debug("Data from Finance 'Contributions and payment' page saved ok in the Database");
        return "redirect:/notyetimplementedcontsandpay";
    }


}
