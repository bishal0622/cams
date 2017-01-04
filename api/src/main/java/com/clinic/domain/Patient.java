package com.clinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
public class Patient {
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

    @Id
    @GeneratedValue
    @Column(name = "patient_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "patient_name", nullable = false, length = 255)
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Basic
    @Column(name = "patient_address", nullable = false, length = 255)
    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    @Basic
    @Column(name = "patient_contact", nullable = false, length = 255)
    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "gender", nullable = false, length = 255)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "weight", nullable = false)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "patient_email", nullable = false, length = 255)
    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (id != patient.id) return false;
        if (age != patient.age) return false;
        if (weight != patient.weight) return false;
        if (patientName != null ? !patientName.equals(patient.patientName) : patient.patientName != null) return false;
        if (patientAddress != null ? !patientAddress.equals(patient.patientAddress) : patient.patientAddress != null)
            return false;
        if (patientContact != null ? !patientContact.equals(patient.patientContact) : patient.patientContact != null)
            return false;
        if (gender != null ? !gender.equals(patient.gender) : patient.gender != null) return false;
        if (patientEmail != null ? !patientEmail.equals(patient.patientEmail) : patient.patientEmail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (patientName != null ? patientName.hashCode() : 0);
        result = 31 * result + (patientAddress != null ? patientAddress.hashCode() : 0);
        result = 31 * result + (patientContact != null ? patientContact.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + weight;
        result = 31 * result + (patientEmail != null ? patientEmail.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "patientByPatientpatientId")
    public Collection<Appointment> getAppointmentsByPatientId() {
        return appointmentsByPatientId;
    }

    public void setAppointmentsByPatientId(Collection<Appointment> appointmentsByPatientId) {
        this.appointmentsByPatientId = appointmentsByPatientId;
    }

    @OneToMany(mappedBy = "patientByPatientId")
    @JsonIgnore
    public Collection<Billing> getBillingsByPatientId() {
        return billingsByPatientId;
    }

    public void setBillingsByPatientId(Collection<Billing> billingsByPatientId) {
        this.billingsByPatientId = billingsByPatientId;
    }
}
