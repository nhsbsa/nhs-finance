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

    private static final String GET_REQUEST_FOR_TRANSFER_PATH = "/finance/requestfortransfer/{rftId}";
    private static final String SAVE_REQUEST_FOR_TRANSFER_PATH = "/finance/requestfortransfer";

    private final RestTemplate restTemplate;
    private final BackendUri getRequestForTransferUri;
    private final BackendUri saveRequestForTransferUri;


    @Autowired
    public RequestForTransferService(final BackendApiUriService backendApiUriService,
                                     final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.getRequestForTransferUri = backendApiUriService.path(GET_REQUEST_FOR_TRANSFER_PATH);
        this.saveRequestForTransferUri = backendApiUriService.path(SAVE_REQUEST_FOR_TRANSFER_PATH);
    }

    public RequestForTransfer getRequestForTransfer(final String rftId) {
        final String uri = getRequestForTransferUri.params(rftId);
        return restTemplate.getForObject(uri, RequestForTransfer.class);
    }

    public RequestForTransfer saveRequestForTransfer(final RequestForTransfer requestForTransfer) {
        final String uri = saveRequestForTransferUri.toUri();
        return restTemplate.postForObject(uri, requestForTransfer, RequestForTransfer.class);
    }

}
