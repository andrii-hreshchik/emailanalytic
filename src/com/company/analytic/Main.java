package com.company.analytic;

import com.company.analytic.utils.FileUtils;
import com.company.analytic.utils.ParseUtils;
import com.company.analytic.utils.QueryUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //input file name to read in console
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = bufferedReader.readLine();
            List<String> lines = FileUtils.readFile(fileName);
            if (lines != null) {
                ParseUtils.parse(lines);
            }
        } catch (IOException e) {
            System.out.println("File read error " + e.getMessage());
        }

//for mock testing
//        List<String> lines = FileUtils.readFile("file.txt");
//        if (lines != null) {
//            ParseUtils.parse(lines);
//        } else {
//            System.out.println("File read error");
//        }

        QueryUtils queryUtils = new QueryUtils();
        queryUtils.proceedAllQueries();
    }

}
