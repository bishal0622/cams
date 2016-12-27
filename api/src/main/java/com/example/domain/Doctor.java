package com.example.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by japnica on 12/20/2016.
 */
@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue
    @Column(name="doctorId")
    private Long id;

    @Column(name="doctorName", nullable = false)
    private String doctorName;

    @Column(name="doctorAddress", nullable = false)
    private String doctorAddress;

    @Column(name="doctorContact", nullable = false)
    private String doctorContact;

    @Column(name="doctorEmail", nullable = false)
    private String doctorEmail;

    @Column(name="hospitalsAssociated", nullable = false)
    private String hospitalsAssociated;

    @ManyToOne
    @JoinColumn(name="specialistId", referencedColumnName = "specialistId")
    private Specialist specialist;

//    @OneToMany(mappedBy = "doctor")
//    private Collection<DoctorSchedule> doctorSchedules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public String getDoctorContact() {
        return doctorContact;
    }

    public void setDoctorContact(String doctorContact) {
        this.doctorContact = doctorContact;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getHospitalsAssociated() {
        return hospitalsAssociated;
    }

    public void setHospitalsAssociated(String hospitalsAssociated) {
        this.hospitalsAssociated = hospitalsAssociated;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

//    public Collection<DoctorSchedule> getDoctorSchedules() {
//        return doctorSchedules;
//    }
//
//    public void setDoctorSchedules(Collection<DoctorSchedule> doctorSchedules) {
//        this.doctorSchedules = doctorSchedules;
//    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", doctorAddress=" + doctorAddress +
                ", doctorContact='" + doctorContact + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", hospitalsAssociated='" + hospitalsAssociated + '\'' +
                ", specialist=" + specialist +
//                ", doctorSchedules=" + doctorSchedules +
                '}';
    }
}
