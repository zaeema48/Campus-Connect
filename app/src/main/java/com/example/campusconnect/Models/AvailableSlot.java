package com.example.campusconnect.Models;

public class AvailableSlot {
    String slot;
    String day;
    String batchId;
    int teacherId;

    public AvailableSlot(String slot, String day, String batchId, int teacherId) {
        this.slot = slot;
        this.day = day;
        this.batchId = batchId;
        this.teacherId = teacherId;
    }

    public AvailableSlot() {
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
