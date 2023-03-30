package com.example.campusconnect.Models;

public class AttendanceModel {
    String attendanceId;
    String date;
    String present;

    public AttendanceModel() {
    }

    public AttendanceModel(String attendanceId, String date, String present) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.present = present;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }
}
