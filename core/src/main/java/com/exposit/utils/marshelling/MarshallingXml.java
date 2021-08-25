package com.exposit.utils.marshelling;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarshallingXml {
    private static final XmlMapper MAPPER = new XmlMapper();
    private static final String PATH = "core/src/main/resources/dataxml/";

    public static <T> void serializeJsonEntity(List<T> entities) {
        if (!entities.isEmpty()) {
            String path = PATH + entities.get(0).getClass().getSimpleName() + ".xml";
            try {
                MAPPER.writeValue(new File(path), entities);
                MAPPER.writeValueAsString(entities);
                MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(entities);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> List<T> deserializeXmlEntity(Class<T> classOnWhichArrayIsDefined) {

        String json = null;
        String path = PATH + classOnWhichArrayIsDefined.getSimpleName() + ".xml";
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
