package com.nhsbsa.reports;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.log4j.Log4j;

import java.io.IOException;

/**
 * Created by ianfulcher on 14/11/2016.
 */

@Log4j
public enum Contributor {
    GP("G"),
    STAFF("S");

    private final String value;

    Contributor(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static class Serializer extends JsonSerializer<Contributor> {

        @Override
        public void serialize(Contributor value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            final String output = value.getValue();
            gen.writeString(output);
        }
    }

    public static class Deserializer extends JsonDeserializer<Contributor> {

        @Override
        public Contributor deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            final String valueAsString = jsonParser.getValueAsString();
            for (final Contributor contributor : Contributor.values()) {
                if (contributor.getValue().equals(valueAsString)) {
                    return contributor;
                }
            }
            log.error("No Contributor value found matching: " + valueAsString);
            throw new IOException("No Contributor value found matching: " + valueAsString);
        }
    }
}
