package com.nhsbsa.service;

import com.nhsbsa.model.RequestForTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Mark Lishman on 18/08/2016.
 */

@Service
public class RequestForTransferService {

    // TODO rename rft to requestfortransfer

    private static final String REQUEST_FOR_TRANSFER_PATH = "/finance/rft";

    private final RestTemplate restTemplate;
    private final BackendUri requestForTransferUri;

    @Autowired
    public RequestForTransferService(final BackendApiUriService backendApiUriService,
                                     final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.requestForTransferUri = backendApiUriService.path(REQUEST_FOR_TRANSFER_PATH);
    }

    public RequestForTransfer getRequestForTransfer(final String rftId) {
        final String uri = requestForTransferUri.params(rftId);
        return restTemplate.getForObject(uri, RequestForTransfer.class);
    }

    public RequestForTransfer saveRequestForTransfer(final RequestForTransfer requestForTransfer) {
        final String uri = requestForTransferUri.toUri();
        return restTemplate.postForObject(uri, requestForTransfer, RequestForTransfer.class);
    }

}
