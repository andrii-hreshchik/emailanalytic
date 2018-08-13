package com.company.analytic.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    public static List<String> readFile(String fileName) throws IOException {
        if (checkExists(fileName)) {
            return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        return null;
    }

    private static boolean checkExists(String fileName) {
        return Files.exists(Paths.get(fileName));
    }
}
