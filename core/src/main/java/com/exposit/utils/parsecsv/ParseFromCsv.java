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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class helps to convert csv files. It provides methods of working with *.csv files.
 * Class provides methods of searching files, parsing from csv, searching for wrong format files
 * and corrupted files.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public final class ParseFromCsv {

    private static final Logger LOG = LoggerFactory.getLogger(ParseFromCsv.class);
    private static final String DIR_SEARCH = "application/src/main/resources/csv/search";
    private static final String DIR_PARSE = "application/src/main/resources/csv/parse";
    private static final String DIR_PARSE_TEMP = "application/src/main/resources/csv/parse/%d";

    private static final String PATTERN = ".*\\.csv";
    private static final String PATTERN_ANY = ".*\\.*";
    private static final File SEARCH_FOLDER = new File(DIR_SEARCH);
    private static final File PARSE_FOLDER = new File(DIR_PARSE);
    private static final String SEARCH_ERROR = "can not move files from search to error directory";
    private static final String SEARCH_PARSE = "can not move files from search to parse directory";
    private static final String SEARCH_SAVE = "can not move files from search to save directory";
    private static final String PARSE = "parse";
    private static final String SAVE = "save";
    private static final String ERROR = "error";
    private static final String SEARCH = "search";

    private ParseFromCsv() {
    }

    /**
     * Checks headers and matching pattern of file.
     * Files that match conditions are moved to parse directory and renamed.
     * Files that don't match conditions are moved to error directory and renamed.
     *
     * @author Yauheni Markevich
     * @see UtilParseCsv#searchCsvTypeFiles(String, File)
     * @see #expectedHeaders(String)
     */
    public static void moveSearchToParseDir() {
        List<String> result = UtilParseCsv.searchCsvTypeFiles(PATTERN, SEARCH_FOLDER);
        if (!result.isEmpty()) {
            for (String path : result) {
                if (expectedHeaders(path)) {
                    String pathNewNanoFile = UtilParseCsv.renameFileNanoTime(path);
                    String pathParse = pathNewNanoFile.replace(SEARCH, PARSE);
                    CacheCsv.writePathToCache(pathParse);
                    try {
                        Files.move(Path.of(path), Path.of(pathParse));
                    } catch (IOException e) {
                        LOG.error(SEARCH_PARSE);
                    }
                } else {
                    String pathNewNanoFile = UtilParseCsv.renameFileNanoTime(path);
                    String pathError = pathNewNanoFile.replace(SEARCH, ERROR);
                    try {
                        Files.move(Path.of(path), Path.of(pathError));
                    } catch (IOException e) {
                        LOG.error(SEARCH_ERROR);
                    }
                }
            }
        }
    }

    /**
     * Move files from search directory to error directory all file, that don't match pattern of method
     * Before moving names of files should be changed to nanotime.*.
     *
     * @author Yauheni Markevich
     * @see UtilParseCsv#searchNotCsvTypeFiles(String, File).
     */
    public static void moveSearchToErrorDir() {
        List<String> result = UtilParseCsv.searchNotCsvTypeFiles(PATTERN, SEARCH_FOLDER);
        if (!result.isEmpty()) {
            for (String path : result) {
                String pathNewNanoFile = UtilParseCsv.renameFileNanoTime(path);
                String pathError = pathNewNanoFile.replace(SEARCH, ERROR);
                try {
                    Files.move(Path.of(path), Path.of(pathError));
                } catch (IOException e) {
                    LOG.error(SEARCH_ERROR);
                }
            }
        }
    }

    /**
     * Check headers of csv file.
     *
     * @param path to file where headers should be checked.
     * @author Yauheni Markevich
     */
    public static boolean expectedHeaders(String path) {
        List<String> expectedHeaders = Arrays.asList("id", "description", "price");
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] header = reader.readNext();
            if (Arrays.asList(header).containsAll(expectedHeaders)) {
                return true;
            }
        } catch (Exception e) {
            LOG.error("csv file doesn't contain headers");
        }
        return false;
    }

    /**
     * Files that are written in cache.txt and their status is "not_parsed" are added to
     * Map<String, String> cache.
     * If exception happen during work of method file is moved to error directory and renamed.
     * Files that match conditions are moved to parse directory and renamed.
     * Files that don't match conditions are moved to error directory and renamed.
     *
     * @author Yauheni Markevich
     * @see UtilParseCsv#searchCsvTypeFiles(String, File)
     * @see #expectedHeaders(String)
     */
    public static Map<List<ShopProductDto>, String> parseEntityFromCsv() {
        Map<String, String> cache = CacheCsv.getDataFromCache();
        for (Map.Entry<String, String> entry : cache.entrySet()) {
            if ("not_parsed".equals(entry.getValue())) {
                try {
                    LOG.error(Thread.currentThread().getName());
                    String pathParse = entry.getKey();
                    List<ShopProductDto> listOfObjects = UtilParseCsv.parseCsv(pathParse);
                    String pathSave = entry.getKey().replace(PARSE, SAVE);
                    entry.setValue(PARSE);
                    CacheCsv.writeMapToCache(cache);
                    Files.move(Path.of(pathParse), Path.of(pathSave));
                    Map<List<ShopProductDto>, String> map = new HashMap<>();
                    map.put(listOfObjects, pathSave);
                    return map;
                } catch (Exception e) {
                    LOG.error(SEARCH_SAVE);
                    String pathError = entry.getKey().replace(PARSE, ERROR);
                    try {
                        entry.setValue(ERROR);
                        CacheCsv.writeMapToCache(cache);
                        Files.move(Path.of(entry.getKey()), Path.of(pathError));
                    } catch (IOException ex) {
                        LOG.error(SEARCH_ERROR);
                    }
                }
            }
        }
        return Collections.emptyMap();
    }

    /**
     * On starting application checks parse directory and
     * moves all files from previous session to error directory.
     *
     * @author Yauheni Markevich
     */
    public static void inspectParseDirForErrors() {
        if (!UtilParseCsv.searchCsvTypeFiles(PATTERN_ANY, PARSE_FOLDER).isEmpty()) {
            for (File fileError : Objects.requireNonNull(PARSE_FOLDER.listFiles())) {
                String path = fileError.getAbsolutePath();
                long nanoTime = System.nanoTime();
                String extension = UtilParseCsv.getFileExtension(path);
                String pathNewNanoFile = String.format(DIR_PARSE_TEMP, nanoTime).concat(extension);

                String pathError = pathNewNanoFile.replace(PARSE, ERROR);
                try {

                    Files.move(Path.of(fileError.getAbsolutePath()), Path.of(pathError));
                } catch (IOException e) {
                    LOG.error(SEARCH_ERROR);
                }
            }
        }
    }
}