package com.nhsbsa.reports;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by ianfulcher on 11/11/2016.
 */
public class CustomBaseAmountSerializer extends JsonSerializer<BigDecimal> {

    private static final int ROUNDING_DP = 4;
    private static final int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

    @Override
    public void serialize(BigDecimal value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        final BigDecimal roundedValue = value.setScale(ROUNDING_DP, ROUNDING_MODE);
        final String roundedOutput = roundedValue.toString();
        jsonGenerator.writeString(roundedOutput);
    }

}
