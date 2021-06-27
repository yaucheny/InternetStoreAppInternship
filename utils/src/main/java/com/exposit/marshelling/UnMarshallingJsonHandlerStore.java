package com.exposit.marshelling;

import com.exposit.model.Customer;
import com.exposit.model.Product;
import com.exposit.model.Store;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnMarshallingJsonHandlerStore {
    static ObjectMapper mapper = new ObjectMapper();


    public static List<Store> deSerializeStore() {

        try {
            String json = Files.readString(Path.of("utils/src/main/resources/store.json"), StandardCharsets.US_ASCII);

            List<Store> store = Arrays.asList(mapper.readValue(json, Store[].class));
            if (!store.isEmpty()) {
                return store;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  Collections.emptyList();
    }
}

