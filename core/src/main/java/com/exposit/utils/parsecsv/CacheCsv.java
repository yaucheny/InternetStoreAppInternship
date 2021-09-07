package com.exposit.utils.parsecsv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class helps to convert csv files. It provides methods of working with cache.txt file
 * {@see application/src/main/resources/csv}, where info about process of parsing is saved.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public final class CacheCsv {

    private static final Logger LOG = LoggerFactory.getLogger(CacheCsv.class);
    private static final Map<String, String> CACHE = new LinkedHashMap<>();
    private static final String VALUE = "not_parsed";
    private static final String FILE_CACHE = "application/src/main/resources/csv/cache.txt";

    private CacheCsv() {
    }

    /**
     * Adds new string with path of file and status to cache.txt
     * {@see application/src/main/resources/csv/cache.txt}.
     *
     * @param path path to csv file.
     * @author Yauheni Markevich
     */
    public static void writePathToCache(String path) {
        File file = new File(FILE_CACHE);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, true))) {
            bf.write(path + ":" + VALUE);
            bf.newLine();
            bf.flush();
        } catch (IOException e) {
            LOG.error("can not write path to cache");
        }
    }

    /**
     * Reads file cache.txt and put data to Map<String, String> cache,
     * where key is path to csv file, value status of file.
     * {@see application/src/main/resources/csv/cache.txt}
     *
     * @return Map<String, String> cache,
     * where key is path to csv file, value status of file.
     * @author Yauheni Markevich
     */
    public static Map<String, String> getDataFromCache() {
        File file = new File(FILE_CACHE);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                String path = parts[0].trim();
                String value = parts[1].trim();
                if (!path.equals("") && !value.equals("")) {
                    CACHE.put(path, value);
                }
            }
        } catch (Exception e) {
            LOG.error("can not get data from cache cache");
        }
        return CACHE;
    }

    /**
     * Rewrite all data from Map<String, String> cache to cache.txt.
     * {@see application/src/main/resources/csv/cache.txt}
     *
     * @param cache Map, where key is path to csv file, value status of file.
     * @throws com.exposit.utils.exceptions.FileNotFoundException if file is not found.
     * @author Yauheni Markevich
     */
    public static void writeMapToCache(Map<String, String> cache) {
        File file = new File(FILE_CACHE);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, false))) {
            for (Map.Entry<String, String> entry : cache.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            LOG.error("can not save data to cache");
        }
    }

    /**
     * Remove all data from cache.txt.
     * {@see application/src/main/resources/csv/cache.txt}
     *
     * @throws com.exposit.utils.exceptions.FileNotFoundException if file is not found.
     * @author Yauheni Markevich
     */
    public static void clearCasheFile() {
        try (PrintWriter writer = new PrintWriter(FILE_CACHE)) {
            writer.print("");
        } catch (FileNotFoundException e) {
            LOG.error("can not clean txt cache file");
        }
    }
}