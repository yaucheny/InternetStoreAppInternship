package com.exposit.utils.parsecsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CacheCsv {

    private static Map<String, String> cache = new LinkedHashMap<>();
    private final static String VALUE = "not_parsed";
    private static final String FILE_CACHE = "application/src/main/resources/csv/cache.txt";

    public static void writePathToCache(String path) {
        File file = new File(FILE_CACHE);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file, true));
            bf.write(path + ":" + VALUE);
            bf.newLine();
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
            }
        }
    }

    public static Map<String, String> getDataFromCache() {
        BufferedReader br = null;
        try {
            File file = new File(FILE_CACHE);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                String path = parts[0].trim();
                String value = parts[1].trim();

                if (!path.equals("") && !value.equals(""))
                    cache.put(path, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
        return cache;
    }

    public static void writeMapToCache(Map<String, String> map) {
        File file = new File(FILE_CACHE);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
            }
        }
    }
}