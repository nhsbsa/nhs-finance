package com.nhsbsa;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.nhsbsa.reports.rft1.RFT1;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;


@Log4j
@Service
public class RFT1CSV {

    private static final CsvMapper CSV_MAPPER = new CsvMapper();
    private static final CsvSchema CSV_SCHEMA = CSV_MAPPER.schemaFor(RFT1.class).withHeader();
    private static final int BUFFER_SIZE = 1024;
    private static final String CHARSET_NAME = "UTF-16";

    public static List<RFT1> read(final File rft1File) throws IOException {
        log.info("Reading RFT1 file:" + rft1File.getAbsolutePath());
        final MappingIterator<RFT1> objectMappingIterator = CSV_MAPPER.readerFor(RFT1.class).with(CSV_SCHEMA).readValues(rft1File);
        final List<RFT1> output = new ArrayList<>();
        objectMappingIterator.forEachRemaining(output::add);
        log.info("Created " + output.size() + " entries from file");
        return output;
    }

    public static void writeCsvFile(final Collection<RFT1> csvRows, final File rft1File) throws IOException {
        log.info("Writing " + csvRows.size() + " entries to RFT1 file " + rft1File.getAbsolutePath());
        try (final FileOutputStream tempFileOutputStream = new FileOutputStream(rft1File);
             final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, BUFFER_SIZE);
             final OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, CHARSET_NAME)
        ) {
            final ObjectWriter writer = CSV_MAPPER.writer(CSV_SCHEMA);
            writer.writeValue(writerOutputStream, csvRows);
            log.info("Finished writing RTF1 file " + rft1File.getAbsolutePath());
        }
    }


}
