package com.example.campusconnect.Models;

import java.util.List;

public class BatchModel {
    String batchId;
    String courseName;
    String courseYear;
    String courseDuration;
    String feesAmount;
    String currentSemester;

    List<ScheduleModel> schedules;

    public BatchModel() {
    }

    public BatchModel(String batchId, String courseName, String courseYear, String courseDuration, String feesAmount, String currentSemester, List<ScheduleModel> schedules) {
        this.batchId = batchId;
        this.courseName = courseName;
        this.courseYear = courseYear;
        this.courseDuration = courseDuration;
        this.feesAmount = feesAmount;
        this.currentSemester = currentSemester;
        this.schedules = schedules;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(String feesAmount) {
        this.feesAmount = feesAmount;
    }

    public String getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(String currentSemester) {
        this.currentSemester = currentSemester;
    }

    public List<ScheduleModel> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleModel> schedules) {
        this.schedules = schedules;
    }
}
