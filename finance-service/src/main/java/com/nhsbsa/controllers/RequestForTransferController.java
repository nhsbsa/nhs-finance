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

    @GetMapping(value = "/requestfortransfer/{rftId}")
    public ResponseEntity<RequestForTransfer> getRequestForTransfer(@PathVariable("rftId") final Long rftId) {
        RequestForTransfer rft = financeService.getRequestForTransfer(rftId);
        return ResponseEntity.ok(rft);
    }

    @PostMapping(value = "/requestfortransfer")
    public ResponseEntity<RequestForTransfer> saveRequestForTransfer(@RequestBody @Valid final RequestForTransfer requestForTransfer) {
        RequestForTransfer rft = financeService.saveRequestForTransfer(requestForTransfer);
        return ResponseEntity.ok(rft);
    }
}