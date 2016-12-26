package com.example.service.dto;

import com.example.domain.Staff;

/**
 * Created by BiSAl MhRzn on 12/25/2016.
 */
public class StaffDTO {

    private Long id;
    private String staffName;
    private String staffContact;
    private String password;

    public Long getId() {
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

    public StaffDTO(){}

    public StaffDTO(Long id, String staffName, String staffContact, String password) {
        this.id = id;
        this.staffName = staffName;
        this.staffContact = staffContact;
        this.password = password;
    }

    public StaffDTO(Staff staff){
        this(staff.getId(),staff.getStaffName(),staff.getStaffContact(),staff.getPassword());
    }

    @Override
    public String toString() {
        return "StaffDTO{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", staffContact='" + staffContact + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

