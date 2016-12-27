package com.example.service.dto;

import com.example.domain.Billing;
import com.example.domain.Particular;
import com.example.domain.ParticularBilling;

/**
 * Created by japnica on 12/25/2016.
 */
public class ParticularBillingDTO {
    private Long id;
    private Particular particular;
    private Billing billing;

    public ParticularBillingDTO(Long id, Particular particular, Billing billing) {
        this.id = id;
        this.particular = particular;
        this.billing = billing;
    }

    public ParticularBillingDTO() {
    }

    public ParticularBillingDTO(ParticularBilling particularBilling){
        this(particularBilling.getId(),particularBilling.getParticular(),particularBilling.getBilling());
    }

    public Long getId() {
        return id;
    }

    public Particular getParticular() {
        return particular;
    }

    public Billing getBilling() {
        return billing;
    }

    @Override
    public String toString() {
        return "ParticularBillingDTO{" +
                "id=" + id +
                ", particular=" + particular +
                ", billing=" + billing +
                '}';
    }
}
