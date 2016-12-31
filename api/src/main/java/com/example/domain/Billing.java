package com.example.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
public class Billing {
    private Integer id;
    private Integer patientId;
    private Timestamp billingDate;
    private Integer staffId;
    private double discount;
    private double tax;
    private double grandTotal;
    private double amount;
    private Patient patientByPatientId;
    private Staff staffByStaffId;
    private Collection<ParticularBilling> particularBillingsByBillId;

    @Id
    @Column(name = "bill_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "patient_id", nullable = false)
    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "billing_date", nullable = false)
    public Timestamp getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Timestamp billingDate) {
        this.billingDate = billingDate;
    }

    @Basic
    @Column(name = "staff_id", nullable = false)
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "discount", nullable = false, precision = 0)
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "tax", nullable = false, precision = 0)
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Basic
    @Column(name = "grand_total", nullable = false, precision = 0)
    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 0)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Billing billing = (Billing) o;

        if (id != billing.id) return false;
        if (patientId != billing.patientId) return false;
        if (staffId != billing.staffId) return false;
        if (Double.compare(billing.discount, discount) != 0) return false;
        if (Double.compare(billing.tax, tax) != 0) return false;
        if (Double.compare(billing.grandTotal, grandTotal) != 0) return false;
        if (Double.compare(billing.amount, amount) != 0) return false;
        if (billingDate != null ? !billingDate.equals(billing.billingDate) : billing.billingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + patientId;
        result = 31 * result + (billingDate != null ? billingDate.hashCode() : 0);
        result = 31 * result + staffId;
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tax);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(grandTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", nullable = false, insertable = false, updatable = false)
    public Patient getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(Patient patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false, insertable = false, updatable = false)
    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    @OneToMany(mappedBy = "billingByBillingbillId")
    public Collection<ParticularBilling> getParticularBillingsByBillId() {
        return particularBillingsByBillId;
    }

    public void setParticularBillingsByBillId(Collection<ParticularBilling> particularBillingsByBillId) {
        this.particularBillingsByBillId = particularBillingsByBillId;
    }
}
