package com.clinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
@Table(name = "doctor_schedule", schema = "clinic", catalog = "")
public class DoctorSchedule {
    private Integer id;
    private Integer doctorId;
    private Timestamp doctorScheduleTo;
    private Timestamp doctorScheduleFrom;
    private Integer dayOfWeek;
    private Collection<Appointment> appointmentsByDoctorScheduleId;
    private Doctor doctorByDoctorId;

    @Id
    @GeneratedValue
    @Column(name = "doctor_schedule_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "doctor_id", nullable = false)
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "doctor_schedule_to", nullable = false)
    public Timestamp getDoctorScheduleTo() {
        return doctorScheduleTo;
    }

    public void setDoctorScheduleTo(Timestamp doctorScheduleTo) {
        this.doctorScheduleTo = doctorScheduleTo;
    }

    @Basic
    @Column(name = "doctor_schedule_from", nullable = false)
    public Timestamp getDoctorScheduleFrom() {
        return doctorScheduleFrom;
    }

    public void setDoctorScheduleFrom(Timestamp doctorScheduleFrom) {
        this.doctorScheduleFrom = doctorScheduleFrom;
    }

    @Basic
    @Column(name = "day_of_week", nullable = false)
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorSchedule that = (DoctorSchedule) o;

        if (id != that.id) return false;
        if (doctorId != that.doctorId) return false;
        if (dayOfWeek != that.dayOfWeek) return false;
        if (doctorScheduleTo != null ? !doctorScheduleTo.equals(that.doctorScheduleTo) : that.doctorScheduleTo != null)
            return false;
        if (doctorScheduleFrom != null ? !doctorScheduleFrom.equals(that.doctorScheduleFrom) : that.doctorScheduleFrom != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + doctorId;
        result = 31 * result + (doctorScheduleTo != null ? doctorScheduleTo.hashCode() : 0);
        result = 31 * result + (doctorScheduleFrom != null ? doctorScheduleFrom.hashCode() : 0);
        result = 31 * result + dayOfWeek;
        return result;
    }

    @OneToMany(mappedBy = "doctorScheduleByDoctorScheduleId")
    @JsonIgnore
    public Collection<Appointment> getAppointmentsByDoctorScheduleId() {
        return appointmentsByDoctorScheduleId;
    }

    public void setAppointmentsByDoctorScheduleId(Collection<Appointment> appointmentsByDoctorScheduleId) {
        this.appointmentsByDoctorScheduleId = appointmentsByDoctorScheduleId;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id", nullable = false, insertable = false, updatable = false)
    public Doctor getDoctorByDoctorId() {
        return doctorByDoctorId;
    }

    public void setDoctorByDoctorId(Doctor doctorByDoctorId) {
        this.doctorByDoctorId = doctorByDoctorId;
    }
}
