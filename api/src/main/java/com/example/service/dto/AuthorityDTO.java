package com.example.service.dto;


import com.example.domain.Authority;
import com.example.domain.AuthorityStaff;

import java.util.Collection;

public class AuthorityDTO {
    private Integer id;
    private String authorityName;
    private Collection<AuthorityStaff> authorityStaffsByAuthorityId;

    public Integer getId() {
        return id;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public Collection<AuthorityStaff> getAuthorityStaffsByAuthorityId() {
        return authorityStaffsByAuthorityId;
    }

    public AuthorityDTO(){}

    public AuthorityDTO(Integer id, String authorityName, Collection<AuthorityStaff> authorityStaffsByAuthorityId) {
        this.id = id;
        this.authorityName = authorityName;
        this.authorityStaffsByAuthorityId = authorityStaffsByAuthorityId;
    }

    public AuthorityDTO(Authority authority){
        this(authority.getId(),authority.getAuthorityName(),authority.getAuthorityStaffsByAuthorityId());
    }

    @Override
    public String toString() {
        return "AuthorityDTO{" +
                "id=" + id +
                ", authorityName='" + authorityName + '\'' +
                ", authorityStaffsByAuthorityId=" + authorityStaffsByAuthorityId +
                '}';
    }
}



