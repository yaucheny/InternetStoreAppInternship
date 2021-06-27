package com.exposit.marshelling;

import com.exposit.model.Product;
import com.exposit.model.Store;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnMarshallingJsonHandlerProduct {
    static ObjectMapper mapper = new ObjectMapper();


    public static List<Product> deSerializeProduct() {

        try {
            String json = Files.readString(Path.of("utils/src/main/resources/product.json"), StandardCharsets.US_ASCII);

            List<Product> product = Arrays.asList(mapper.readValue(json, Product[].class));
            if (!product.isEmpty()) {
                return product;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
