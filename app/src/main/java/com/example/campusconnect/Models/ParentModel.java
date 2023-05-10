package com.example.campusconnect.Models;

public class ParentModel {
    int parentId;
    String password;
    String parentEmail;

    public ParentModel() {
    }

    public ParentModel(int parentId, String password, String parentEmail) {
        this.parentId = parentId;
        this.password = password;
        this.parentEmail = parentEmail;
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
}
