package com.exposit.utils.marshelling;

import com.exposit.domain.model.db.BaseDb;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarshallingJson<T extends BaseDb> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String PATH = "core/src/main/resources/datajson/";

    public static <T> void serializeJsonEntity(List<T> entities) {
        if (!entities.isEmpty()) {
            String path = PATH + entities.get(0).getClass().getSimpleName() + ".json";
            try {
                MAPPER.writeValue(new File(path), entities);
                MAPPER.writeValueAsString(entities);
                MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(entities);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> List<T> deserializeJsonEntity(Class<T> classOnWhichArrayIsDefined) {
        String json = null;
        String path = PATH + classOnWhichArrayIsDefined.getSimpleName() + ".json";
        try {
            json = Files.readString(Path.of(path), StandardCharsets.UTF_8);
            Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + classOnWhichArrayIsDefined.getName() + ";");
            T[] objects = MAPPER.readValue(json, arrayClass);
            if (objects.length > 0) {
                return Arrays.asList(objects);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
