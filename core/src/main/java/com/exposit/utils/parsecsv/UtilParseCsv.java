package com.exposit.utils.parsecsv;

import com.exposit.domain.dto.ShopProductDto;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UtilParseCsv {

    private static final String DIR_PARSE_TEMP = "application/src/main/resources/csv/parse/%d";
    private static final Logger LOG = LoggerFactory.getLogger(UtilParseCsv.class);

    public static List<String> searchAnyTypeFiles(String pattern, File searchFolder) {
        List<String> result = new ArrayList<>();
        for (File f : Objects.requireNonNull(searchFolder.listFiles())) {
            if (f.isDirectory()) {
                searchAnyTypeFiles(pattern, f);
            }
            if (f.isFile() && !f.getName().matches(pattern)) {
                result.add(f.getAbsolutePath());
            }
        }
        return result;
    }

    public static String renameFileNanoTime(String path) {
        long nanoTime = System.nanoTime();
        String extension = UtilParseCsv.getFileExtension(path);
        return String.format(DIR_PARSE_TEMP, nanoTime).concat(extension);
    }

    private static String getFileExtension(String path) {
        int lastIndexOf = path.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return path.substring(lastIndexOf);
    }

    public static List<ShopProductDto> parseCsv(String path) {
        try (FileReader cswReader = new FileReader(path)) {
            List<ShopProductDto> beans = new CsvToBeanBuilder(cswReader)
                    .withType(ShopProductDto.class)
                    .build().parse();
            LOG.error(Thread.currentThread().getName());
            return beans;
        } catch (Exception e) {
            LOG.warn("parce csv", e);
            e.getLocalizedMessage();
        }
        return Collections.emptyList();
    }
}
