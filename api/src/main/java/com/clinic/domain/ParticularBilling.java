package com.clinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
@Table(name = "particular_billing", schema = "clinic", catalog = "")
public class ParticularBilling {
    private Integer id;
    private Integer particularparticularId;
    private Integer billingbillId;
    private Particular particularByParticularparticularId;
    private Billing billingByBillingbillId;

    @Id
    @GeneratedValue
    @Column(name = "particular_billing_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "particularparticular_id", nullable = false)
    public Integer getParticularparticularId() {
        return particularparticularId;
    }

    public void setParticularparticularId(Integer particularparticularId) {
        this.particularparticularId = particularparticularId;
    }

    @Basic
    @Column(name = "billingbill_id", nullable = false)
    public Integer getBillingbillId() {
        return billingbillId;
    }

    public void setBillingbillId(Integer billingbillId) {
        this.billingbillId = billingbillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticularBilling that = (ParticularBilling) o;

        if (id != that.id) return false;
        if (particularparticularId != that.particularparticularId) return false;
        if (billingbillId != that.billingbillId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + particularparticularId;
        result = 31 * result + billingbillId;
        return result;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "particularparticular_id", referencedColumnName = "particular_id", nullable = false, insertable = false, updatable = false)
    public Particular getParticularByParticularparticularId() {
        return particularByParticularparticularId;
    }

    public void setParticularByParticularparticularId(Particular particularByParticularparticularId) {
        this.particularByParticularparticularId = particularByParticularparticularId;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "billingbill_id", referencedColumnName = "bill_id", nullable = false, insertable = false, updatable = false)
    public Billing getBillingByBillingbillId() {
        return billingByBillingbillId;
    }

    public void setBillingByBillingbillId(Billing billingByBillingbillId) {
        this.billingByBillingbillId = billingByBillingbillId;
    }
}
