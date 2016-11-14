package com.nhsbsa.CsvDefinitions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by ianfulcher on 11/11/2016.
 */
public abstract class CustomTransDateSerializer extends JsonSerializer<Date> {

    //@Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = dateFormat.format(date);
        jsonGenerator.writeString(dateString);
    }
}
