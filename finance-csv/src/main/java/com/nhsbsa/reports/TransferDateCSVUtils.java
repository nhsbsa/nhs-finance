package com.nhsbsa.reports;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.log4j.Log4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

/**
 * Created by ianfulcher on 11/11/2016.
 */

@Log4j
public class TransferDateCSVUtils {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");


    public static class Serializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            final String dateString = DATE_FORMAT.format(date);
            jgen.writeString(dateString);
        }
    }

    public static class Deserializer extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            final String valueAsString = jsonParser.getValueAsString();
            try {
                return DATE_FORMAT.parse(valueAsString);
            } catch (ParseException e) {
                log.error(e);
            }
            return null;
        }
    }

}
