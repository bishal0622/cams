package com.example.service.dto;

import com.example.domain.Billing;
import com.example.domain.Patient;
import com.example.domain.Staff;

import java.sql.Timestamp;

/**
 * Created by japnica on 12/25/2016.
 */
public class BillingDTO {
    private Long id;
    private Patient patient;
    private Timestamp billingDate;
    private Staff staff;
    private Double discount;
    private Double tax;
    private Double grandTotal;
    private Double amount;

    public BillingDTO(Long id, Patient patient, Timestamp billingDate, Staff staff, Double discount, Double tax, Double grandTotal, Double amount) {
        this.id = id;
        this.patient = patient;
        this.billingDate = billingDate;
        this.staff = staff;
        this.discount = discount;
        this.tax = tax;
        this.grandTotal = grandTotal;
        this.amount = amount;
    }

    public BillingDTO() {
    }

    public BillingDTO(Billing billing){
        this(billing.getId(),billing.getPatient(),billing.getBillingDate(),billing.getStaff(),billing.getDiscount(),billing.getTax(),billing.getGrandTotal(),billing.getAmount());
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Timestamp getBillingDate() {
        return billingDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public Double getDiscount() {
        return discount;
    }

    public Double getTax() {
        return tax;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "BillingDTO{" +
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
