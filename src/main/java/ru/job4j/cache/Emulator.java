package ru.job4j.cache;

import java.io.File;
import java.nio.file.Paths;

public class Emulator {
    public static DirFileCache emulateCache(String cachingDir) {
        File file = Paths.get(cachingDir).toFile();
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsolutePath()));
        }
        return new DirFileCache(cachingDir);
    }

    public static void putCache(DirFileCache dirFileCache, String key, String value) {
        dirFileCache.put(key, value);
    }

    public static String loadCache(DirFileCache dirFileCache, String key) {
        return dirFileCache.get(key);
    }

    public static void main(String[] args) {
        DirFileCache dirFileCache = emulateCache(
                "/Users/adletbaitorynov/Downloads/Java_projects/job4j_grabber/src/main/resources");
        putCache(dirFileCache, "key", "value");
        System.out.println(loadCache(dirFileCache, "Names.txt"));
        System.out.println(loadCache(dirFileCache, "key"));
        System.out.println(loadCache(dirFileCache, "not_exist"));
    }
}
