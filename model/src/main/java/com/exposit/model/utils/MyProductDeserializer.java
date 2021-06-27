package com.exposit.model.utils;

import com.exposit.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class MyProductDeserializer extends KeyDeserializer {

    private static final ObjectMapper mapper = new ObjectMapper();
    @Override
    public String deserializeKey(String key, DeserializationContext deserializationContext) throws IOException {


        return key;
    }
}
