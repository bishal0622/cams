package com.clinic.service.dto;

import com.clinic.domain.Appointment;
import com.clinic.domain.DoctorSchedule;
import com.clinic.domain.NotificationLog;
import com.clinic.domain.Patient;

import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public class AppointmentDTO {

    private Integer id;
    private String appointmentDate;
    private Integer doctorScheduleId;
    private String comment;
    private String status;

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer patientpatientId;
    private DoctorSchedule doctorScheduleByDoctorScheduleId;
    private Patient patientByPatientpatientId;
    private Collection<NotificationLog> notificationLogsByAppointmentId;

    public Integer getId() {
        return id;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public Integer getDoctorScheduleId() {
        return doctorScheduleId;
    }

    public String getComment() {
        return comment;
    }

    public String getStatus() {
        return status;
    }

    public Integer getPatientpatientId() {
        return patientpatientId;
    }

    public DoctorSchedule getDoctorScheduleByDoctorScheduleId() {
        return doctorScheduleByDoctorScheduleId;
    }

    public Patient getPatientByPatientpatientId() {
        return patientByPatientpatientId;
    }

    public Collection<NotificationLog> getNotificationLogsByAppointmentId() {
        return notificationLogsByAppointmentId;
    }

    public AppointmentDTO(){}

    public AppointmentDTO(Integer id, String appointmentDate, Integer doctorScheduleId, String comment, String status, Integer patientpatientId, DoctorSchedule doctorScheduleByDoctorScheduleId, Patient patientByPatientpatientId, Collection<NotificationLog> notificationLogsByAppointmentId) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.doctorScheduleId = doctorScheduleId;
        this.comment = comment;
        this.status = status;
        this.patientpatientId = patientpatientId;
        this.doctorScheduleByDoctorScheduleId = doctorScheduleByDoctorScheduleId;
        this.patientByPatientpatientId = patientByPatientpatientId;
        this.notificationLogsByAppointmentId = notificationLogsByAppointmentId;
    }

    public AppointmentDTO(Appointment appointment){
        this(appointment.getId(),appointment.getAppointmentDate(),appointment.getDoctorScheduleId(),appointment.getComment(),appointment.getStatus(),appointment.getPatientpatientId(),appointment.getDoctorScheduleByDoctorScheduleId(),appointment.getPatientByPatientpatientId(),appointment.getNotificationLogsByAppointmentId());
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "id=" + id +
                ", appointmentDate=" + appointmentDate +
                ", doctorScheduleId=" + doctorScheduleId +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                ", patientpatientId=" + patientpatientId +
                ", doctorScheduleByDoctorScheduleId=" + doctorScheduleByDoctorScheduleId +
                ", patientByPatientpatientId=" + patientByPatientpatientId +
                ", notificationLogsByAppointmentId=" + notificationLogsByAppointmentId +
                '}';
    }

    public void setPatientpatientId(Integer patientpatientId) {
        this.patientpatientId = patientpatientId;
    }
}
