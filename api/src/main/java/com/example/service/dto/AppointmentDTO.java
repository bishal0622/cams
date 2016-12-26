package com.example.service.dto;

import com.example.domain.Appointment;
import com.example.domain.DoctorSchedule;
import com.example.domain.NotificationLog;
import com.example.domain.PatientAppointment;

import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public class AppointmentDTO {

    private Long id;
    private DoctorSchedule doctorSchedule;
    private String comment;
    private String status;
    private NotificationLog notificationLog;

    public Long getId() {
        return id;
    }

    public DoctorSchedule getDoctorSchedule() {
        return doctorSchedule;
    }

    public String getComment() {
        return comment;
    }

    public String getStatus() {
        return status;
    }

    public NotificationLog getNotificationLog() {
        return notificationLog;
    }

    public AppointmentDTO(){}

    public AppointmentDTO(Long id, DoctorSchedule doctorSchedule, String comment, String status, NotificationLog notificationLog) {
        this.id = id;
        this.doctorSchedule = doctorSchedule;
        this.comment = comment;
        this.status = status;
        this.notificationLog = notificationLog;
    }

    public AppointmentDTO(Appointment appointment){
        this(appointment.getId(),appointment.getDoctorSchedule(),appointment.getComment(),appointment.getStatus(),appointment.getNotificationLogs());
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "id=" + id +
                ", doctorSchedule=" + doctorSchedule +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                ", notificationLog=" + notificationLog +
                '}';
    }
}
