package com.example.service.dto;

import com.example.domain.Appointment;
import com.example.domain.NotificationLog;

import java.sql.Timestamp;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public class NotificationLogDTO {

    private Long id;
    private Timestamp notificationDatetime;
    private Timestamp confirmedDatetime;


    public NotificationLogDTO(){}

    public NotificationLogDTO(Long id, Timestamp notificationDatetime, Timestamp confirmedDatetime) {
        this.id = id;
        this.notificationDatetime = notificationDatetime;
        this.confirmedDatetime = confirmedDatetime;
    }

    public NotificationLogDTO(NotificationLog notificationLog){
        this(notificationLog.getId(),notificationLog.getNotificationDatetime(),notificationLog.getConfirmedDatetime());
    }

    public Long getId() {
        return id;
    }

    public Timestamp getNotificationDatetime() {
        return notificationDatetime;
    }

    public Timestamp getConfirmedDatetime() {
        return confirmedDatetime;
    }


    @Override
    public String toString() {
        return "NotificationLogDTO{" +
                "id=" + id +
                ", notificationDatetime=" + notificationDatetime +
                ", confirmedDatetime=" + confirmedDatetime +
                '}';
    }
}
