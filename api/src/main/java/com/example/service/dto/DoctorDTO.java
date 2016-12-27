package com.example.service.dto;

import com.example.domain.Doctor;

import java.util.Collection;

/**
 * Created by japnica on 12/22/2016.
 */
public class DoctorDTO {
    private Long doctorId;
    private String doctorName;
    private String doctorAddress;
    private String doctorContact;
    private String doctorEmail;
    private String hospitalsAssociated;


    public DoctorDTO(Long doctorId, String doctorName, String doctorAddress, String doctorContact, String doctorEmail, String hospitalsAssociated) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorAddress = doctorAddress;
        this.doctorContact = doctorContact;
        this.doctorEmail = doctorEmail;
        this.hospitalsAssociated = hospitalsAssociated;
    }

    public DoctorDTO() {
    }

    public DoctorDTO(Doctor doctor){
        this(doctor.getId(),doctor.getDoctorName(),doctor.getDoctorAddress(),doctor.getDoctorContact(),doctor.getDoctorEmail(),doctor.getHospitalsAssociated());
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public String getDoctorContact() {
        return doctorContact;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public String getHospitalsAssociated() {
        return hospitalsAssociated;
    }


    @Override
    public String toString() {
        return "DoctorDTO{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", doctorAddress='" + doctorAddress + '\'' +
                ", doctorContact='" + doctorContact + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", hospitalsAssociated='" + hospitalsAssociated + '\'' +
                '}';
    }
}
