package com.exposit.marshelling.json;

import com.exposit.model.db.ProductDb;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MarshallingProductJson {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String PATH_TO_FILE = "utils/src/main/resources/product.json";

    private MarshallingProductJson() {
    }

    public static void serializeProduct(List<ProductDb> entities) {
        try {
            MAPPER.writeValue(new File(PATH_TO_FILE), entities);
            String jsonString = MAPPER.writeValueAsString(entities);
            System.out.println(jsonString);
            String jsonInString2 = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(entities);
            System.out.println(jsonInString2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ProductDb> deSerializeProduct() {
        try {
            String json = Files.readString(Path.of(PATH_TO_FILE), StandardCharsets.UTF_8);
            List<ProductDb> product = Arrays.asList(MAPPER.readValue(json, ProductDb[].class));
            if (!product.isEmpty()) {
                return product;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

