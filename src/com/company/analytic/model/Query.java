package com.company.analytic.model;

import java.time.LocalDate;
import java.util.Objects;

public class Query {
    private String serviceId;
    private String questionTypeId;
    private String responseType;
    private LocalDate startLocalDate;
    private LocalDate endLocalDate;

    public Query() {
    }


    public Query(String serviceId, String questionTypeId, String responseType) {
        this.serviceId = serviceId;
        this.questionTypeId = questionTypeId;
        this.responseType = responseType;
    }


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public LocalDate getStartLocalDate() {
        return startLocalDate;
    }

    public void setStartLocalDate(LocalDate startLocalDate) {
        this.startLocalDate = startLocalDate;
    }

    public LocalDate getEndLocalDate() {
        return endLocalDate;
    }

    public void setEndLocalDate(LocalDate endLocalDate) {
        this.endLocalDate = endLocalDate;
    }

    @Override
    public String toString() {
        return "Query{" +
                "serviceId='" + serviceId + '\'' +
                ", questionTypeId='" + questionTypeId + '\'' +
                ", responseType='" + responseType + '\'' +
                ", startLocalDate=" + startLocalDate +
                ", endLocalDate=" + endLocalDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return Objects.equals(serviceId, query.serviceId) &&
                Objects.equals(questionTypeId, query.questionTypeId) &&
                Objects.equals(responseType, query.responseType) &&
                Objects.equals(startLocalDate, query.startLocalDate) &&
                Objects.equals(endLocalDate, query.endLocalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, questionTypeId, responseType, startLocalDate, endLocalDate);
    }
}
