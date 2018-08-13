package com.company.analytic.utils;

import com.company.analytic.model.Data;
import com.company.analytic.model.Query;

import java.util.List;

public class QueryUtils {
    private List<Data> dataList = ParseUtils.getDataList();
    private List<Query> queryList = ParseUtils.getQueryList();

    public void proceedAllQueries() {
        for (Query query : queryList) {
            double result = dataList.stream()
                    //filter by date
                    .filter(s -> !s.getLocalDate().isBefore(query.getStartLocalDate()) && !s.getLocalDate().isAfter(query.getEndLocalDate()))
                    //filter by responseType
                    .filter(s -> s.getResponseType().equals(query.getResponseType()))
                    //if query's serviceId/questionId == "*" - it means query match all services/question types or filter by serviceId/questionId
                    .filter(s -> (!query.getServiceId().equals("*") ? s.getServiceId().startsWith(query.getServiceId()) : s.getServiceId().matches(".*"))
                            &&
                            (!query.getQuestionTypeId().equals("*") ? s.getQuestionTypeId().startsWith(query.getQuestionTypeId()) : s.getQuestionTypeId().matches(".*")))
                    .mapToDouble(Data::getWaitingTime)
                    .average().orElse(0.0);
            System.out.println(Math.round(result) == 0 ? "-" : Math.round(result));
        }
    }
}

