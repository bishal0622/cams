package com.example.service.dto;

import com.example.domain.Billing;
import com.example.domain.ParticularBilling;
import com.example.domain.Patient;
import com.example.domain.Staff;


import java.util.Collection;

/**
 * Created by japnica on 12/25/2016.
 */
public class BillingDTO {
    private Integer id;
    private Integer patientId;
    private String billingDate;
    private Integer staffId;
    private double discount;
    private double tax;
    private double grandTotal;
    private double amount;
    private Patient patientByPatientId;
    private Staff staffByStaffId;
    private Collection<ParticularBilling> particularBillingsByBillId;

    public BillingDTO() {
    }

    public BillingDTO(Integer id, Integer patientId, String billingDate, Integer staffId, double discount, double tax, double grandTotal, double amount, Patient patientByPatientId, Staff staffByStaffId, Collection<ParticularBilling> particularBillingsByBillId) {
        this.id = id;
        this.patientId = patientId;
        this.billingDate = billingDate;
        this.staffId = staffId;
        this.discount = discount;
        this.tax = tax;
        this.grandTotal = grandTotal;
        this.amount = amount;
        this.patientByPatientId = patientByPatientId;
        this.staffByStaffId = staffByStaffId;
        this.particularBillingsByBillId = particularBillingsByBillId;
    }

    public BillingDTO(Billing billing){
        this(billing.getId(),billing.getPatientId(),billing.getBillingDate(),billing.getStaffId(),billing.getDiscount(),billing.getTax(),billing.getGrandTotal(),billing.getAmount(),billing.getPatientByPatientId(),billing.getStaffByStaffId(),billing.getParticularBillingsByBillId());
    }

    public Integer getId() {
        return id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public double getAmount() {
        return amount;
    }

    public Patient getPatientByPatientId() {
        return patientByPatientId;
    }

    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public Collection<ParticularBilling> getParticularBillingsByBillId() {
        return particularBillingsByBillId;
    }

    @Override
    public String toString() {
        return "BillingDTO{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", billingDate=" + billingDate +
                ", staffId=" + staffId +
                ", discount=" + discount +
                ", tax=" + tax +
                ", grandTotal=" + grandTotal +
                ", amount=" + amount +
                ", patientByPatientId=" + patientByPatientId +
                ", staffByStaffId=" + staffByStaffId +
                ", particularBillingsByBillId=" + particularBillingsByBillId +
                '}';
    }
}
