package com.example.service.dto;

import com.example.domain.AuthorityStaff;
import com.example.domain.Billing;
import com.example.domain.Staff;

import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/25/2016.
 */
public class StaffDTO {

    private Integer id;
    private String staffName;
    private String staffContact;
    private String password;
    private Integer billingbillId;
    private Collection<AuthorityStaff> authorityStaffsByStaffId;
    private Collection<Billing> billingsByStaffId;

    public StaffDTO(){}

    public StaffDTO(Integer id, String staffName, String staffContact, String password, Integer billingbillId, Collection<AuthorityStaff> authorityStaffsByStaffId, Collection<Billing> billingsByStaffId) {
        this.id = id;
        this.staffName = staffName;
        this.staffContact = staffContact;
        this.password = password;
        this.billingbillId = billingbillId;
        this.authorityStaffsByStaffId = authorityStaffsByStaffId;
        this.billingsByStaffId = billingsByStaffId;
    }

    public StaffDTO(Staff staff){
        this(staff.getId(),staff.getStaffName(),staff.getStaffContact(),staff.getPassword(),staff.getBillingbillId(),staff.getAuthorityStaffsByStaffId(),staff.getBillingsByStaffId());
    }

    public Integer getId() {
        return id;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffContact() {
        return staffContact;
    }

    public String getPassword() {
        return password;
    }

    public Integer getBillingbillId() {
        return billingbillId;
    }

    public Collection<AuthorityStaff> getAuthorityStaffsByStaffId() {
        return authorityStaffsByStaffId;
    }

    public Collection<Billing> getBillingsByStaffId() {
        return billingsByStaffId;
    }

    @Override
    public String toString() {
        return "StaffDTO{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", staffContact='" + staffContact + '\'' +
                ", password='" + password + '\'' +
                ", billingbillId=" + billingbillId +
                ", authorityStaffsByStaffId=" + authorityStaffsByStaffId +
                ", billingsByStaffId=" + billingsByStaffId +
                '}';
    }
}

