package com.exposit.utils.parsecsv;

import com.exposit.domain.dto.ShopProductDto;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class ParseFromCsv {

    private static final Logger LOG = LoggerFactory.getLogger(ParseFromCsv.class);
    private static final String DIR_SEARCH = "application/src/main/resources/csv/search";
    private static final String DIR_PARSE = "application/src/main/resources/csv/parse";

    private static final String PATTERN = ".*\\.csv";
    private static final String PATTERN_ANY = ".*\\.*";
    private static final File SEARCH_FOLDER = new File(DIR_SEARCH);
    private static final File PARSE_FOLDER = new File(DIR_PARSE);

    private ParseFromCsv() {
    }

    public static void moveSearchToParseDir() {
        if (!UtilParseCsv.searchAnyTypeFiles(PATTERN, SEARCH_FOLDER).isEmpty()) {
            List<String> result = UtilParseCsv.searchAnyTypeFiles(PATTERN, SEARCH_FOLDER);
            for (String path : result) {
                if (expectedHeaders(path)) {
                    String pathNewNanoFile = UtilParseCsv.renameFileNanoTime(path);
                    CacheCsv.writePathToCache(path);
                    try {
                        Files.move(Path.of(path), Path.of(pathNewNanoFile));
                    } catch (IOException e) {
                        LOG.error("moveToParseDir");
                    }
                } else {
                    String pathNewNanoFile = UtilParseCsv.renameFileNanoTime(path);
                    String pathError = pathNewNanoFile.replace("search", "error");
                    try {
                        Files.move(Path.of(path), Path.of(pathError));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void moveSearchToErrorDir() {
        List<String> result = UtilParseCsv.searchAnyTypeFiles(PATTERN, SEARCH_FOLDER);
        if (!result.isEmpty()) {
            for (String path : result) {
                LOG.error(Thread.currentThread().getName() + "move to err dir");
                String pathNewNanoFile = UtilParseCsv.renameFileNanoTime(path);
                String pathError = pathNewNanoFile.replace("search", "error");
                try {
                    Files.move(Path.of(path), Path.of(pathError));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean expectedHeaders(String path) {
        List<String> expectedHeaders = Arrays.asList("id", "description", "price");
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] header = reader.readNext();
            if (Arrays.asList(header).containsAll(expectedHeaders)) {
                return true;
            }
        } catch (Exception e) {
            LOG.warn("parse csv", e);
            e.getLocalizedMessage();
        }
        return false;
    }

    public static List<ShopProductDto> parseEntityFromCsv() {
        Map<String, String> cache = CacheCsv.getDataFromCache();
        for (Map.Entry<String, String> entry : cache.entrySet()) {
            if ("not_parsed".equals(entry.getValue())) {
                try {
                    LOG.error(Thread.currentThread().getName() + 111111111);
                    String pathParse = entry.getKey();
                    List<ShopProductDto> listOfObjects = UtilParseCsv.parseCsv(pathParse);
                    String pathSave = entry.getKey().replace("parse", "save");
                    entry.setValue("parsed");
                    CacheCsv.writeMapToCache(cache);
                    Files.move(Path.of(pathParse), Path.of(pathSave));
                    return listOfObjects;
                } catch (Exception e) {
                    LOG.error("ERORRRRR");
                    String pathError = entry.getKey().replace("parse", "error");
                    try {
                        entry.setValue("error");
                        CacheCsv.writeMapToCache(cache);
                        Files.move(Path.of(entry.getKey()), Path.of(pathError));
                    } catch (IOException ex) {
                        LOG.error("replace");
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    public static void inspectParseDirForErrors() {
        if (!UtilParseCsv.searchAnyTypeFiles(PATTERN_ANY, PARSE_FOLDER).isEmpty()) {
            for (File fileError : Objects.requireNonNull(PARSE_FOLDER.listFiles())) {
                String path = fileError.getAbsolutePath();
                String pathNewNanoFile = UtilParseCsv.renameFileNanoTime(path);
                String pathError = pathNewNanoFile.replace("parse", "error");
                try {

                    Files.move(Path.of(fileError.getAbsolutePath()), Path.of(pathError));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}