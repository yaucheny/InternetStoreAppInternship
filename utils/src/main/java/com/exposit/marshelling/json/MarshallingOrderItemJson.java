package com.exposit.marshelling.json;

import com.exposit.model.OrderItemEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarshallingOrderItemJson {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String PATH_TO_FILE
            = "utils/src/main/resources/orderItem.json";

    public static void serializeOrderItem(List<OrderItemEntity> entities) {
        try {
            MAPPER.writeValue(new File(
                    PATH_TO_FILE), entities);
            String jsonString = MAPPER.writeValueAsString(entities);
            System.out.println(jsonString);
            String jsonInString2 = MAPPER.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(entities);
            System.out.println(jsonInString2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<OrderItemEntity> deSerializeOrderItem() {
        try {
            String json = Files.readString(Path.of(
                    PATH_TO_FILE),
                    StandardCharsets.US_ASCII);
            List<OrderItemEntity> orderItem = Arrays.asList(MAPPER.readValue(json,
                    OrderItemEntity[].class));
            if (!orderItem.isEmpty()) {
                return orderItem;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
