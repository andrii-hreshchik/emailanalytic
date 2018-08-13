package com.company.analytic;

import com.company.analytic.utils.FileUtils;
import com.company.analytic.utils.QueryUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        //input file name to read in console
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = bufferedReader.readLine();
            FileUtils.readFile(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        QueryUtils queryUtils = new QueryUtils();
        queryUtils.proceedAllQueries();
    }

}
