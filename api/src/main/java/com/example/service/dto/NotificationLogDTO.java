package com.example.service.dto;

import com.example.domain.Appointment;
import com.example.domain.NotificationLog;

import java.sql.Timestamp;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public class NotificationLogDTO {

    private Integer id;
    private Timestamp notificationDatetime;
    private Integer appointmentId;
    private Timestamp confirmedDatetime;
    private Appointment appointmentByAppointmentId;

    public NotificationLogDTO(){}

    public NotificationLogDTO(Integer id, Timestamp notificationDatetime, Integer appointmentId, Timestamp confirmedDatetime, Appointment appointmentByAppointmentId) {
        this.id = id;
        this.notificationDatetime = notificationDatetime;
        this.appointmentId = appointmentId;
        this.confirmedDatetime = confirmedDatetime;
        this.appointmentByAppointmentId = appointmentByAppointmentId;
    }

    public NotificationLogDTO(NotificationLog notificationLog){
        this(notificationLog.getId(),notificationLog.getNotificationDatetime(),notificationLog.getAppointmentId(),notificationLog.getConfirmedDatetime(),notificationLog.getAppointmentByAppointmentId());
    }

    public Integer getId() {
        return id;
    }

    public Timestamp getNotificationDatetime() {
        return notificationDatetime;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public Timestamp getConfirmedDatetime() {
        return confirmedDatetime;
    }

    public Appointment getAppointmentByAppointmentId() {
        return appointmentByAppointmentId;
    }

    @Override
    public String toString() {
        return "NotificationLogDTO{" +
                "id=" + id +
                ", notificationDatetime=" + notificationDatetime +
                ", appointmentId=" + appointmentId +
                ", confirmedDatetime=" + confirmedDatetime +
                ", appointmentByAppointmentId=" + appointmentByAppointmentId +
                '}';
    }
}
