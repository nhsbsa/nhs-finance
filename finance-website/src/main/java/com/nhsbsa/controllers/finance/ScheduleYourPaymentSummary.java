package com.nhsbsa.controllers.finance;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Mark Lishman on 9/11/2016.
 */
@Controller
public class ScheduleYourPaymentSummary {

    // TODO remove this when real page is available

    @GetMapping(value = "/scheduleyourpaymentsummary")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String scheduleyourpayment() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Summary</h1>");


        return sb.toString();
    }

}