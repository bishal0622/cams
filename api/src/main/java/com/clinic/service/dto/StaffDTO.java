package com.clinic.service.dto;

//import com.clinic.domain.AuthorityStaff;
import com.clinic.domain.Authority;
import com.clinic.domain.Billing;
import com.clinic.domain.Staff;

import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/25/2016.
 */
public class StaffDTO {

    private Integer id;
    private String staffName;
    private String staffContact;
    private String password;
    private Integer type;
//    private Integer billingbillId;
//    private Collection<AuthorityStaff> authorityStaffsByStaffId;
    private Collection<Billing> billingsByStaffId;
    private Collection<Authority> authorities;

    public StaffDTO(){}

    public StaffDTO(Integer id, String staffName, String staffContact, String password, Integer type, Collection<Billing> billingsByStaffId, Collection<Authority> authorities) {
        this.id = id;
        this.staffName = staffName;
        this.staffContact = staffContact;
        this.password = password;
        this.type = type;
        this.billingsByStaffId = billingsByStaffId;
        this.authorities = authorities;
    }

    public StaffDTO(Staff staff){
        this(staff.getId(),staff.getStaffName(),staff.getStaffContact(),staff.getPassword(),staff.getType(), staff.getBillingsByStaffId(), staff.getAuthorities());
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

    public Integer getType() {
        return type;
    }

    //    public Integer getBillingbillId() {
//        return billingbillId;
//    }

//    public Collection<AuthorityStaff> getAuthorityStaffsByStaffId() {
//        return authorityStaffsByStaffId;
//    }

    public Collection<Billing> getBillingsByStaffId() {
        return billingsByStaffId;
    }

    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StaffDTO{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", staffContact='" + staffContact + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", billingsByStaffId=" + billingsByStaffId +
                ", authorities=" + authorities +
                '}';
    }
}

