package com.clinic.service.dto;

import com.clinic.domain.Billing;
import com.clinic.domain.Particular;
import com.clinic.domain.ParticularBilling;

import java.util.Collection;

/**
 * Created by japnica on 12/25/2016.
 */
public class ParticularBillingDTO {
    private Integer id;
    private Integer particularparticularId;
    private Integer billingbillId;
    private Particular particularByParticularparticularId;
    private Billing billingByBillingbillId;


    public ParticularBillingDTO() {
    }

    public ParticularBillingDTO(Integer id, Integer particularparticularId, Integer billingbillId, Particular particularByParticularparticularId, Billing billingByBillingbillId) {
        this.id = id;
        this.particularparticularId = particularparticularId;
        this.billingbillId = billingbillId;
        this.particularByParticularparticularId = particularByParticularparticularId;
        this.billingByBillingbillId = billingByBillingbillId;
    }

    public ParticularBillingDTO(ParticularBilling particularBilling){
        this(particularBilling.getId(),particularBilling.getParticularparticularId(),particularBilling.getBillingbillId(),particularBilling.getParticularByParticularparticularId(),particularBilling.getBillingByBillingbillId());
    }

    public Integer getId() {
        return id;
    }

    public Integer getParticularparticularId() {
        return particularparticularId;
    }

    public Integer getBillingbillId() {
        return billingbillId;
    }

    public Particular getParticularByParticularparticularId() {
        return particularByParticularparticularId;
    }

    public Billing getBillingByBillingbillId() {
        return billingByBillingbillId;
    }

    @Override
    public String toString() {
        return "ParticularBillingDTO{" +
                "id=" + id +
                ", particularparticularId=" + particularparticularId +
                ", billingbillId=" + billingbillId +
                ", particularByParticularparticularId=" + particularByParticularparticularId +
                ", billingByBillingbillId=" + billingByBillingbillId +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
