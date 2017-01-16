package com.clinic.service.dto;

import com.clinic.domain.*;

import java.util.Collection;

/**
 * Created by japnica on 12/22/2016.
 */
public class PatientDTO {
    private Integer id;
    private String patientName;
    private String patientAddress;
    private String patientContact;
    private Integer age;
    private String gender;
    private Integer weight;
    private String patientEmail;
    private Collection<Appointment> appointmentsByPatientId;
    private Collection<Billing> billingsByPatientId;

    public PatientDTO() {
    }

    public PatientDTO(Integer id, String patientName, String patientAddress, String patientContact, Integer age, String gender, Integer weight, String patientEmail, Collection<Appointment> appointmentsByPatientId, Collection<Billing> billingsByPatientId) {
        this.id = id;
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.patientContact = patientContact;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.patientEmail = patientEmail;
        this.appointmentsByPatientId = appointmentsByPatientId;
        this.billingsByPatientId = billingsByPatientId;
    }

    public PatientDTO(Patient patient){
        this(patient.getId(),patient.getPatientName(),patient.getPatientAddress(),patient.getPatientContact(),patient.getAge(),patient.getGender(),patient.getWeight(),patient.getPatientEmail(),patient.getAppointmentsByPatientId(),patient.getBillingsByPatientId());
    }

    public Integer getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public Collection<Appointment> getAppointmentsByPatientId() {
        return appointmentsByPatientId;
    }

    public Collection<Billing> getBillingsByPatientId() {
        return billingsByPatientId;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientContact='" + patientContact + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", patientEmail='" + patientEmail + '\'' +
                ", appointmentsByPatientId=" + appointmentsByPatientId +
                ", billingsByPatientId=" + billingsByPatientId +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
