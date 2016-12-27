package com.example.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by rajiv on 12/20/2016.
 */
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue
    @Column(name="patientId")
    private Long id;

    @Column(name="patientName", nullable = false)
    private String patientName;

    @Column(name="patientAddress", nullable = false)
    private String patientAddress;

    @Column(name = "patientContact", nullable = false)
    private String patientContact;

    @Column(name="age", nullable = false)
    private Long age;

    @Column(name="gender", nullable = false)
    private String gender;

    @Column(name="patientEmail", nullable = false)
    private String patientEmail;

//    @OneToMany(mappedBy = "patient")
//    private Collection<Billing> billings;
//
//    @OneToMany(mappedBy = "patient")
//    private  Collection<PatientAppointment> patientAppointments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

//    public Collection<Billing> getBillings() {
//        return billings;
//    }
//
//    public void setBillings(Collection<Billing> billings) {
//        this.billings = billings;
//    }
//
//    public Collection<PatientAppointment> getPatientAppointments() {
//        return patientAppointments;
//    }
//
//    public void setPatientAppointments(Collection<PatientAppointment> patientAppointments) {
//        this.patientAppointments = patientAppointments;
//    }

    @Override
    public String toString() {
        return "Patient{" +
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
