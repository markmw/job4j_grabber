package ru.job4j.cache;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Emulator {
    private static String answer(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void check(String dir) {
        if (!Paths.get(dir).toFile().exists()) {
            throw new IllegalArgumentException(String.format("No such file: %s", dir));
        }
    }

    private static void check(String dir, String name) {
        if (!Paths.get(dir).toFile().exists()) {
            throw new IllegalArgumentException(String.format("No such file: %s in this directory", name, dir));
        }
    }

    public static void main(String[] args) {
        System.out.println("Укажите директорию:");
        Scanner scanner = new Scanner(System.in);
        String dir = answer(scanner);
        check(dir);
        DirFileCache dirFileCache = new DirFileCache(dir);
        int answer = 0;
        while (answer != 4) {
            System.out.println("Выберите тип операции\n"
            + "1 -> Загрузка всех текстовых файлов из указанной директории\n"
            + "2 -> Загрузка текстового файла\n"
            + "3 -> Чтение содержимого файла из кэша\n"
            + "4 -> Выход");
            answer = Integer.parseInt(answer(scanner));
            if (answer == 1) {
                Stream.of(Paths.get(dir).toFile().listFiles())
                        .filter(e -> e.getName().endsWith(".txt"))
                        .map(e -> e.getName()).forEach(dirFileCache::load);
            } else if (answer == 2) {
                System.out.println("Укажите имя файла:");
                String name = answer(scanner);
                check(dir, name);
                dirFileCache.put(name, dirFileCache.load(name));
            } else if (answer == 3) {
                System.out.println("Укажите имя файла:");
                String name = answer(scanner);
                System.out.println(dirFileCache.get(name));
            }
        }
    }
}
