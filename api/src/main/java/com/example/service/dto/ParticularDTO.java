package com.example.service.dto;

import com.example.domain.Particular;

/**
 * Created by japnica on 12/25/2016.
 */
public class ParticularDTO {
    private Long id;
    private String particularName;
    private Double particularRate;

    public ParticularDTO(Long id, String particularName, Double particularRate) {
        this.id = id;
        this.particularName = particularName;
        this.particularRate = particularRate;
    }

    public ParticularDTO() {
    }

    public ParticularDTO(Particular particular){
        this(particular.getId(),particular.getParticularName(),particular.getParticularRate());
    }

    public Long getId() {
        return id;
    }

    public String getParticularName() {
        return particularName;
    }

    public Double getParticularRate() {
        return particularRate;
    }

    @Override
    public String toString() {
        return "ParticularDTO{" +
                "id=" + id +
                ", particularName='" + particularName + '\'' +
                ", particularRate=" + particularRate +
                '}';
    }
}
