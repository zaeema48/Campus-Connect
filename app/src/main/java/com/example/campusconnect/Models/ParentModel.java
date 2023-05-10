package com.example.campusconnect.Models;

public class ParentModel {
    int parentId, studentId;
    String password;
    String parentEmail, name;

    public ParentModel() {
    }
    public ParentModel(int parentId, String password, String parentEmail, String name) {
        this.parentId = parentId;
        this.password = password;
        this.parentEmail = parentEmail;
        this.name= name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
