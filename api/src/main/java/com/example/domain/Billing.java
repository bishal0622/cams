package com.example.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by japnica on 12/20/2016.
 */
@Entity
@Table(name="billing")
public class Billing {
    @Id
    @GeneratedValue
    @Column(name="billId")
    private Long id;

    @OneToOne
    @JoinColumn(name="patientId", referencedColumnName = "patientId")
    private Patient patient;

    @Column(name="billingDate", nullable = false)
    private Timestamp billingDate;

    @ManyToOne
    @JoinColumn(name="staffId", referencedColumnName = "staffId")
    private  Staff staff;

    @Column(name="discount")
    private Double discount;

    @Column(name="tax")
    private  Double tax;

    @Column(name="grandTotal", nullable = false)
    private Double grandTotal;

    @Column(name="amount", nullable = false)
    private Double amount;

//    @OneToMany(mappedBy = "billing")
//    private Collection<ParticularBilling> particularBillings;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Timestamp getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Timestamp billingDate) {
        this.billingDate = billingDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", patient=" + patient +
                ", billingDate=" + billingDate +
                ", staff=" + staff +
                ", discount=" + discount +
                ", tax=" + tax +
                ", grandTotal=" + grandTotal +
                ", amount=" + amount +
                '}';
    }
}
