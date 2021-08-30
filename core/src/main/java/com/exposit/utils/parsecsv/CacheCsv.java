package com.exposit.utils.parsecsv;

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

public final class CacheCsv {

    private static final Map<String, String> CACHE = new LinkedHashMap<>();
    private static final String VALUE = "not_parsed";
    private static final String FILE_CACHE = "application/src/main/resources/csv/cache.txt";

    private CacheCsv() {
    }

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
                    CACHE.put(path, value);
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
        return CACHE;
    }

    public static void writeMapToCache(Map<String, String> map) {
        File file = new File(FILE_CACHE);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file, false));
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

    public static void clearCasheFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILE_CACHE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }
}