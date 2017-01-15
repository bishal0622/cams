package com.clinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
public class Doctor {
    private Integer id;
    private String doctorName;
    private String doctorAddress;
    private String doctorContact;
    private String doctorEmail;
    private String hospitalsAssociated;
    private Integer specialistId;
    private Specialist specialistBySpecialistId;
    private Collection<DoctorSchedule> doctorSchedulesByDoctorId;
    private String photo;

    @Id
    @GeneratedValue
    @Column(name = "doctor_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "doctor_name", nullable = false, length = 255)
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Basic
    @Column(name = "doctor_address", nullable = false, length = 255)
    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    @Basic
    @Column(name = "doctor_contact", nullable = false, length = 255)
    public String getDoctorContact() {
        return doctorContact;
    }

    public void setDoctorContact(String doctorContact) {
        this.doctorContact = doctorContact;
    }

    @Basic
    @Column(name = "doctor_email", nullable = false, length = 255)
    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    @Basic
    @Column(name = "hospitals_associated", nullable = false, length = 255)
    public String getHospitalsAssociated() {
        return hospitalsAssociated;
    }

    public void setHospitalsAssociated(String hospitalsAssociated) {
        this.hospitalsAssociated = hospitalsAssociated;
    }

    @Basic
    @Column(name = "specialist_id", nullable = false)
    public Integer getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(Integer specialistId) {
        this.specialistId = specialistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (id != doctor.id) return false;
        if (specialistId != doctor.specialistId) return false;
        if (doctorName != null ? !doctorName.equals(doctor.doctorName) : doctor.doctorName != null) return false;
        if (doctorAddress != null ? !doctorAddress.equals(doctor.doctorAddress) : doctor.doctorAddress != null)
            return false;
        if (doctorContact != null ? !doctorContact.equals(doctor.doctorContact) : doctor.doctorContact != null)
            return false;
        if (doctorEmail != null ? !doctorEmail.equals(doctor.doctorEmail) : doctor.doctorEmail != null) return false;
        if (hospitalsAssociated != null ? !hospitalsAssociated.equals(doctor.hospitalsAssociated) : doctor.hospitalsAssociated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (doctorName != null ? doctorName.hashCode() : 0);
        result = 31 * result + (doctorAddress != null ? doctorAddress.hashCode() : 0);
        result = 31 * result + (doctorContact != null ? doctorContact.hashCode() : 0);
        result = 31 * result + (doctorEmail != null ? doctorEmail.hashCode() : 0);
        result = 31 * result + (hospitalsAssociated != null ? hospitalsAssociated.hashCode() : 0);
        result = 31 * result + specialistId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "specialist_id", referencedColumnName = "specialist_id", nullable = false, insertable = false, updatable = false)
    public Specialist getSpecialistBySpecialistId() {
        return specialistBySpecialistId;
    }

    public void setSpecialistBySpecialistId(Specialist specialistBySpecialistId) {
        this.specialistBySpecialistId = specialistBySpecialistId;
    }

    @OneToMany(mappedBy = "doctorByDoctorId")
    @JsonIgnore
    public Collection<DoctorSchedule> getDoctorSchedulesByDoctorId() {
        return doctorSchedulesByDoctorId;
    }

    public void setDoctorSchedulesByDoctorId(Collection<DoctorSchedule> doctorSchedulesByDoctorId) {
        this.doctorSchedulesByDoctorId = doctorSchedulesByDoctorId;
    }

    @Basic
    @Column(name="photo", nullable=true)

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
