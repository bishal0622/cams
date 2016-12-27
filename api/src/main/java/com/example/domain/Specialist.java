package com.example.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by rajiv on 12/20/2016.
 */
@Entity
@Table(name="specialist")
public class Specialist {
    @Id
    @GeneratedValue
    @Column(name="specialistId")
    private Long id;

    @Column(name = "specialistName", nullable = false)
    private String specialistName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }


    @Override
    public String toString() {
        return "Specialist{" +
                "id=" + id +
                ", specialistName='" + specialistName + '\'' +
                '}';
    }
}
