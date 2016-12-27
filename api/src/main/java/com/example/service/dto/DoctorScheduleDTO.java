package com.example.service.dto;

import com.example.domain.Doctor;
import com.example.domain.DoctorSchedule;

import java.sql.Timestamp;

/**
 * Created by japnica on 12/25/2016.
 */
public class DoctorScheduleDTO {
    private Long id;
    private Doctor doctor;
    private Timestamp doctorScheduleTo;
    private Timestamp doctorScheduleFrom;
    private Integer dayOfWeek;

    public DoctorScheduleDTO(Long id, Doctor doctor, Timestamp doctorScheduleTo, Timestamp doctorScheduleFrom, Integer dayOfWeek) {
        this.id = id;
        this.doctor = doctor;
        this.doctorScheduleTo = doctorScheduleTo;
        this.doctorScheduleFrom = doctorScheduleFrom;
        this.dayOfWeek = dayOfWeek;
    }

    public DoctorScheduleDTO() {
    }

    public DoctorScheduleDTO(DoctorSchedule doctorSchedule){
        this(doctorSchedule.getId(), doctorSchedule.getDoctor(), doctorSchedule.getDoctorScheduleTo(), doctorSchedule.getDoctorScheduleFrom(), doctorSchedule.getDayOfWeek());
    }

    public Long getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Timestamp getDoctorScheduleTo() {
        return doctorScheduleTo;
    }

    public Timestamp getDoctorScheduleFrom() {
        return doctorScheduleFrom;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public String toString() {
        return "DoctorScheduleDTO{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", doctorScheduleTo=" + doctorScheduleTo +
                ", doctorScheduleFrom=" + doctorScheduleFrom +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}
