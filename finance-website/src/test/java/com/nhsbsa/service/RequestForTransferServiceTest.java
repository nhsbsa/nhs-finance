package com.nhsbsa.service;

import com.nhsbsa.model.AdjustmentContributionDate;
import com.nhsbsa.model.RequestForTransfer;
import com.nhsbsa.model.Adjustment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


    /*@Test
    public void saveContributionAndAdjustmentPayment() {
        RequestForTransfer emptyRft = new RequestForTransfer();
        RequestForTransfer savedRft = new RequestForTransfer();
        Adjustment adjustmentListTemp = new Adjustment();

        given(requestForTransferService.getRequestForTransferByRftUuid(RFT_UUID)).willReturn(savedRft);

        emptyRft.setTotalPensionablePay(BigDecimal.valueOf(5000));
        emptyRft.setEmployeeContributions(BigDecimal.valueOf(50));
        emptyRft.setEmployerContributions(BigDecimal.valueOf(20));
        emptyRft.setEmployeeAddedYears(BigDecimal.valueOf(30));
        emptyRft.setAdditionalPension(BigDecimal.valueOf(25));
        emptyRft.setErrbo(BigDecimal.valueOf(15));
        emptyRft.setTotalDebitAmount(BigDecimal.valueOf(5050));

// Create and populate items in an Adjustment object, the first “list” entry (only one for this test but may have numerous)
        Adjustment adjustmentTestIn1 = new Adjustment();
        AdjustmentContributionDate adjustmentContributionDate = new AdjustmentContributionDate();
        adjustmentContributionDate.setContributionMonth("July");
        adjustmentContributionDate.setContributionYear(2015);
        adjustmentTestIn1.setEmployeeContributions(new BigDecimal(3.1).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn1.setEmployerContributions(new BigDecimal(5.2).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn1.setEmployeeAddedYears(new BigDecimal(7.3).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn1.setAdditionalPension(new BigDecimal(9.5).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn1.setErrbo(new BigDecimal(11.7).setScale(2, BigDecimal.ROUND_HALF_UP));

        // Add temp object (Adjustment class) into the list of "Adjustments", can do many times but this is a test for one only
        //adjustmentListTemp.(adjustmentTestIn1);

       // emptyRft.setAdjustmentList(adjustmentListTemp);
        RequestForTransfer actualRft = requestForTransferService.saveContributionPayment(RFT_UUID, emptyRft);

        assertThat(actualRft.getTotalPensionablePay(),is(equalTo(emptyRft.getTotalPensionablePay())));
        assertThat(actualRft.getEmployeeContributions(),is(equalTo(emptyRft.getEmployeeContributions())));
        assertThat(actualRft.getEmployerContributions(),is(equalTo(emptyRft.getEmployerContributions())));
        assertThat(actualRft.getEmployeeAddedYears(),is(equalTo(emptyRft.getEmployeeAddedYears())));
        assertThat(actualRft.getAdditionalPension(),is(equalTo(emptyRft.getAdditionalPension())));
        assertThat(actualRft.getErrbo(),is(equalTo(emptyRft.getErrbo())));
        assertThat(actualRft.getTotalDebitAmount(),is(equalTo(emptyRft.getTotalDebitAmount())));
        assertThat(actualRft.getAdjustmentList(),is(equalTo(emptyRft.getAdjustmentList())));


      //  Iterator<Adjustment> iterEmptyRft = emptyRft.getAdjustmentList().iterator();

      //  for (Iterator<Adjustment> iterActualRft = actualRft.getAdjustmentList().iterator(); iterActualRft.hasNext(); ) {
      //      Adjustment actualRftElement = iterActualRft.next();
     //       Adjustment emptyRftElement = iterEmptyRft.next();
      //      assertThat(actualRftElement,is(equalTo(emptyRftElement)));
      //  }

        assertThat(actualRft, is(sameInstance((savedRft))));

        verify(restTemplate).postForObject("http://host:8080/finance/requestfortransfer", savedRft, RequestForTransfer.class);
    }

    @Test
    public void saveContributionAndMultipleAdjustmentPayments() {
        RequestForTransfer emptyRft = new RequestForTransfer();
        RequestForTransfer savedRft = new RequestForTransfer();
        List<Adjustment> adjustmentListTemp = new ArrayList<Adjustment>();

        given(requestForTransferService.getRequestForTransferByRftUuid(RFT_UUID)).willReturn(savedRft);

        emptyRft.setTotalPensionablePay(BigDecimal.valueOf(5000));
        emptyRft.setEmployeeContributions(BigDecimal.valueOf(50));
        emptyRft.setEmployerContributions(BigDecimal.valueOf(20));
        emptyRft.setEmployeeAddedYears(BigDecimal.valueOf(30));
        emptyRft.setAdditionalPension(BigDecimal.valueOf(25));
        emptyRft.setErrbo(BigDecimal.valueOf(15));
        emptyRft.setTotalDebitAmount(BigDecimal.valueOf(5050));

// Create and populate items in an Adjustment object, the first “list” entry (first for this test and another added later too)
        Adjustment adjustmentTestIn1 = new Adjustment();
        AdjustmentContributionDate adjustmentContributionDateTestIn1 = new AdjustmentContributionDate();
        adjustmentContributionDateTestIn1.setContributionMonth("July");
        adjustmentContributionDateTestIn1.setContributionYear(2015);
        adjustmentTestIn1.setEmployeeContributions(new BigDecimal(3.1).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn1.setEmployerContributions(new BigDecimal(5.2).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn1.setEmployeeAddedYears(new BigDecimal(7.3).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn1.setAdditionalPension(new BigDecimal(9.5).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn1.setErrbo(new BigDecimal(11.7).setScale(2, BigDecimal.ROUND_HALF_UP));

        // Add temp object (Adjustment class) into the list of "Adjustments", can do many times so this is the first entry
        adjustmentListTemp.add(adjustmentTestIn1);

        // Create and populate another list set of items in an Adjustment object, the second “list” entry, to prove multiple entries work
        Adjustment adjustmentTestIn2 = new Adjustment();
        AdjustmentContributionDate adjustmentContributionDateTestIn2 = new AdjustmentContributionDate();
        adjustmentContributionDateTestIn2.setContributionMonth("September");
        adjustmentContributionDateTestIn2.setContributionYear(2014);
        adjustmentTestIn2.setEmployeeContributions(new BigDecimal(23.1).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn2.setEmployerContributions(new BigDecimal(25.2).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn2.setEmployeeAddedYears(new BigDecimal(27.3).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn2.setAdditionalPension(new BigDecimal(29.5).setScale(2, BigDecimal.ROUND_HALF_UP));
        adjustmentTestIn2.setErrbo(new BigDecimal(211.7).setScale(2, BigDecimal.ROUND_HALF_UP));

        adjustmentListTemp.add(adjustmentTestIn2);

     //   emptyRft.setAdjustmentList(adjustmentListTemp);
        RequestForTransfer actualRft = requestForTransferService.saveContributionPayment(RFT_UUID, emptyRft);

        assertThat(actualRft.getTotalPensionablePay(),is(equalTo(emptyRft.getTotalPensionablePay())));
        assertThat(actualRft.getEmployeeContributions(),is(equalTo(emptyRft.getEmployeeContributions())));
        assertThat(actualRft.getEmployerContributions(),is(equalTo(emptyRft.getEmployerContributions())));
        assertThat(actualRft.getEmployeeAddedYears(),is(equalTo(emptyRft.getEmployeeAddedYears())));
        assertThat(actualRft.getAdditionalPension(),is(equalTo(emptyRft.getAdditionalPension())));
        assertThat(actualRft.getErrbo(),is(equalTo(emptyRft.getErrbo())));
        assertThat(actualRft.getTotalDebitAmount(),is(equalTo(emptyRft.getTotalDebitAmount())));
        assertThat(actualRft.getAdjustmentList(),is(equalTo(emptyRft.getAdjustmentList())));


       // Iterator<Adjustment> iterEmptyRft = emptyRft.getAdjustmentList().iterator();

        // Loop through all the elements of the list (just do one list as should be in sync, if not then will error).
       // for (Iterator<Adjustment> iterActualRft = actualRft.getAdjustmentList().iterator(); iterActualRft.hasNext(); ) {

         //   Adjustment actualRftListElement = iterActualRft.next();
          //  Adjustment emptyRftListElement = iterEmptyRft.next();

            // Generic check of the list element itself (has all members in so a quicker way of checking in one go)
            assertThat(actualRftListElement,is(equalTo(emptyRftListElement)));

            // NOTE that you can also do each individual member of the list element you have for being specific as below.
            assertThat(actualRftListElement.getAdjustmentContributionDate(),is(equalTo(emptyRftListElement.getAdjustmentContributionDate())));
            assertThat(actualRftListElement.getEmployeeContributions(),is(equalTo(emptyRftListElement.getEmployeeContributions())));
            assertThat(actualRftListElement.getEmployerContributions(),is(equalTo(emptyRftListElement.getEmployerContributions())));
            assertThat(actualRftListElement.getEmployeeAddedYears(),is(equalTo(emptyRftListElement.getEmployeeAddedYears())));
            assertThat(actualRftListElement.getAdditionalPension(),is(equalTo(emptyRftListElement.getAdditionalPension())));
        }

        assertThat(actualRft, is(sameInstance((savedRft))));

        verify(restTemplate).postForObject("http://host:8080/finance/requestfortransfer", savedRft, RequestForTransfer.class);
    }*/
}