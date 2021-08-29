package com.exposit.utils.marshelling.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class AbstractMarshallerJson<T> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String PATH_TO_FILE = "utils/src/main/resources/category.json";

    public  void serializeEntity(List<T> entities) {
        try {
            MAPPER.writeValue(new File(PATH_TO_FILE), entities);
            MAPPER.writeValueAsString(entities);
            MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(entities);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> deSerializeEntity() {
        try {
            String json = Files.readString(Path.of(PATH_TO_FILE), StandardCharsets.UTF_8);
            List<T> entity = MAPPER.readValue(json, new TypeReference<List<T>>() {
            });
            if (!entity.isEmpty()) {
                return entity;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
