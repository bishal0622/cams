package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
@Table(name = "notification_log", schema = "clinic", catalog = "")
public class NotificationLog {
    private Integer id;
    private String notificationDatetime;
    private Integer appointmentId;
    private String confirmedDatetime;
    private Appointment appointmentByAppointmentId;

    @Id
    @GeneratedValue
    @Column(name = "notification_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "notification_datetime", nullable = false)
    public String getNotificationDatetime() {
        return notificationDatetime;
    }

    public void setNotificationDatetime(String notificationDatetime) {
        this.notificationDatetime = notificationDatetime;
    }

    @Basic
    @Column(name = "appointment_id", nullable = false)
    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Basic
    @Column(name = "confirmed_datetime", nullable = false)
    public String getConfirmedDatetime() {
        return confirmedDatetime;
    }

    public void setConfirmedDatetime(String confirmedDatetime) {
        this.confirmedDatetime = confirmedDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotificationLog that = (NotificationLog) o;

        if (id != that.id) return false;
        if (appointmentId != that.appointmentId) return false;
        if (notificationDatetime != null ? !notificationDatetime.equals(that.notificationDatetime) : that.notificationDatetime != null)
            return false;
        if (confirmedDatetime != null ? !confirmedDatetime.equals(that.confirmedDatetime) : that.confirmedDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (notificationDatetime != null ? notificationDatetime.hashCode() : 0);
        result = 31 * result + appointmentId;
        result = 31 * result + (confirmedDatetime != null ? confirmedDatetime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "appointment_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public Appointment getAppointmentByAppointmentId() {
        return appointmentByAppointmentId;
    }

    public void setAppointmentByAppointmentId(Appointment appointmentByAppointmentId) {
        this.appointmentByAppointmentId = appointmentByAppointmentId;
    }
}
