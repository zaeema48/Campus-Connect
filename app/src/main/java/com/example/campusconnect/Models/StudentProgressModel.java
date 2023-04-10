package com.example.campusconnect.Models;

public class StudentProgressModel {
    String progressId;  //studentId+subjectName
    String batchId;
    int totalAttendance;
    int totalClasses;
    float attendancePercentage;
    int marks;

    public StudentProgressModel() {
    }

    public String getProgressId() {
        return progressId;
    }

    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public int getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(int totalAttendance) {
        this.totalAttendance = totalAttendance;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public float getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(float attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

}
