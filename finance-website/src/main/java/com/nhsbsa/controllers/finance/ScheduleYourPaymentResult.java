package com.nhsbsa.controllers.finance;

import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.service.RequestForTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Mark Lishman on 9/11/2016.
 */
@Controller
public class ScheduleYourPaymentResult {

    // TODO remove this when real page is available

    private final RequestForTransferService requestForTransferService;

    @Autowired
    public ScheduleYourPaymentResult(final RequestForTransferService requestForTransferService) {
        this.requestForTransferService = requestForTransferService;
    }

    @GetMapping(value = "/scheduleyourpaymentresult/{rftId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String scheduleyourpayment(@PathVariable("rftId") final String rftId) {
        final RequestForTransfer rft = requestForTransferService.getRequestForTransfer(rftId);

        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Success</h1>");
        sb.append(String.format("<p>id: %s</p>", rft.getId()));
        sb.append(String.format("<p>transfer date: %s</p>", rft.getTransferDate().getDate()));
        sb.append(String.format("<p>is gp: %s</p>", rft.getIsGp()));
        return sb.toString();
    }

}