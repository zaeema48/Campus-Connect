package com.example.campusconnect.Models;

public class MarkAttendanceModel {
    AttendanceModel attendance;
    int studentId;

    public AttendanceModel getAttendance() {
        return attendance;
    }

    public void setAttendance(AttendanceModel attendance) {
        this.attendance = attendance;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public MarkAttendanceModel() {
    }

    public MarkAttendanceModel(AttendanceModel attendance, int studentId) {
        this.attendance = attendance;
        this.studentId = studentId;
    }


}
