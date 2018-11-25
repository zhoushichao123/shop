package com.fh.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalJackson extends JsonSerializer<BigDecimal> {

    public void serialize(BigDecimal bigDecimal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (null==bigDecimal){
            jsonGenerator.writeString("");
        }else{
            jsonGenerator.writeString(bigDecimal.toString());
        }
    }

}
