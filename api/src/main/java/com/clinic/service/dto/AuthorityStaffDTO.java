package com.clinic.service.dto;

import com.clinic.domain.Authority;
import com.clinic.domain.AuthorityStaff;
import com.clinic.domain.Staff;

/**
 * Created by HELLZ on 12/26/2016.
 */
public class AuthorityStaffDTO
{
    private Integer id;
    private Integer authorityauthorityId;
    private Integer staffstaffId;
    private Authority authorityByAuthorityauthorityId;
    private Staff staffByStaffstaffId;

    public AuthorityStaffDTO(){}

    public AuthorityStaffDTO(Integer id, Integer authorityauthorityId, Integer staffstaffId, Authority authorityByAuthorityauthorityId, Staff staffByStaffstaffId) {
        this.id = id;
        this.authorityauthorityId = authorityauthorityId;
        this.staffstaffId = staffstaffId;
        this.authorityByAuthorityauthorityId = authorityByAuthorityauthorityId;
        this.staffByStaffstaffId = staffByStaffstaffId;
    }

    public AuthorityStaffDTO(AuthorityStaff authorityStaff){
        this(authorityStaff.getId(),authorityStaff.getAuthorityauthorityId(),authorityStaff.getStaffstaffId(),authorityStaff.getAuthorityByAuthorityauthorityId(),authorityStaff.getStaffByStaffstaffId());
    }

    public Integer getId() {
        return id;
    }

    public Integer getAuthorityauthorityId() {
        return authorityauthorityId;
    }

    public Integer getStaffstaffId() {
        return staffstaffId;
    }

    public Authority getAuthorityByAuthorityauthorityId() {
        return authorityByAuthorityauthorityId;
    }

    public Staff getStaffByStaffstaffId() {
        return staffByStaffstaffId;
    }

    @Override
    public String toString() {
        return "AuthorityStaffDTO{" +
                "id=" + id +
                ", authorityauthorityId=" + authorityauthorityId +
                ", staffstaffId=" + staffstaffId +
                ", authorityByAuthorityauthorityId=" + authorityByAuthorityauthorityId +
                ", staffByStaffstaffId=" + staffByStaffstaffId +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

