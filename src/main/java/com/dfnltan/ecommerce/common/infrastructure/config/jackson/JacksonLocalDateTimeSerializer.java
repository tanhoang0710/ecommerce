package com.dfnltan.ecommerce.common.infrastructure.config.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class JacksonLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    public JacksonLocalDateTimeSerializer() {
        super();
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        long epoch = localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        jsonGenerator.writeNumber(epoch);
    }


}
