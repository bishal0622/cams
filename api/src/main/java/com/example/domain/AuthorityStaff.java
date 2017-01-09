package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
@Table(name = "authority_staff", schema = "clinic", catalog = "")
public class AuthorityStaff {
    private Integer id;
    private Integer authorityauthorityId;
    private Integer staffstaffId;
    private Authority authorityByAuthorityauthorityId;
    private Staff staffByStaffstaffId;

    @Id
    @GeneratedValue
    @Column(name = "authority_staff_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "authorityauthority_id", nullable = false)
    public Integer getAuthorityauthorityId() {
        return authorityauthorityId;
    }

    public void setAuthorityauthorityId(Integer authorityauthorityId) {
        this.authorityauthorityId = authorityauthorityId;
    }

    @Basic
    @Column(name = "staffstaff_id", nullable = false)
    public Integer getStaffstaffId() {
        return staffstaffId;
    }

    public void setStaffstaffId(Integer staffstaffId) {
        this.staffstaffId = staffstaffId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorityStaff that = (AuthorityStaff) o;

        if (id != that.id) return false;
        if (authorityauthorityId != that.authorityauthorityId) return false;
        if (staffstaffId != that.staffstaffId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + authorityauthorityId;
        result = 31 * result + staffstaffId;
        return result;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "authorityauthority_id", referencedColumnName = "authority_id", nullable = false, insertable = false, updatable = false)
    public Authority getAuthorityByAuthorityauthorityId() {
        return authorityByAuthorityauthorityId;
    }

    public void setAuthorityByAuthorityauthorityId(Authority authorityByAuthorityauthorityId) {
        this.authorityByAuthorityauthorityId = authorityByAuthorityauthorityId;
    }


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "staffstaff_id", referencedColumnName = "staff_id", nullable = false, insertable = false, updatable = false)
    public Staff getStaffByStaffstaffId() {
        return staffByStaffstaffId;
    }

    public void setStaffByStaffstaffId(Staff staffByStaffstaffId) {
        this.staffByStaffstaffId = staffByStaffstaffId;
    }
}
