package com.example.campusconnect.Models;

public class StudentModel {
    int studentId;
    String password;
    String studentName;
    String studentEmail;
    String parentEmail;
    Boolean feesPaid;
    String transactionId;

    public StudentModel() {
    }

    public StudentModel(int studentId, String password, String studentName, String studentEmail, String parentEmail, Boolean feesPaid) {
        this.studentId = studentId;
        this.password = password;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.parentEmail = parentEmail;
        this.feesPaid = feesPaid;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public Boolean getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(Boolean feesPaid) {
        this.feesPaid = feesPaid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
