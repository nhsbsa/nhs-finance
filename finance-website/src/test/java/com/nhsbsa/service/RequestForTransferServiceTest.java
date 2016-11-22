package com.nhsbsa.service;

import com.nhsbsa.model.RequestForTransfer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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

    @Mock private RequestForTransfer requestForTransfer;

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
    public void getRequestForTransferByRftUuid() {
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

        RequestForTransfer actualRft = requestForTransferService.saveRequestForTransfer(expectedRft);

        assertThat(actualRft, is(sameInstance((expectedRft))));
    }

    @Test
    public void saveContributionPayment() {
        RequestForTransfer newRft = new RequestForTransfer();
        RequestForTransfer savedRft = new RequestForTransfer();
        given(requestForTransferService.getRequestForTransferByRftUuid(RFT_UUID)).willReturn(savedRft);

        newRft.setTotalPensionablePay(BigDecimal.valueOf(5000));
        newRft.setEmployeeContributions(BigDecimal.valueOf(50));
        newRft.setEmployerContributions(BigDecimal.valueOf(20));
        newRft.setEmployeeAddedYears(BigDecimal.valueOf(30));
        newRft.setAdditionalPension(BigDecimal.valueOf(25));
        newRft.setErrbo(BigDecimal.valueOf(15));
        newRft.setTotalDebitAmount(BigDecimal.valueOf(5050));

        RequestForTransfer actualRft = requestForTransferService.saveContributionPayment(RFT_UUID, newRft);

        assertThat(actualRft.getTotalPensionablePay(),is(equalTo(newRft.getTotalPensionablePay())));
        assertThat(actualRft.getEmployeeContributions(),is(equalTo(newRft.getEmployeeContributions())));
        assertThat(actualRft.getEmployerContributions(),is(equalTo(newRft.getEmployerContributions())));
        assertThat(actualRft.getEmployeeAddedYears(),is(equalTo(newRft.getEmployeeAddedYears())));
        assertThat(actualRft.getAdditionalPension(),is(equalTo(newRft.getAdditionalPension())));
        assertThat(actualRft.getErrbo(),is(equalTo(newRft.getErrbo())));
        assertThat(actualRft.getTotalDebitAmount(),is(equalTo(newRft.getTotalDebitAmount())));

        assertThat(actualRft, is(sameInstance((savedRft))));

       verify(restTemplate).postForObject("http://host:8080/finance/requestfortransfer", savedRft, RequestForTransfer.class);
    }

}