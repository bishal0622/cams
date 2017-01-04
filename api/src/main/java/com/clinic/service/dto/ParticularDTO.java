package com.clinic.service.dto;

import com.clinic.domain.Particular;
import com.clinic.domain.ParticularBilling;

import java.util.Collection;

/**
 * Created by japnica on 12/25/2016.
 */
public class ParticularDTO {
    private Integer id;
    private String particularName;
    private double particularRate;
    private Collection<ParticularBilling> particularBillingsByParticularId;

    public ParticularDTO() {
    }

    public ParticularDTO(Integer id, String particularName, double particularRate, Collection<ParticularBilling> particularBillingsByParticularId) {
        this.id = id;
        this.particularName = particularName;
        this.particularRate = particularRate;
        this.particularBillingsByParticularId = particularBillingsByParticularId;
    }

    public ParticularDTO(Particular particular){
        this(particular.getId(),particular.getParticularName(),particular.getParticularRate(),particular.getParticularBillingsByParticularId());
    }

    public Integer getId() {
        return id;
    }

    public String getParticularName() {
        return particularName;
    }

    public double getParticularRate() {
        return particularRate;
    }

    public Collection<ParticularBilling> getParticularBillingsByParticularId() {
        return particularBillingsByParticularId;
    }

    @Override
    public String toString() {
        return "ParticularDTO{" +
                "id=" + id +
                ", particularName='" + particularName + '\'' +
                ", particularRate=" + particularRate +
                ", particularBillingsByParticularId=" + particularBillingsByParticularId +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
