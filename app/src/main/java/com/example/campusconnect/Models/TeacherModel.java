package com.example.campusconnect.Models;

import java.util.List;

public class TeacherModel {
    int teacherId;
    String teacherPassword;
    String teacherName;
    String teacherEmail;
    String salary;
    SubjectModel subject;
    List<TeacherScheduleModel> teacherSchedules;

    public TeacherModel() {
    }

    public TeacherModel(int teacherId, String teacherPassword, String teacherName, String teacherEmail, String salary, SubjectModel subject) {
        this.teacherId = teacherId;
        this.teacherPassword = teacherPassword;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.salary = salary;
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }

    public List<TeacherScheduleModel> getTeacherSchedules() {
        return teacherSchedules;
    }

    public void setTeacherSchedules(List<TeacherScheduleModel> teacherSchedules) {
        this.teacherSchedules = teacherSchedules;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }
}
