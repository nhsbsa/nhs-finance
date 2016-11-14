package com.nhsbsa.CsvDefinitions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by ianfulcher on 11/11/2016.
 *
 * Rounding Mode:-
 * ROUND_HALF_DOWN    - Rounding mode to round towards "nearest neighbour" unless both neighbours are equidistant, in which case round down.
 * ROUND_CEILING      - Rounding mode to round towards positive infinity.
 * ROUND_DOWN         - Rounding mode to round towards zero.
 * ROUND_FLOOR        - Rounding mode to round towards negative infinity.
 * ROUND_HALF_EVEN    - Rounding mode to round towards the "nearest neighbour" unless both neighbours are equidistant, in which case, round towards the even neighbour.
 * ROUND_HALF_UP      - Rounding mode to round towards "nearest neighbour" unless both neighbours are equidistant, in which case round up.
 * ROUND_UP           - Rounding mode to round away from zero.
 */
public class CustomBaseAmountSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
            JsonProcessingException {

        // Desired style here setScale(Scale of the BigDecimal to return, Rounding mode)
        jgen.writeString(value.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }

}
