/*
 * Copyright (c) $today.year.japnika
 */

package com.example.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by BiSAl MhRzn on 12/20/2016.
 */

@Entity
@Table(name="notificationLog")
public class NotificationLog {

    @Id
    @GeneratedValue
    @Column(name="notificationId")
    private Long id;

    @Column(name="notificationDatetime")
    private Timestamp notificationDatetime;

    @Column(name ="confirmedDatetime" )
    private Timestamp confirmedDatetime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getNotificationDatetime() {
        return notificationDatetime;
    }

    public void setNotificationDatetime(Timestamp notificationDatetime) {
        this.notificationDatetime = notificationDatetime;
    }

    public Timestamp getConfirmedDatetime() {
        return confirmedDatetime;
    }

    public void setConfirmedDatetime(Timestamp confirmedDatetime) {
        this.confirmedDatetime = confirmedDatetime;
    }

    @Override
    public String toString() {
        return "NotificationLog{" +
                "id=" + id +
                ", notificationDatetime=" + notificationDatetime +
                ", confirmedDatetime=" + confirmedDatetime +
                '}';
    }
}
