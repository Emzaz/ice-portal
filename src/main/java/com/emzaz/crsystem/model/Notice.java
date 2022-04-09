package com.emzaz.crsystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private Date dateTime;

    private String noticeDetails;

    public Notice() {
    }

    public Notice(long id, String title, Date dateTime, String noticeDetails) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
        this.noticeDetails = noticeDetails;
    }

    @PrePersist
    protected void onCreate() {
        dateTime= new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }
}
