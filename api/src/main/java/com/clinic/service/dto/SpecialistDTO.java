package com.clinic.service.dto;

import com.clinic.domain.Doctor;
import com.clinic.domain.Specialist;

import java.util.Collection;

/**
 * Created by japnica on 12/22/2016.
 */
public class SpecialistDTO {
    private Integer id;
    private String specialistName;
    private Collection<Doctor> doctorsBySpecialistId;

    public SpecialistDTO() {
    }

    public SpecialistDTO(Integer id, String specialistName, Collection<Doctor> doctorsBySpecialistId) {
        this.id = id;
        this.specialistName = specialistName;
        this.doctorsBySpecialistId = doctorsBySpecialistId;
    }

    public SpecialistDTO(Specialist specialist){
        this(specialist.getId(),specialist.getSpecialistName(),specialist.getDoctorsBySpecialistId());
    }

    public Integer getId() {
        return id;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public Collection<Doctor> getDoctorsBySpecialistId() {
        return doctorsBySpecialistId;
    }

    @Override
    public String toString() {
        return "SpecialistDTO{" +
                "id=" + id +
                ", specialistName='" + specialistName + '\'' +
                ", doctorsBySpecialistId=" + doctorsBySpecialistId +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
