package com.nhsbsa.service;

import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.repos.RequestForTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Mark Lishman on 18/08/2016.
 */

@Service
@Transactional
public class FinanceService {

    private RequestForTransferRepository requestForTransferRepository;

    @Autowired
    public FinanceService(final RequestForTransferRepository requestForTransferRepository) {
        this.requestForTransferRepository = requestForTransferRepository;
    }


    public RequestForTransfer getRequestForTransferByRftUuid(final String rftUuid) {
        return requestForTransferRepository.findByRftUuid(rftUuid);
    }

    public RequestForTransfer saveRequestForTransfer(final RequestForTransfer requestForTransfer) {
        return requestForTransferRepository.save(requestForTransfer);
    }

}
