package com.exposit.marshelling;

import com.exposit.model.Order;
import com.exposit.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MarshallingJsonHandlerOrder {
    static ObjectMapper mapper = new ObjectMapper();

    public static void serializeOrder(List<Order> entities) {
        try {

            mapper.writeValue(new File("utils/src/main/resources/order.json"), entities);

            String jsonString = mapper.writeValueAsString(entities);

                        System.out.println(jsonString);
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entities);

            // System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
