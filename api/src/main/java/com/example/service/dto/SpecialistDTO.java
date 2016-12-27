package com.example.service.dto;

import com.example.domain.Specialist;

import java.util.Collection;

/**
 * Created by japnica on 12/22/2016.
 */
public class SpecialistDTO {
    private Long id;
    private String specialistName;

    public SpecialistDTO(Long id, String specialistName) {
        this.id = id;
        this.specialistName = specialistName;
    }

    public SpecialistDTO() {
    }

    public SpecialistDTO(Specialist specialist){
        this(specialist.getId(), specialist.getSpecialistName());
    }

    public Long getId() {
        return id;
    }

    public String getSpecialistName() {
        return specialistName;
    }


    @Override
    public String toString() {
        return "SpecialistDTO{" +
                "id=" + id +
                ", specialistName='" + specialistName + '\'' +
                '}';
    }
}
