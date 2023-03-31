package com.example.campusconnect.Models;

public class NoticeModel {
    int notificationId;
    String notificationTitle, notificationMessage, author;

    public NoticeModel(int notificationId, String notificationTitle, String notificationMessage, String author) {
        this.notificationId = notificationId;
        this.notificationTitle = notificationTitle;
        this.notificationMessage = notificationMessage;
        this.author=author;
    }

    public NoticeModel() {
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

}
