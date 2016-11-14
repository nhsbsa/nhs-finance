package com.nhsbsa.CsvDefinitions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by ianfulcher on 14/11/2016.
 *
 * We think INV and CRN mean Invoice/Credit Note respectively (discussed with Mark D)
 */
public enum PaymentTypeEnum {
    Invoice("INV"),
    CreditNote("CRN");

    private final String value;

    PaymentTypeEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static class CustomPaymentTypeEnumSerializer extends JsonSerializer<PaymentTypeEnum> {

        @Override
        public void serialize(PaymentTypeEnum value, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
            final String output = value.getValue();
            jgen.writeString(output);
        }
    }

}
