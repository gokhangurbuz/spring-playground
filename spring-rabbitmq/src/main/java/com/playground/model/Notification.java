package com.playground.model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {

    private String notificationId;
    private Date createdAt;
    private Boolean seen;
    private String message;

    public String getNotificationId() {
        return notificationId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Boolean getSeen() {
        return seen;
    }

    public String getMessage() {
        return message;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
