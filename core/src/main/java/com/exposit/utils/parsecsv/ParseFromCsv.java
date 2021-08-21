package com.exposit.utils.parsecsv;

import com.exposit.domain.model.db.ShopProductDb;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.log4j.Log4j;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Log4j
public final class ParseFromCsv {
    private static Integer i = 0;
    private static final String FILE_PATH_SEARCHING_DIRECTORY = "application/src/main/resources/csv/search" +
            "/product_shops_.csv";
    private static final String FILE_PATH_SAVING_DIRECTORY = "application/src/main/resources/csv/save/product_shops_" +
            "%s.csv";
    private static final String FILE_PATH_PARSING_DIRECTORY = "application/src/main/resources/csv/parse" +
            "/product_shops_.csv";
    private static final String DIRECTORY_PATH_SEARCHING = "application/src/main/resources/csv/search";
    private static final String DIRECTORY_PATH_PARSING = "application/src/main/resources/csv/parse";


    private ParseFromCsv() {
    }

    public static List<ShopProductDb> parseFileFromCsv() {
        if (ParseFromCsv.isDirNotEmpty(DIRECTORY_PATH_PARSING)) {
            try (FileReader cswReader = new FileReader(FILE_PATH_PARSING_DIRECTORY)) {
                List<ShopProductDb> beans = new CsvToBeanBuilder(cswReader)
                        .withType(ShopProductDb.class)
                        .build()
                        .parse();
                return beans;
            } catch (Exception e) {
                log.warn("", e);
                e.getLocalizedMessage();
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    public static boolean moveToParseDir() {
        if (ParseFromCsv.isDirNotEmpty(DIRECTORY_PATH_SEARCHING)) {
            try {
                Files.move(Paths.get(FILE_PATH_SEARCHING_DIRECTORY),
                        Paths.get(FILE_PATH_PARSING_DIRECTORY));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void moveToSaveDirChangeName() {
        if (ParseFromCsv.isDirNotEmpty(DIRECTORY_PATH_PARSING)) {
            i++;
            String s = i.toString();
            try {
                Files.move(Paths.get(FILE_PATH_PARSING_DIRECTORY),
                        Paths.get(String.format(FILE_PATH_SAVING_DIRECTORY, s)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isDirNotEmpty(String path) {
        File file = new File(path);
        if (file.list().length > 0) {
            return true;
        }
        return false;
    }
}
