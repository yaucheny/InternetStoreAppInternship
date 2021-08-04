package com.exposit.marshelling.json;

import com.exposit.model.CustomerEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarshallingCustomerJson {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String PATH_TO_FILE = "utils/src/main/resources/customer.json";

    private MarshallingCustomerJson() {
    }

    public static void serializeCustomer(List<CustomerEntity> entities) {
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

    public static List<CustomerEntity> deSerializeCustomer() {
        try {
            String json = Files.readString(Path.of(PATH_TO_FILE), StandardCharsets.US_ASCII);
            List<CustomerEntity> customers = Arrays.asList(MAPPER.readValue(json, CustomerEntity[].class));
            if (!customers.isEmpty()) {
                return customers;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
