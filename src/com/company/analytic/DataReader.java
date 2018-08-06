package com.company.analytic;

import com.company.analytic.utils.FileUtils;
import com.company.analytic.utils.ParseUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class DataReader {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = bufferedReader.readLine();
            List lines = FileUtils.readFile(fileName);
            ParseUtils.parse(lines);
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
    }
}
