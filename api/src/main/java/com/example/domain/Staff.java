package com.example.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by HELLZ on 12/20/2016.
 */
@Entity
@Table(name="staff")
public class Staff {
    @Id
    @GeneratedValue
    @Column(name="staffId")
    private Long id;

    @Column(name="staffName", nullable = false)
    private String staffName;

    @Column(name="staffContact", nullable = false)
    private String staffContact;

    @Column(name="password", nullable = false)
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffContact() {
        return staffContact;
    }

    public void setStaffContact(String staffContact) {
        this.staffContact = staffContact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", staffContact=" + staffContact +
                ", password='" + password + '\'' +
                '}';
    }
}
