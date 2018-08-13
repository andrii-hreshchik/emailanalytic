package com.company.analytic.model;

import java.time.LocalDate;

public class Query {
    private String serviceId;
    private String questionTypeId;
    private String responseType;
    private LocalDate startLocalDate;
    private LocalDate endLocalDate;
    private int lineNumber;

    public Query() {
    }

    public Query(String serviceId, String questionTypeId, String responseType, int lineNumber) {
        this.serviceId = serviceId;
        this.questionTypeId = questionTypeId;
        this.responseType = responseType;
        this.lineNumber = lineNumber;
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

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "Query{" +
                "serviceId='" + serviceId + '\'' +
                ", questionTypeId='" + questionTypeId + '\'' +
                ", responseType='" + responseType + '\'' +
                ", startLocalDate=" + startLocalDate +
                ", endLocalDate=" + endLocalDate +
                ", lineNumber=" + lineNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Query)) return false;

        Query query = (Query) o;

        if (lineNumber != query.lineNumber) return false;
        if (serviceId != null ? !serviceId.equals(query.serviceId) : query.serviceId != null) return false;
        if (questionTypeId != null ? !questionTypeId.equals(query.questionTypeId) : query.questionTypeId != null)
            return false;
        if (responseType != null ? !responseType.equals(query.responseType) : query.responseType != null) return false;
        if (startLocalDate != null ? !startLocalDate.equals(query.startLocalDate) : query.startLocalDate != null)
            return false;
        return endLocalDate != null ? endLocalDate.equals(query.endLocalDate) : query.endLocalDate == null;
    }

    @Override
    public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (questionTypeId != null ? questionTypeId.hashCode() : 0);
        result = 31 * result + (responseType != null ? responseType.hashCode() : 0);
        result = 31 * result + (startLocalDate != null ? startLocalDate.hashCode() : 0);
        result = 31 * result + (endLocalDate != null ? endLocalDate.hashCode() : 0);
        result = 31 * result + lineNumber;
        return result;
    }
}
