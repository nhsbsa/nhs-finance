package com.nhsbsa.CsvDefinitions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by ianfulcher on 14/11/2016.
 *
 * NOTE: Waiting on what R, E, A, D, B corresponds to (14/11/2016)
 */
public enum ContributionTypeEnum {
    R("R"),
    E("E"),
    A("A"),
    D("D"),
    B("B");

    private final String value;

    ContributionTypeEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static class CustomContributionTypeEnumSerializer extends JsonSerializer<ContributionTypeEnum> {

        @Override
        public void serialize(ContributionTypeEnum value, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
            final String output = value.getValue();
            jgen.writeString(output);
        }
    }

}
