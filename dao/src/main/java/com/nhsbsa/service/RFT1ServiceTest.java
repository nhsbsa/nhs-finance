package com.nhsbsa.service;

import com.nhsbsa.reports.ContributionType;
import com.nhsbsa.reports.Contributor;
import com.nhsbsa.reports.TransferDateCSVUtils;
import com.nhsbsa.reports.PaymentType;
import com.nhsbsa.reports.rft1.RFT1;
import com.nhsbsa.repos.RFT1Repository;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by MattHood on 16/11/2016.
 */
public class RFT1ServiceTest {
    private static final RFT1Repository RFT_1_REPOSITORY = Mockito.mock(RFT1Repository.class);
    private static final RFT1Service RFT_1_SERVICE = new RFT1Service(RFT_1_REPOSITORY);

    @Test
    public void save() throws Exception {
        final int csvId = 1;
        final RFT1 expectedRFT1 = RFT1.builder()
                .csvFileID(csvId)
                .build();
        RFT_1_SERVICE.save(expectedRFT1);

        verify(RFT_1_REPOSITORY).save(expectedRFT1);
    }

    @Test
    public void load() throws Exception {
        final int csvId = 1;
        final RFT1 expectedRFT1 = RFT1.builder()
                .csvFileID(csvId)
                .build();

        when(RFT_1_REPOSITORY.findByCsvFileID(csvId))
                .thenReturn(expectedRFT1);

        final RFT1 loadedFile = RFT_1_SERVICE.findByCsvFileID(csvId);

        assertNotNull("Should not be null", loadedFile);
        assertEquals("Should load ID 1", csvId, loadedFile.getCsvFileID());
    }

    @Test
    public void write() throws Exception {
        final Collection<RFT1> mockCsvRowData = getMockCsvRowData();
        final File file = File.createTempFile("testcsv", ".csv");
        final File writtenFile = RFT_1_SERVICE.write(mockCsvRowData, file);

        assertNotNull("Should not be null", writtenFile);

        final List<RFT1> readRFT1Rows = RFT_1_SERVICE.read(writtenFile);
        assertThat(readRFT1Rows, is(getMockCsvRowData()));
    }

    private static Collection<RFT1> getMockCsvRowData() throws ParseException {
        final Date testDateOne = TransferDateCSVUtils.DATE_FORMAT.parse("12/12/2012");
        final Date testDateTwo = TransferDateCSVUtils.DATE_FORMAT.parse("08/01/1992");

        return Arrays.asList(
                RFT1.builder().
                        accountCode("EA8332").
                        transactionDate(testDateOne).
                        baseAmount(new BigDecimal("4303.1700")).
                        baseAmountPlusMinus(new BigDecimal("5303.1700")).
                        paymentType(PaymentType.INVOICE).
                        reference("EA83321706").
                        description("JS: RFTOL REF: EA83321706 DES: Online Monthly Cont'tions Staff/GP: S").
                        salesAnalysis("XR7100").
                        journalSource("RFTOL").
                        contributionMonth("1706").
                        staffGP(Contributor.GP).
                        contributionType(ContributionType.B).
                        build(),

                RFT1.builder().
                        accountCode("EA7654").
                        transactionDate(testDateTwo).
                        baseAmount(new BigDecimal("4304.1700")).
                        baseAmountPlusMinus(new BigDecimal("5304.1700")).
                        paymentType(PaymentType.CREDIT_NOTE).
                        reference("EA83321453").
                        description("Cont'tions").
                        salesAnalysis("XR7650").
                        journalSource("RFDEF").
                        contributionMonth("3406").
                        staffGP(Contributor.GP).
                        contributionType(ContributionType.A).
                        build());
    }

}