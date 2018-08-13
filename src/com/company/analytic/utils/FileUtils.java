package com.company.analytic.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    public static void readFile(String fileName) throws IOException {
        if (checkExists(fileName)) {
            Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach(ParseUtils::parseLine);
        } else {
            throw new IOException("File with name " + fileName + " doesn't exists");
        }
    }

    private static boolean checkExists(String fileName) {
        return Files.exists(Paths.get(fileName));
    }
}
