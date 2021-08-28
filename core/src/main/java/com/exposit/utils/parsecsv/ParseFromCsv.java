package com.exposit.utils.parsecsv;

import com.exposit.domain.dto.ShopProductDto;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class ParseFromCsv {

    private static final Logger LOG = LoggerFactory.getLogger(ParseFromCsv.class);
    private static Integer i = 0;
    private static final String FILE_SEARCHING_DIR = "application/src/main/resources/csv/search/product_shops_.csv";
    private static final String FILE_SAVING_DIR = "application/src/main/resources/csv/save/product_shops_%s.csv";
    private static final String FILE_PARSING_DIR = "application/src/main/resources/csv/parse/product_shops_.csv";
    private static final String DIRECTORY_PATH_SEARCHING = "application/src/main/resources/csv/search";
    private static final String DIRECTORY_PATH_PARSING = "application/src/main/resources/csv/parse";


    private static final String DIR_SEARCH = "application/src/main/resources/csv/search";
    private static final String DIR_SAVE = "application/src/main/resources/csv/save";
    private static final String DIR_ERROR = "application/src/main/resources/csv/error";
    private static final String DIR_PARSE = "application/src/main/resources/csv/parse";

    private static final String DIR_DIR_PARSE_TEMP_TEMP = "application/src/main/resources/csv/parse/%d";


    private static final String PATTERN = ".*\\.csv";
    private static final File searchFolder = new File(DIR_SEARCH);
    private static List<String> result = new ArrayList<>();

    private ParseFromCsv() {
    }

    public static void moveToParseDir() {
        if (!ParseFromCsv.searchFiles(PATTERN, searchFolder, result).isEmpty()) {
            long nanoTime;
            String pathNewNanoFile;
            for (String path : result) {
                nanoTime = System.nanoTime();
                pathNewNanoFile = String.format(DIR_DIR_PARSE_TEMP_TEMP, nanoTime).concat(".csv");
                CacheCsv.writePathToCache(pathNewNanoFile);
                try {
                    Files.move(Path.of(path), Path.of(pathNewNanoFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static List<ShopProductDto> parseFileFromCsv() {
        if (ParseFromCsv.isDirNotEmpty(DIRECTORY_PATH_PARSING)) {
            try (FileReader cswReader = new FileReader(FILE_PARSING_DIR)) {
                return new CsvToBeanBuilder(cswReader)
                        .withType(ShopProductDto.class)
                        .build()
                        .parse();
            } catch (Exception e) {
                LOG.warn("", e);
                e.getLocalizedMessage();
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    public static List<ShopProductDto> parseEntityFromCsv() {
        Map<String, String> cache = CacheCsv.getDataFromCache();
        for (Map.Entry<String, String> entry : cache.entrySet()) {
            if ("not_parsed".equals(entry.getValue())) {
                try {
                    List<ShopProductDto> listOfObjects = parceCsv(entry.getKey());
                    String pathSave = entry.getKey().replace("parse", "save");
                    Files.move(Path.of(entry.getKey()), Path.of(pathSave));
                    entry.setValue("parsed");
                    CacheCsv.writeMapToCache(cache);
                    return listOfObjects;
                } catch (Exception e) {
                    LOG.error("!!!!!!!!!!");
                } finally {
                    String pathError = entry.getKey().replace("parse", "error");
                    try {
                        Files.move(Path.of(entry.getKey()), Path.of(pathError));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return Collections.emptyList();
    }

//    public static void moveToSaveDirChangeName() {
//        if (ParseFromCsv.isDirNotEmpty(DIRECTORY_PATH_PARSING)) {
//            i++;
//            String s = i.toString();
//            try {
//                Files.move(Paths.get(FILE_PARSING_DIR),
//                        Paths.get(String.format(FILE_SAVING_DIR, s)));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private static boolean isDirNotEmpty(String path) {
        File file = new File(path);
        return Objects.requireNonNull(file.list()).length > 0;
    }

    private static List<String> searchFiles(String pattern, File searchFolder, List<String> result) {
        for (File f : Objects.requireNonNull(searchFolder.listFiles())) {
            if (f.isDirectory()) {
                searchFiles(pattern, f, result);
            }
            if (f.isFile() && f.getName().matches(pattern)) {
                result.add(f.getAbsolutePath());
            }
        }
        return result;
    }

    private static void deleteDirectory(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            LOG.error("!!!!!!");
        }
    }

    private static List<ShopProductDto> parceCsv(String path) {
        try (FileReader cswReader = new FileReader(path)) {
            return new CsvToBeanBuilder(cswReader)
                    .withType(ShopProductDto.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            LOG.warn("", e);
            e.getLocalizedMessage();
        }
        return Collections.emptyList();
    }


    public static void moveToParseDirTemp() {
        if (!ParseFromCsv.searchFiles(PATTERN, searchFolder, result).isEmpty()) {
            long nanoTime;
            Path pathNewDir;
            for (String path : result) {
                nanoTime = System.nanoTime();
                pathNewDir = Paths.get(String.format(DIR_DIR_PARSE_TEMP_TEMP, nanoTime));
                String newNameOfFile = pathNewDir + "/" + nanoTime + ".csv";
                try {
                    Files.createDirectory(pathNewDir);
                    Files.move(Path.of(path), Path.of(newNameOfFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}