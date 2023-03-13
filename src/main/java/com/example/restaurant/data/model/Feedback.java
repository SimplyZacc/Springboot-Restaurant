package com.example.restaurant.data.model;

import java.time.LocalDateTime;

public class Feedback {
    private int feedbackId;
    private int orderId;
    private String feedbackText;
    private String fName;
    private String lName;
    private String email;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public Feedback() {
        this.feedbackId = 0;
        this.orderId = 0;
        this.feedbackText = "";
        this.fName = "";
        this.lName = "";
        this.email = "";
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public Feedback(int feedbackId, int orderId, String feedbackText, String fName, String lName, String email) {
        this.feedbackId = feedbackId;
        this.orderId = orderId;
        this.feedbackText = feedbackText;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public Feedback(int feedbackId, int orderId, String feedbackText, String fName, String lName, String email,
            LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.feedbackId = feedbackId;
        this.orderId = orderId;
        this.feedbackText = feedbackText;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
        this.dateUpdated = LocalDateTime.now();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
        this.dateUpdated = LocalDateTime.now();
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
        this.dateUpdated = LocalDateTime.now();
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setfName(String fName) {
        this.fName = fName;
        this.dateUpdated = LocalDateTime.now();
    }

    public String getfName() {
        return fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
        this.dateUpdated = LocalDateTime.now();
    }

    public String getlName() {
        return lName;
    }

    public void setEmail(String email) {
        this.email = email;
        this.dateUpdated = LocalDateTime.now();
    }

    public String getEmail() {
        return email;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        this.dateUpdated = LocalDateTime.now();
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }
}
