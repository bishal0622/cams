package com.clinic.service.dto;

import com.clinic.domain.Appointment;
import com.clinic.domain.NotificationLog;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public class NotificationLogDTO {

    private Integer id;
    private String notificationDatetime;
    private Integer appointmentId;
    private String confirmedDatetime;
    private Appointment appointmentByAppointmentId;

    public NotificationLogDTO(){}

    public NotificationLogDTO(Integer id, String notificationDatetime, Integer appointmentId, String confirmedDatetime, Appointment appointmentByAppointmentId) {
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

    public String getNotificationDatetime() {
        return notificationDatetime;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }


    public String getConfirmedDatetime() {
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

    public void setId(Integer id) {
        this.id = id;
    }
}
