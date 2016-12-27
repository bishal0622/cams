package com.example.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by japnica on 12/20/2016.
 */
@Entity
@Table(name="doctorSchedule")
public class DoctorSchedule {
    @Id
    @GeneratedValue
    @Column(name="doctorScheduleId")
    private  Long id;

    @ManyToOne
    @JoinColumn(name="doctorId", referencedColumnName = "doctorId", nullable = false)
    private Doctor doctor;

    @Column(name="doctorScheduleTo", nullable = false)
    private Timestamp doctorScheduleTo;

    @Column(name="doctorScheduleFrom", nullable = false)
    private Timestamp doctorScheduleFrom;

    @Column(name="dayOfWeek", nullable = false)
    private Integer dayOfWeek;

//    @OneToMany(mappedBy = "doctorSchedule")
//    private Collection<Appointment> appointments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Timestamp getDoctorScheduleTo() {
        return doctorScheduleTo;
    }

    public void setDoctorScheduleTo(Timestamp doctorScheduleTo) {
        this.doctorScheduleTo = doctorScheduleTo;
    }

    public Timestamp getDoctorScheduleFrom() {
        return doctorScheduleFrom;
    }

    public void setDoctorScheduleFrom(Timestamp doctorScheduleFrom) {
        this.doctorScheduleFrom = doctorScheduleFrom;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

//    public Collection<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(Collection<Appointment> appointments) {
//        this.appointments = appointments;
//    }

    @Override
    public String toString() {
        return "DoctorSchedule{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", doctorScheduleTo=" + doctorScheduleTo +
                ", doctorScheduleFrom=" + doctorScheduleFrom +
                ", dayOfWeek=" + dayOfWeek +
//                ", appointments=" + appointments +
                '}';
    }
}
