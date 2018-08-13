package com.company.analytic.utils;

import com.company.analytic.model.Data;
import com.company.analytic.model.Query;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtils {

    private static int lineNumber = 0;
    private static List<Data> dataList = new ArrayList<>();
    private static List<Query> queryList = new ArrayList<>();

    static List<Data> getDataList() {
        return dataList;
    }

    static List<Query> getQueryList() {
        return queryList;
    }

    //will make 2 lists - for queries and data
    static void parseLine(String line) {
        lineNumber++;
        if (line.startsWith("C")) {
            parseDataLine(line);
        } else if (line.startsWith("D")) {
            parseQueryLine(line);
        }
    }

    private static void parseDataLine(String line) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        Matcher m = Pattern.compile("^([CD])\\s([\\d|.]+)\\s([\\d|.]+)\\s([PN])\\s(\\d{2}\\.\\d{2}\\.\\d{4})\\s(\\d+)$").matcher(line);
        while (m.find()) {
            Data data = new Data(m.group(2), m.group(3), m.group(4), LocalDate.parse(m.group(5), formatter), Integer.parseInt(m.group(6)), lineNumber);
            dataList.add(data);
        }
    }

    private static void parseQueryLine(String line) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        Matcher m = Pattern.compile("^([CD])\\s([\\d|.|*]+)\\s([\\d|.|*]+)\\s([P|N])\\s(\\d{2}\\.\\d{2}\\.\\d{4})-?(\\d{2}\\.\\d{2}\\.\\d{4})?$").matcher(line);
        while (m.find()) {
            Query query = new Query(m.group(2), m.group(3), m.group(4), lineNumber);
            query.setStartLocalDate(LocalDate.parse(m.group(5), formatter));
            query.setEndLocalDate(LocalDate.parse(m.group(6) != null ? m.group(6) : m.group(5), formatter));
            queryList.add(query);
        }
    }

    //for testing
    public static void printDataList() {
        for (Data data : dataList) {
            System.out.println(data);
        }
    }

    public static void printQueryList() {
        for (Query query : queryList) {
            System.out.println(query);
        }
    }

}
