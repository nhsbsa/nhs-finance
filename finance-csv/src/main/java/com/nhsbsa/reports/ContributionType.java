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
public enum ContributionType {
    R("R"),
    E("E"),
    A("A"),
    D("D"),
    B("B");

    private final String value;

    ContributionType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static class Serializer extends JsonSerializer<ContributionType> {

        @Override
        public void serialize(ContributionType contributionType, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
            final String output = contributionType.getValue();
            jsonGenerator.writeString(output);
        }
    }

    public static class Deserializer extends JsonDeserializer<ContributionType> {

        @Override
        public ContributionType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            final String valueAsString = jsonParser.getValueAsString();
            for (final ContributionType contributionType : ContributionType.values()) {
                if (contributionType.getValue().equals(valueAsString)) {
                    return contributionType;
                }
            }
            log.error("No ContributionType value found matching: " + valueAsString);
            throw new IOException("No ContributionType value found matching: " + valueAsString);
        }
    }
}
