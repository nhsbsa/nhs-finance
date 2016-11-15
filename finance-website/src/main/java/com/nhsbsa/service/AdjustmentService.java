package com.nhsbsa.service;

import com.nhsbsa.model.Adjustment;
import com.nhsbsa.model.RequestForTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nataliehulse on 15/11/2016.
 */
@Service
public class AdjustmentService  {

    private static final String GET_ADJUSTMENT_PATH = "/finance/requestfortransfer/{rftId}";
    private static final String SAVE_ADJUSTMENT_PATH = "/finance/requestfortransfer";

    private final RestTemplate restTemplate;
    private final BackendUri getAdjustmentUri;
    private final BackendUri saveAdjustmentUri;

    @Autowired
    public AdjustmentService(final BackendApiUriService backendApiUriService,
                                     final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.getAdjustmentUri = backendApiUriService.path(GET_ADJUSTMENT_PATH);
        this.saveAdjustmentUri = backendApiUriService.path(SAVE_ADJUSTMENT_PATH);
    }

    public Adjustment getAdjustment(final String rftId) {
        final String uri = getAdjustmentUri.params(rftId);
        return restTemplate.getForObject(uri, Adjustment.class);
    }

    public Adjustment saveAdjustment(final Adjustment adjustment) {
        final String uri = saveAdjustmentUri.toUri();
        return restTemplate.postForObject(uri, adjustment, Adjustment.class);
    }

}
