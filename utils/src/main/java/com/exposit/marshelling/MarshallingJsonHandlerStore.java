package com.exposit.marshelling;

import com.exposit.model.Product;
import com.exposit.model.Store;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MarshallingJsonHandlerStore {
    static ObjectMapper mapper = new ObjectMapper();

    public static void serializeStore(List<Store> entities) {
        try {

            mapper.writeValue(new File("utils/src/main/resources/store.json"), entities);

            String jsonString = mapper.writeValueAsString(entities);
            System.out.println(jsonString);
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entities);

            // System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
