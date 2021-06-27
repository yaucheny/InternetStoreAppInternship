package com.exposit.marshelling;

import com.exposit.model.Customer;
import com.exposit.model.Store;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnMarshallingJsonHandlerCustomer {
    static ObjectMapper mapper = new ObjectMapper();


    public static List<Customer> deSerializeCustomer() {

        try {
            String json = Files.readString(Path.of("utils/src/main/resources/customer.json"), StandardCharsets.US_ASCII);

            List<Customer> customers = Arrays.asList(mapper.readValue(json, Customer[].class));
            if (!customers.isEmpty()) {
                return customers;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
