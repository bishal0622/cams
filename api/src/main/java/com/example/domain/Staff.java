package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
public class Staff {
    private Integer id;
    private String staffName;
    private String staffContact;
    private String password;
//    private Integer billingbillId;
    private Collection<AuthorityStaff> authorityStaffsByStaffId;
    private Collection<Billing> billingsByStaffId;

    @Id
    @GeneratedValue
    @Column(name = "staff_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "staff_name", nullable = false, length = 100)
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Basic
    @Column(name = "staff_contact", nullable = false, length = 255)
    public String getStaffContact() {
        return staffContact;
    }

    public void setStaffContact(String staffContact) {
        this.staffContact = staffContact;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != staff.id) return false;
//        if (billingbillId != staff.billingbillId) return false;
        if (staffName != null ? !staffName.equals(staff.staffName) : staff.staffName != null) return false;
        if (staffContact != null ? !staffContact.equals(staff.staffContact) : staff.staffContact != null) return false;
        if (password != null ? !password.equals(staff.password) : staff.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (staffName != null ? staffName.hashCode() : 0);
        result = 31 * result + (staffContact != null ? staffContact.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + billingbillId;
        return result;
    }

    @OneToMany(mappedBy = "staffByStaffstaffId")

    public Collection<AuthorityStaff> getAuthorityStaffsByStaffId() {
        return authorityStaffsByStaffId;
    }

    public void setAuthorityStaffsByStaffId(Collection<AuthorityStaff> authorityStaffsByStaffId) {
        this.authorityStaffsByStaffId = authorityStaffsByStaffId;
    }

    @OneToMany(mappedBy = "staffByStaffId")
    @JsonIgnore
    public Collection<Billing> getBillingsByStaffId() {
        return billingsByStaffId;
    }

    public void setBillingsByStaffId(Collection<Billing> billingsByStaffId) {
        this.billingsByStaffId = billingsByStaffId;
    }
}
