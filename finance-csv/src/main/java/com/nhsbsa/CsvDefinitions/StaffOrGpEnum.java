package com.nhsbsa.CsvDefinitions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by ianfulcher on 14/11/2016.
 */
public enum StaffOrGpEnum {
    GP("G"),
    STAFF("S");

    private final String value;

    StaffOrGpEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static class CustomStaffGpEnumSerializer extends JsonSerializer<StaffOrGpEnum> {

        @Override
        public void serialize(StaffOrGpEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            final String output = value.getValue();
            gen.writeString(output);
        }
    }

}
