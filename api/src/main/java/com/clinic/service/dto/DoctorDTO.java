package com.clinic.service.dto;

import com.clinic.domain.Doctor;
import com.clinic.domain.DoctorSchedule;
import com.clinic.domain.Specialist;

import java.util.Collection;

/**
 * Created by japnica on 12/22/2016.
 */
public class DoctorDTO {
    private Integer id;
    private String doctorName;
    private String doctorAddress;
    private String doctorContact;
    private String doctorEmail;
    private String hospitalsAssociated;
    private Integer specialistId;
    private Specialist specialistBySpecialistId;
    private Collection<DoctorSchedule> doctorSchedulesByDoctorId;

    public DoctorDTO() {
    }

    public DoctorDTO(Integer id, String doctorName, String doctorAddress, String doctorContact, String doctorEmail, String hospitalsAssociated, Integer specialistId, Specialist specialistBySpecialistId, Collection<DoctorSchedule> doctorSchedulesByDoctorId) {
        this.id = id;
        this.doctorName = doctorName;
        this.doctorAddress = doctorAddress;
        this.doctorContact = doctorContact;
        this.doctorEmail = doctorEmail;
        this.hospitalsAssociated = hospitalsAssociated;
        this.specialistId = specialistId;
        this.specialistBySpecialistId = specialistBySpecialistId;
        this.doctorSchedulesByDoctorId = doctorSchedulesByDoctorId;
    }

    public DoctorDTO(Doctor doctor){
        this(doctor.getId(),doctor.getDoctorName(),doctor.getDoctorAddress(),doctor.getDoctorContact(),doctor.getDoctorEmail(),doctor.getHospitalsAssociated(),doctor.getSpecialistId(),doctor.getSpecialistBySpecialistId(),doctor.getDoctorSchedulesByDoctorId());
    }

    public Integer getId() {
        return id;
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

    public Integer getSpecialistId() {
        return specialistId;
    }

    public Specialist getSpecialistBySpecialistId() {
        return specialistBySpecialistId;
    }

    public Collection<DoctorSchedule> getDoctorSchedulesByDoctorId() {
        return doctorSchedulesByDoctorId;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", doctorAddress='" + doctorAddress + '\'' +
                ", doctorContact='" + doctorContact + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", hospitalsAssociated='" + hospitalsAssociated + '\'' +
                ", specialistId=" + specialistId +
                ", specialistBySpecialistId=" + specialistBySpecialistId +
                ", doctorSchedulesByDoctorId=" + doctorSchedulesByDoctorId +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

