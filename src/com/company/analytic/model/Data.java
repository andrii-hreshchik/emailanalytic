package com.company.analytic.model;

import java.time.LocalDate;
import java.util.Objects;

public class Data {
    private String serviceId;
    private String questionTypeId;
    private String responseType;
    private LocalDate localDate;
    private int waitingTime;

    public Data() {
    }

    public Data(String serviceId, String questionTypeId, String responseType, LocalDate localDate, int waitingTime) {
        this.serviceId = serviceId;
        this.questionTypeId = questionTypeId;
        this.responseType = responseType;
        this.localDate = localDate;
        this.waitingTime = waitingTime;
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

    @Override
    public String toString() {
        return "Data{" +
                "serviceId='" + serviceId + '\'' +
                ", questionTypeId='" + questionTypeId + '\'' +
                ", responseType='" + responseType + '\'' +
                ", localDate=" + localDate +
                ", waitingTime=" + waitingTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return waitingTime == data.waitingTime &&
                Objects.equals(serviceId, data.serviceId) &&
                Objects.equals(questionTypeId, data.questionTypeId) &&
                Objects.equals(responseType, data.responseType) &&
                Objects.equals(localDate, data.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, questionTypeId, responseType, localDate, waitingTime);
    }

}
