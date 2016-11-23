package com.nhsbsa.service;

import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.repos.RequestForTransferRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

/**
 * Created by Mark Lishman on 10/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class FinanceServiceTest {

    public static final String RFT_UUID = 123L;
    @Mock private RequestForTransferRepository requestForTransferRepository;

    private FinanceService financeService;

    @Before
    public void before() {
        financeService = new FinanceService(requestForTransferRepository);
    }

    @Test
    public void getRequestForTransfer() {
        RequestForTransfer expectedRft = new RequestForTransfer();
        given(requestForTransferRepository.findByRftUuid(RFT_UUID)).willReturn(expectedRft);

        RequestForTransfer actualRft = financeService.getRequestForTransferByRftUuid(RFT_UUID);

        assertThat(actualRft, is(sameInstance(expectedRft)));
    }

    @Test
    public void saveRequestForTransfer() {
        RequestForTransfer newRft = new RequestForTransfer();
        RequestForTransfer expectedRft = new RequestForTransfer();
        given(requestForTransferRepository.save(newRft)).willReturn(expectedRft);

        RequestForTransfer actualRft = financeService.saveRequestForTransfer(newRft);

        assertThat(actualRft, is(sameInstance(expectedRft)));
    }

}