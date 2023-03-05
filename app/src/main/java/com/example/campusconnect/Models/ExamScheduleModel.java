package com.example.campusconnect.Models;

import java.util.ArrayList;
import java.util.List;

public class ExamScheduleModel {
    int examId;
    String date;
    String subject;
    String time;
    String roomAllocated;

    List<ExamScheduleModel> examSchedule;

    public ExamScheduleModel() {
    }

    public ExamScheduleModel(int examId, String date, String subject, String time, String roomAllocated) {
        this.examId = examId;
        this.date = date;
        this.subject = subject;
        this.time = time;
        this.roomAllocated = roomAllocated;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoomAllocated() {
        return roomAllocated;
    }

    public void setRoomAllocated(String roomAllocated) {
        this.roomAllocated = roomAllocated;
    }

    public List<ExamScheduleModel> getExamSchedule() {
        return examSchedule;
    }

    public void setExamSchedule(List<ExamScheduleModel> examSchedule) {
        this.examSchedule = examSchedule;
    }
}
