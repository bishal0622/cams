package com.example.service.dto;

import com.example.domain.Billing;
import com.example.domain.Doctor;
import com.example.domain.Patient;
import com.example.domain.PatientAppointment;

import java.util.Collection;

/**
 * Created by japnica on 12/22/2016.
 */
public class PatientDTO {
    private Long id;
    private String patientName;
    private String patientAddress;
    private String patientContact;
    private Long age;
    private String gender;
    private String patientEmail;
//    private Collection<Billing> billings;
//    private  Collection<PatientAppointment> patientAppointments;

    public PatientDTO(Long id, String patientName, String patientAddress, String patientContact, Long age, String gender, String patientEmail) {
        this.id = id;
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.patientContact = patientContact;
        this.age = age;
        this.gender = gender;
        this.patientEmail = patientEmail;
//        this.billings = billings;
//        this.patientAppointments = patientAppointments;
    }

    public PatientDTO() {
    }

    public PatientDTO(Patient patient){
        this(patient.getId(), patient.getPatientName(), patient.getPatientAddress(),patient.getPatientContact(),patient.getAge(),patient.getGender(),patient.getPatientEmail());
    }

    public Long getId() {
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

    public Long getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

//    public Collection<Billing> getBillings() {
//        return billings;
//    }
//
//    public Collection<PatientAppointment> getPatientAppointments() {
//        return patientAppointments;
//    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientContact='" + patientContact + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
//                ", billings=" + billings +
//                ", patientAppointments=" + patientAppointments +
                '}';
    }
}
