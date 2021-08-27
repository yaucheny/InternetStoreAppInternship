package com.exposit.utils.marshelling;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MarshallingXml {

    private static final Logger LOG = LoggerFactory.getLogger(MarshallingXml.class);
    private static final XmlMapper MAPPER = new XmlMapper();
    private static final String PATH = "core/src/main/resources/dataxml/";
    private static final String FILE_NOT_FOUND_LOG = "missing *.xml file for entity {}, {}";

    private MarshallingXml() {
    }

    public static <T> void serializeJsonEntity(List<T> entities) {
        if (!entities.isEmpty()) {
            String path = PATH + entities.get(0).getClass().getSimpleName() + ".xml";
            File file = new File(path);
            try {
                if (!file.createNewFile()) {
                    MAPPER.writeValue(new File(path), entities);
                    MAPPER.writeValueAsString(entities);
                    MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(entities);
                }
            } catch (IOException e) {
                LOG.error(FILE_NOT_FOUND_LOG, path, e.getStackTrace());
            }
        }
    }

    public static <T> List<T> deserializeXmlEntity(Class<T> classOnWhichArrayIsDefined) {
        String json;
        String path = PATH + classOnWhichArrayIsDefined.getSimpleName() + ".xml";
        File file = new File(path);
        try {
            if (!file.createNewFile()) {
                json = Files.readString(Path.of(path), StandardCharsets.UTF_8);
                Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + classOnWhichArrayIsDefined.getName() + ";");
                T[] objects = MAPPER.readValue(json, arrayClass);
                if (objects.length > 0) {
                    return Arrays.asList(objects);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            LOG.error(FILE_NOT_FOUND_LOG, path, e.getStackTrace());
        }
        return Collections.emptyList();
    }
}
