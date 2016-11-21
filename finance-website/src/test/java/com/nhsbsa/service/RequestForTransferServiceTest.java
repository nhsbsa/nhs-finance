package com.nhsbsa.service;

import com.nhsbsa.model.RequestForTransfer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by Mark Lishman on 11/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestForTransferServiceTest {

    public static final String RFT_UUID = "123";
    private RequestForTransferService requestForTransferService;

    @Mock private RestTemplate restTemplate;
    BackendApiUriService backendApiUriService;

    @Before
    public void before() {

        backendApiUriService = new BackendApiUriService(
                "http",
                "host",
                "8080"
        );

        requestForTransferService = new RequestForTransferService(
            backendApiUriService,
            restTemplate
        );
    }

    @Test
    public void getRequestForTransfer() {
        RequestForTransfer expectedRft = new RequestForTransfer();
        given(restTemplate.getForObject("http://host:8080/finance/requestfortransfer/" + RFT_UUID, RequestForTransfer.class)).willReturn(expectedRft);

        RequestForTransfer actualRft = requestForTransferService.getRequestForTransferByRftUuid(RFT_UUID);

        assertThat(actualRft, is(sameInstance((expectedRft))));
    }

    @Test
    public void saveRequestForTransfer() {
        RequestForTransfer newRft = new RequestForTransfer();
        RequestForTransfer expectedRft = new RequestForTransfer();
        given(restTemplate.postForObject("http://host:8080/finance/requestfortransfer", newRft, RequestForTransfer.class)).willReturn(expectedRft);

        RequestForTransfer actualRft = requestForTransferService.saveRequestForTransfer(newRft);

        assertThat(actualRft, is(sameInstance((expectedRft))));
    }

}