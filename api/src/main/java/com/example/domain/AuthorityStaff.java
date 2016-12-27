package com.example.domain;

import javax.persistence.*;

/**
 * Created by japnica on 12/20/2016.
 */
@Entity
@Table(name="authorityStaff")
public class AuthorityStaff {
    @Id
    @GeneratedValue
    @Column(name="authorityStaffId")
    private Long id;


    @ManyToOne
    @JoinColumn(name="authorityId", referencedColumnName = "authorityId")
    private Authority authority;


    @ManyToOne
    @JoinColumn(name="staffId", referencedColumnName = "staffId")
    private Staff staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "AuthorityStaff{" +
                "id=" + id +
                ", authority=" + authority +
                ", staff=" + staff +
                '}';
    }
}
