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

    //line number for filtering data lines that go after query
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

    //splits line into groups and creates data object
    private static void parseDataLine(String line) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        Matcher m = Pattern.compile("^([C])\\s(?<serviceId>[\\d.]+)\\s(?<questionTypeId>[\\d.]+)\\s(?<responseType>[PN])\\s(?<localDate>\\d{2}\\.\\d{2}\\.\\d{4})\\s(?<waitingTime>\\d+)$").matcher(line);
        while (m.find()) {
            Data data = new Data(m.group("serviceId"), m.group("questionTypeId"), m.group("responseType"), LocalDate.parse(m.group("localDate"), formatter), Integer.parseInt(m.group("waitingTime")), lineNumber);
            dataList.add(data);
        }
    }

    //splits line into groups and creates query object
    private static void parseQueryLine(String line) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        Matcher m = Pattern.compile("^([D])\\s(?<serviceId>[\\d.*]+)\\s(?<questionTypeId>[\\d.*]+)\\s(?<responseType>[PN])\\s(?<startLocalDate>\\d{2}\\.\\d{2}\\.\\d{4})-?(?<endLocalDate>\\d{2}\\.\\d{2}\\.\\d{4})?$").matcher(line);
        while (m.find()) {
            Query query = new Query(m.group("serviceId"), m.group("questionTypeId"), m.group("responseType"), lineNumber);
            query.setStartLocalDate(LocalDate.parse(m.group("startLocalDate"), formatter));
            //if endDate in query is absent - set endDate = startDate
            query.setEndLocalDate(LocalDate.parse(m.group("endLocalDate") != null ? m.group("endLocalDate") : m.group("startLocalDate"), formatter));
            queryList.add(query);
        }
    }

    //for testing
//    public static void printDataList() {
//        for (Data data : dataList) {
//            System.out.println(data);
//        }
//    }
//
//    public static void printQueryList() {
//        for (Query query : queryList) {
//            System.out.println(query);
//        }
//    }

}
