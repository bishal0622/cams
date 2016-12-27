package com.example.service.dto;


import com.example.domain.Authority;

public class AuthorityDTO {
    private Long id;
    private String authorityName;

   // public AuthorityDTO(Long id, String authorityName)


    public AuthorityDTO(Long id, String authorityName) {
        this.id = id;
        this.authorityName = authorityName;
    }
    public AuthorityDTO(){

    }
    public AuthorityDTO(Authority authority){
        this(authority.getId(),authority.getAuthorityName());
    }

    public Long getId() {
        return id;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    @Override
    public String toString() {
        return "AuthorityDTO{" +
                "id=" + id +
                ", authorityName='" + authorityName + '\'' +
                '}';
    }
}


