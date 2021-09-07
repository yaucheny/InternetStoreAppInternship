package com.exposit.utils.marshelling;

import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 * Class is responsible for marshalling and unmarshalling objects in json format.
 * Marshalling and Unmarshalling is provided by Jackson library.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public final class MarshallingJson {

    private static final Logger LOG = LoggerFactory.getLogger(MarshallingJson.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String FILE_NOT_FOUND_LOG = "missing *.json file for entity {}, {}";
    private static final String PATH = "core/src/main/resources/datajson/";

    private MarshallingJson() {
    }

    /**
     * Serializes data in json format to file.
     *
     * @param <T>      Type of element stored in List
     * @param entities List of entities type <T>
     * @author Yauheni Markevich
     */
    public static <T> void serializeJsonEntity(List<T> entities) {
        LOG.debug("execution serialization method");
        if (!entities.isEmpty()) {
            String path = PATH + entities.get(0).getClass().getSimpleName() + ".json";
            File file = new File(path);
            try {
                if (!file.createNewFile()) {
                    MAPPER.writeValue(new File(path), entities);
                    MAPPER.writeValueAsString(entities);
                    MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(entities);
                }
            } catch (IOException e) {
                LOG.error(FILE_NOT_FOUND_LOG, path, e.getLocalizedMessage());
            }
        }
    }

    /**
     * Deserializes data from file to json format.
     *
     * @param <T>                        Type of element stored in List
     * @param classOnWhichArrayIsDefined Class.class of entities from file
     * @return List<Class.class> of entities.
     * @author Yauheni Markevich
     */
    public static <T> List<T> deserializeJsonEntity(Class<T> classOnWhichArrayIsDefined) {
        LOG.debug("execution deserialization method");
        String json;
        String path = PATH + classOnWhichArrayIsDefined.getSimpleName() + ".json";
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
            LOG.error(FILE_NOT_FOUND_LOG, path, e.getLocalizedMessage());
        }
        return Collections.emptyList();
    }
}
