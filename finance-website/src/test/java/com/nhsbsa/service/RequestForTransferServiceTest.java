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
        RequestForTransfer emptyRft = new RequestForTransfer();
        RequestForTransfer savedRft = new RequestForTransfer();

        given(requestForTransferService.getRequestForTransferByRftUuid(RFT_UUID)).willReturn(savedRft);

        emptyRft.setTotalPensionablePay(BigDecimal.valueOf(5000));
        emptyRft.setEmployeeContributions(BigDecimal.valueOf(50));
        emptyRft.setEmployerContributions(BigDecimal.valueOf(20));
        emptyRft.setEmployeeAddedYears(BigDecimal.valueOf(30));
        emptyRft.setAdditionalPension(BigDecimal.valueOf(25));
        emptyRft.setErrbo(BigDecimal.valueOf(15));
        emptyRft.setTotalDebitAmount(BigDecimal.valueOf(5050));

        RequestForTransfer actualRft = requestForTransferService.saveContributionPayment(RFT_UUID, emptyRft);

        assertThat(actualRft.getTotalPensionablePay(),is(equalTo(emptyRft.getTotalPensionablePay())));
        assertThat(actualRft.getEmployeeContributions(),is(equalTo(emptyRft.getEmployeeContributions())));
        assertThat(actualRft.getEmployerContributions(),is(equalTo(emptyRft.getEmployerContributions())));
        assertThat(actualRft.getEmployeeAddedYears(),is(equalTo(emptyRft.getEmployeeAddedYears())));
        assertThat(actualRft.getAdditionalPension(),is(equalTo(emptyRft.getAdditionalPension())));
        assertThat(actualRft.getErrbo(),is(equalTo(emptyRft.getErrbo())));
        assertThat(actualRft.getTotalDebitAmount(),is(equalTo(emptyRft.getTotalDebitAmount())));

        assertThat(actualRft, is(sameInstance((savedRft))));

        verify(restTemplate).postForObject("http://host:8080/finance/requestfortransfer", savedRft, RequestForTransfer.class);
    }

}