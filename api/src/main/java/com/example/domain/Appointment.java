package com.example.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
public class Appointment {
    private Integer id;
    private Timestamp appointmentDate;
    private Integer doctorScheduleId;
    private String comment;
    private String status;
    private Integer patientpatientId;
    private DoctorSchedule doctorScheduleByDoctorScheduleId;
    private Patient patientByPatientpatientId;
    private Collection<NotificationLog> notificationLogsByAppointmentId;

    @Id
    @Column(name = "appointment_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "appointment_date", nullable = false)
    public Timestamp getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Timestamp appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Basic
    @Column(name = "doctor_schedule_id", nullable = false)
    public Integer getDoctorScheduleId() {
        return doctorScheduleId;
    }

    public void setDoctorScheduleId(Integer doctorScheduleId) {
        this.doctorScheduleId = doctorScheduleId;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "patientpatient_id", nullable = false)
    public Integer getPatientpatientId() {
        return patientpatientId;
    }

    public void setPatientpatientId(Integer patientpatientId) {
        this.patientpatientId = patientpatientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (id != that.id) return false;
        if (doctorScheduleId != that.doctorScheduleId) return false;
        if (patientpatientId != that.patientpatientId) return false;
        if (appointmentDate != null ? !appointmentDate.equals(that.appointmentDate) : that.appointmentDate != null)
            return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (appointmentDate != null ? appointmentDate.hashCode() : 0);
        result = 31 * result + doctorScheduleId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + patientpatientId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_schedule_id", referencedColumnName = "doctor_schedule_id", nullable = false, insertable = false, updatable = false)
    public DoctorSchedule getDoctorScheduleByDoctorScheduleId() {
        return doctorScheduleByDoctorScheduleId;
    }

    public void setDoctorScheduleByDoctorScheduleId(DoctorSchedule doctorScheduleByDoctorScheduleId) {
        this.doctorScheduleByDoctorScheduleId = doctorScheduleByDoctorScheduleId;
    }

    @ManyToOne
    @JoinColumn(name = "patientpatient_id", referencedColumnName = "patient_id", nullable = false, insertable = false, updatable = false)
    public Patient getPatientByPatientpatientId() {
        return patientByPatientpatientId;
    }

    public void setPatientByPatientpatientId(Patient patientByPatientpatientId) {
        this.patientByPatientpatientId = patientByPatientpatientId;
    }

    @OneToMany(mappedBy = "appointmentByAppointmentId")
    public Collection<NotificationLog> getNotificationLogsByAppointmentId() {
        return notificationLogsByAppointmentId;
    }

    public void setNotificationLogsByAppointmentId(Collection<NotificationLog> notificationLogsByAppointmentId) {
        this.notificationLogsByAppointmentId = notificationLogsByAppointmentId;
    }
}
