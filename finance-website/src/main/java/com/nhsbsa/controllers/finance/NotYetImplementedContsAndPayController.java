package com.nhsbsa.controllers.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ianfulcher on 16/11/2016.
 * Temporary controller for where to go after the Contributions and Payment screen, as nothing
 * defined yet so need to indicate to the user and then can go back.
 */

@Controller
@RequestMapping("/notyetimplementedcontsandpay")
public class NotYetImplementedContsAndPayController {

    @RequestMapping(value = "")
    public String homeController() {
        return "notyetimplementedcontsandpay";
    }

}
