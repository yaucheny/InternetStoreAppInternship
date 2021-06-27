package com.exposit.marshelling;

import com.exposit.model.AEntity;
import com.exposit.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MarshallingJsonHandlerProduct {

    static ObjectMapper mapper = new ObjectMapper();

    public static void serializeProduct(List<Product> entities) {
        try {

            mapper.writeValue(new File("utils/src/main/resources/product.json"), entities);

            String jsonString = mapper.writeValueAsString(entities);
            System.out.println(jsonString);
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entities);

           // System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

