package com.company.analytic.utils;

import java.util.List;

public class ParseUtils {

    public static void parse(List<String> lines) {
        print(lines);


    }

    private static void print(List<String> result) {
        for (String line : result) {
            System.out.println(line);
        }
    }

}
