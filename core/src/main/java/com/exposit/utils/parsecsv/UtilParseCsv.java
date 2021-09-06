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

/**
 * Util class, it provides for class ParseFromCsv.class {@link com.exposit.utils.parsecsv.ParseFromCsv}
 * methods of working with *.csv files.
 * Class provides methods of searching files, parsing from csv, searching for wrong format files
 * and corrupted files.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public final class UtilParseCsv {

    private static final String DIR_PARSE_TEMP = "application/src/main/resources/csv/search/%d";
    private static final Logger LOG = LoggerFactory.getLogger(UtilParseCsv.class);

    private UtilParseCsv() {
    }

    /**
     * Search for files in folder which not match to pattern.
     *
     * @param pattern      Pattern of file extension
     * @param searchFolder Folder where search should take place
     * @return List of files that are placed in directory and not match to pattern, or return empty List,
     * @author Yauheni Markevich
     */
    public static List<String> searchNotCsvTypeFiles(String pattern, File searchFolder) {
        List<String> result = new ArrayList<>();
        for (File f : Objects.requireNonNull(searchFolder.listFiles())) {
            if (f.isDirectory()) {
                searchNotCsvTypeFiles(pattern, f);
            }
            if (f.isFile() && !f.getName().matches(pattern)) {
                result.add(f.getAbsolutePath());
            }
        }
        return result;
    }

    /**
     * Search for files in folder which match to pattern.
     *
     * @param pattern      Pattern of file extension
     * @param searchFolder Folder where search should take place
     * @return List of files that are placed in directory and match to pattern, or return empty List,
     * @author Yauheni Markevich
     */
    public static List<String> searchCsvTypeFiles(String pattern, File searchFolder) {
        List<String> result = new ArrayList<>();
        for (File f : Objects.requireNonNull(searchFolder.listFiles())) {
            if (f.isDirectory()) {
                searchNotCsvTypeFiles(pattern, f);
            }
            if (f.isFile() && f.getName().matches(pattern)) {
                result.add(f.getAbsolutePath());
            }
        }
        return result;
    }

    /**
     * Renames file to nanotime.* name.
     *
     * @param path path to file to rename.
     * @return new path to file with nanotime.* file name,
     * @author Yauheni Markevich
     */
    public static String renameFileNanoTime(String path) {
        long nanoTime = System.nanoTime();
        String extension = UtilParseCsv.getFileExtension(path);
        return String.format(DIR_PARSE_TEMP, nanoTime).concat(extension);
    }

    /**
     * Returns extension of the file.
     *
     * @param path path to file to rename.
     * @return returns extension of the file.
     * @author Yauheni Markevich
     */
    public static String getFileExtension(String path) {
        int lastIndexOf = path.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return path.substring(lastIndexOf);
    }

    /**
     * Parses csv file to List<ShopProduct>.
     * Parsing is made with the help of CsvParser library
     *
     * @param path path to file to parse
     * @return List of shopProducts from csv file
     * @author Yauheni Markevich
     */
    public static List<ShopProductDto> parseCsv(String path) {
        try (FileReader cswReader = new FileReader(path)) {
            List<ShopProductDto> beans = new CsvToBeanBuilder(cswReader)
                    .withType(ShopProductDto.class)
                    .build().parse();
            LOG.error(Thread.currentThread().getName());
            return beans;
        } catch (Exception e) {
            LOG.error("can not parse csv file");
        }
        return Collections.emptyList();
    }
}
