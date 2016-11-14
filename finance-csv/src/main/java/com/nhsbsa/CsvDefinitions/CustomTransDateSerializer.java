package com.nhsbsa.CsvDefinitions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

/**
 * Created by ianfulcher on 11/11/2016.
 */
public class CustomTransDateSerializer extends JsonSerializer<Date> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException,
                JsonProcessingException {

        // Format the date into the style that is required dd/MM/yyyy
        String dateString = dateFormat.format(date);
        jgen.writeString(dateString);
    }

}
