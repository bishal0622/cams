package com.example.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by japnica on 12/20/2016.
 */
@Entity
@Table(name="appointment")
public class Appointment {
    @Id
    @GeneratedValue
    @Column(name="appointmentId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="doctorScheduleId", referencedColumnName = "doctorScheduleId")
    private DoctorSchedule doctorSchedule;

    @Column(name="comment")
    private String comment;

    @Column(name="status")
    private String status;

    @OneToOne
    @JoinColumn(name = "notificationId")
    private NotificationLog notificationLogs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoctorSchedule getDoctorSchedule() {
        return doctorSchedule;
    }

    public void setDoctorSchedule(DoctorSchedule doctorSchedule) {
        this.doctorSchedule = doctorSchedule;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NotificationLog getNotificationLogs() {
        return notificationLogs;
    }

    public void setNotificationLogs(NotificationLog notificationLogs) {
        this.notificationLogs = notificationLogs;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorSchedule=" + doctorSchedule +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                ", notificationLogs=" + notificationLogs +
                '}';
    }
}
