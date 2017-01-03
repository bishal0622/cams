package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
public class Authority {
    private Integer id;
    private String authorityName;
    private Collection<AuthorityStaff> authorityStaffsByAuthorityId;

    @Id
    @GeneratedValue
    @Column(name = "authority_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "authority_name", nullable = false, length = 255)
    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority = (Authority) o;

        if (id != authority.id) return false;
        if (authorityName != null ? !authorityName.equals(authority.authorityName) : authority.authorityName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (authorityName != null ? authorityName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "authorityByAuthorityauthorityId")
    @JsonIgnore
    public Collection<AuthorityStaff> getAuthorityStaffsByAuthorityId() {
        return authorityStaffsByAuthorityId;
    }

    public void setAuthorityStaffsByAuthorityId(Collection<AuthorityStaff> authorityStaffsByAuthorityId) {
        this.authorityStaffsByAuthorityId = authorityStaffsByAuthorityId;
    }
}
