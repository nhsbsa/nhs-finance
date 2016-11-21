package com.nhsbsa.controllers;

import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by marklishman on 5/11//2016.
 *
 */

@RequestMapping("/finance")
@RestController
public class RequestForTransferController {

    private final FinanceService financeService;

    @Autowired
    public RequestForTransferController(final FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping(value = "/requestfortransfer/{rftUuid}")
    public ResponseEntity<RequestForTransfer> getRequestForTransferByRftUuid(@PathVariable("rftUuid") final String rftUuid) {
        RequestForTransfer rft = financeService.getRequestForTransferByRftUuid(rftUuid);
        return ResponseEntity.ok(rft);
    }

    @PostMapping(value = "/requestfortransfer")
    public ResponseEntity<RequestForTransfer> saveRequestForTransfer(@RequestBody @Valid final RequestForTransfer requestForTransfer) {

        // only set rftUuid if it hasnt already been set as this method is used to Create And Update
        if (requestForTransfer.getRftUuid() == null) {
            requestForTransfer.setRftUuid(java.util.UUID.randomUUID().toString());
        }

        RequestForTransfer rft = financeService.saveRequestForTransfer(requestForTransfer);
        return ResponseEntity.ok(rft);
    }
}