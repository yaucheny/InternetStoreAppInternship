package com.exposit.model.utils;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Deprecated
public class MyProductDeserializer extends KeyDeserializer {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String deserializeKey(String key,
                                 DeserializationContext deserializationContext)
            throws IOException {
        return key;
    }
}
