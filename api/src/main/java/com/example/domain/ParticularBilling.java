package com.example.domain;

import javax.persistence.*;

/**
 * Created by japnica on 12/20/2016.
 */
@Entity
@Table(name="particularBilling")
public class ParticularBilling {
    @Id
    @GeneratedValue
    @Column(name="particularBillingId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="particularId", referencedColumnName = "particularId")
    private Particular particular;

    @ManyToOne
    @JoinColumn(name="billId", referencedColumnName = "billId")
    private Billing billing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Particular getParticular() {
        return particular;
    }

    public void setParticular(Particular particular) {
        this.particular = particular;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    @Override
    public String toString() {
        return "ParticularBilling{" +
                "id=" + id +
                ", particular=" + particular +
                ", billing=" + billing +
                '}';
    }
}
