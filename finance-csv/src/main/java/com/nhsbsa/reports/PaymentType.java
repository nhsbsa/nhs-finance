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
public enum PaymentType {
    INVOICE("INV"),
    CREDIT_NOTE("CRN");

    private final String value;

    PaymentType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static class Serializer extends JsonSerializer<PaymentType> {

        @Override
        public void serialize(PaymentType value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
            final String output = value.getValue();
            jsonGenerator.writeString(output);
        }
    }

    public static class Deserializer extends JsonDeserializer<PaymentType> {

        @Override
        public PaymentType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            final String valueAsString = jsonParser.getValueAsString();
            for (final PaymentType paymentType : PaymentType.values()) {
                if (paymentType.getValue().equals(valueAsString)) {
                    return paymentType;
                }
            }
            log.error("No PaymentType value found matching: " + valueAsString);
            throw new IOException("No PaymentType value found matching: " + valueAsString);
        }
    }

}
