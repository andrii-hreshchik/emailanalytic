package com.company.analytic.model;

import java.time.LocalDate;

public class Data {
    private String serviceId;
    private String questionTypeId;
    private String responseType;
    private LocalDate localDate;
    private int waitingTime;
    private int lineNumber;

    public Data() {
    }

    public Data(String serviceId, String questionTypeId, String responseType, LocalDate localDate, int waitingTime, int lineNumber) {
        this.serviceId = serviceId;
        this.questionTypeId = questionTypeId;
        this.responseType = responseType;
        this.localDate = localDate;
        this.waitingTime = waitingTime;
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }


    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "Data{" +
                "serviceId='" + serviceId + '\'' +
                ", questionTypeId='" + questionTypeId + '\'' +
                ", responseType='" + responseType + '\'' +
                ", localDate=" + localDate +
                ", waitingTime=" + waitingTime +
                ", lineNumber=" + lineNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;

        Data data = (Data) o;

        if (waitingTime != data.waitingTime) return false;
        if (lineNumber != data.lineNumber) return false;
        if (serviceId != null ? !serviceId.equals(data.serviceId) : data.serviceId != null) return false;
        if (questionTypeId != null ? !questionTypeId.equals(data.questionTypeId) : data.questionTypeId != null)
            return false;
        if (responseType != null ? !responseType.equals(data.responseType) : data.responseType != null) return false;
        return localDate != null ? localDate.equals(data.localDate) : data.localDate == null;
    }

    @Override
    public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (questionTypeId != null ? questionTypeId.hashCode() : 0);
        result = 31 * result + (responseType != null ? responseType.hashCode() : 0);
        result = 31 * result + (localDate != null ? localDate.hashCode() : 0);
        result = 31 * result + waitingTime;
        result = 31 * result + lineNumber;
        return result;
    }
}
