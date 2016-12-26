package com.example.service.dto;

import com.example.domain.Appointment;
import com.example.domain.Patient;
import com.example.domain.PatientAppointment;

import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public class PatientAppointmentDTO {
    private Long id;
    private Appointment appointment;
    private Patient patient;

    public PatientAppointmentDTO(){}

    public PatientAppointmentDTO(Long id, Appointment appointment) {
        this.id = id;
        this.appointment = appointment;
//        this.patient = patient;
    }

    public PatientAppointmentDTO(PatientAppointment patientAppointment){
        this(patientAppointment.getId(),patientAppointment.getAppointment());
    }

    public Long getId() {
        return id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "PatientAppointmentDTO{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", patient=" + patient +
                '}';
    }
}
