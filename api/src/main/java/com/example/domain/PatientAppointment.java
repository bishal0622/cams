package com.example.domain;

import javax.persistence.*;

/**
 * Created by japnica on 12/23/2016.
 */
@Entity
@Table(name="patientAppointment")
public class PatientAppointment {
    @Id
    @GeneratedValue
    @Column(name="patientAppointmentId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="appointmentId", referencedColumnName = "appointmentId")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "patientId")
    private Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "PatientAppointment{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", patient=" + patient +
                '}';
    }
}
