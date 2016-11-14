package com.nhsbsa;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.nhsbsa.CsvDefinitions.CsvColumns;
//import com.nhsbsa.CsvDefinitions.CustomStaffGpSerializer;
//import com.nhsbsa.CsvDefinitions.TestEnum;
import com.nhsbsa.CsvDefinitions.StaffOrGpEnum;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

//import com.fasterxml.jackson.annotation.


/**
 * CSV Writer, investigation.
 * <p>
 * CSV Header Columns, comma separated, that we need in the file:
 * <p>
 * Account Code,Transaction Date,Base Amount,Base Amount(+/-),Payment Type,Reference,Description,
 * Sales Analysis,Journal Source,Contribution Month,Staff/GP,Contribution Type
 * <p>
 * This has the column headings in the file also as the actual names so the class has String's as all the variables
 * as using the same class for the data also.
 */
public class WriteToCSV {

    public static void main(String[] args) throws IOException {

        final Collection<CsvColumns> csvRows = getCsvRowData();
        final File rft1File = File.createTempFile("RFT1_", ".csv");

        System.out.println(rft1File.getAbsolutePath());
        writeCsvFile(csvRows, rft1File);
    }

    private static Collection<CsvColumns> getCsvRowData() {
        return Arrays.asList(
                CsvColumns.builder().
                        accountCode("EA8332").
                        transactionDate("05/10/2016").
                        baseAmount(new BigDecimal("4303.173423423")).
                        baseAmountPlusMinus(new BigDecimal("5303.1756223423")).
                        paymentType("INV").
                        reference("EA83321706").
                        description("JS: RFTOL REF: EA83321706 DES: Online Monthly Cont'tions Staff/GP: S").
                        salesAnalysis("XR7100").
                        journalSource("RFTOL").
                        contributionMonth("1706").
                        //staffGP(TestEnum.GP).
                        staffGP(StaffOrGpEnum.GP).
                        contributionType("R").
                        build(),

                CsvColumns.builder().
                        accountCode("EA7654").
                        transactionDate("15/11/2016").
                        baseAmount(new BigDecimal("4304.174223423")).
                        baseAmountPlusMinus(new BigDecimal("5304.175644234234")).
                        paymentType("INV").
                        reference("EA83321453").
                        description("Cont'tions").
                        salesAnalysis("XR7650").
                        journalSource("RFDEF").
                        contributionMonth("3406").
                        //staffGP(TestEnum.STAFF).
                        staffGP(StaffOrGpEnum.GP).
                        contributionType("G").
                        build());
    }

    private static void writeCsvFile(final Collection<CsvColumns> csvRows, final File rft1File) throws IOException {
        try (final FileOutputStream tempFileOutputStream = new FileOutputStream(rft1File);
             final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
             final OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
        ) {

            final CsvMapper csvMapper = new CsvMapper();
            final CsvSchema csvSchema = csvMapper.schemaFor(CsvColumns.class).withHeader();
            final ObjectWriter writer = csvMapper.writer(csvSchema);
            System.out.println("Here ok Other 4");
            writer.writeValue(writerOutputStream, csvRows);
            System.out.println("Here ok Other 5");

            final String debugCsvFile = writer.writeValueAsString(csvRows);
            System.out.println(debugCsvFile);
        }
    }


}
