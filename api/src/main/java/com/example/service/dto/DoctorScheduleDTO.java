package com.example.service.dto;

import com.example.domain.Appointment;
import com.example.domain.Doctor;
import com.example.domain.DoctorSchedule;


import java.util.Collection;

/**
 * Created by japnica on 12/25/2016.
 */
public class DoctorScheduleDTO {
    private Integer id;
    private Integer doctorId;
    private String doctorScheduleTo;
    private String doctorScheduleFrom;
    private Integer dayOfWeek;
    private Collection<Appointment> appointmentsByDoctorScheduleId;
    private Doctor doctorByDoctorId;

    public DoctorScheduleDTO() {
    }

    public DoctorScheduleDTO(Integer id, Integer doctorId, String doctorScheduleTo, String doctorScheduleFrom, Integer dayOfWeek, Collection<Appointment> appointmentsByDoctorScheduleId, Doctor doctorByDoctorId) {
        this.id = id;
        this.doctorId = doctorId;
        this.doctorScheduleTo = doctorScheduleTo;
        this.doctorScheduleFrom = doctorScheduleFrom;
        this.dayOfWeek = dayOfWeek;
        this.appointmentsByDoctorScheduleId = appointmentsByDoctorScheduleId;
        this.doctorByDoctorId = doctorByDoctorId;
    }

    public DoctorScheduleDTO(DoctorSchedule doctorSchedule){
        this(doctorSchedule.getId(),doctorSchedule.getDoctorId(),doctorSchedule.getDoctorScheduleTo(),doctorSchedule.getDoctorScheduleFrom(),doctorSchedule.getDayOfWeek(),doctorSchedule.getAppointmentsByDoctorScheduleId(),doctorSchedule.getDoctorByDoctorId());
    }

    public Integer getId() {
        return id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public String getDoctorScheduleTo() {
        return doctorScheduleTo;
    }

    public String getDoctorScheduleFrom() {
        return doctorScheduleFrom;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public Collection<Appointment> getAppointmentsByDoctorScheduleId() {
        return appointmentsByDoctorScheduleId;
    }

    public Doctor getDoctorByDoctorId() {
        return doctorByDoctorId;
    }

    @Override
    public String toString() {
        return "DoctorScheduleDTO{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", doctorScheduleTo=" + doctorScheduleTo +
                ", doctorScheduleFrom=" + doctorScheduleFrom +
                ", dayOfWeek=" + dayOfWeek +
                ", appointmentsByDoctorScheduleId=" + appointmentsByDoctorScheduleId +
                ", doctorByDoctorId=" + doctorByDoctorId +
                '}';
    }
}
