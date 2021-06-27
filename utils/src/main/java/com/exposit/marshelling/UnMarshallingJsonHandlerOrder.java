package com.exposit.marshelling;

import com.exposit.model.Order;
import com.exposit.model.Product;
import com.exposit.model.Store;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class UnMarshallingJsonHandlerOrder {
    static ObjectMapper mapper = new ObjectMapper();


    public static List<Order> deSerializeOrder() {

        try {
            String json = Files.readString(Path.of("utils/src/main/resources/order.json"), StandardCharsets.US_ASCII);
            List<Order> orders = Arrays.asList(mapper.readValue(json, Order[].class));
            if (!orders.isEmpty()) {
                return orders;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
