package com.example.service.dto;

import com.example.domain.Authority;
import com.example.domain.AuthorityStaff;
import com.example.domain.Staff;

/**
 * Created by HELLZ on 12/26/2016.
 */
public class AuthorityStaffDTO
{
    private Long id;
    private Authority authority;
    private Staff staff;

    public AuthorityStaffDTO(){}

    public AuthorityStaffDTO(Long id, Authority authority, Staff staff) {
        this.id = id;
        this.authority = authority;
        this.staff = staff;
    }

    public AuthorityStaffDTO(AuthorityStaff authorityStaff){
        this(authorityStaff.getId(),authorityStaff.getAuthority(),authorityStaff.getStaff());
    }

    public Long getId() {
        return id;
    }

    public Authority getAuthority() {
        return authority;
    }

    public Staff getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        return "AuthorityStaffDTO{" +
                "id=" + id +
                ", authority=" + authority +
                ", staff=" + staff +
                '}';
    }

}

