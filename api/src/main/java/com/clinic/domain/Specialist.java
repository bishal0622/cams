package com.clinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
public class Specialist {
    private Integer id;
    private String specialistName;
    private Collection<Doctor> doctorsBySpecialistId;

    @Id
    @GeneratedValue
    @Column(name = "specialist_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "specialist_name", nullable = false, length = 100)
    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialist that = (Specialist) o;

        if (id != that.id) return false;
        if (specialistName != null ? !specialistName.equals(that.specialistName) : that.specialistName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (specialistName != null ? specialistName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "specialistBySpecialistId")
    @JsonIgnore
    public Collection<Doctor> getDoctorsBySpecialistId() {
        return doctorsBySpecialistId;
    }

    public void setDoctorsBySpecialistId(Collection<Doctor> doctorsBySpecialistId) {
        this.doctorsBySpecialistId = doctorsBySpecialistId;
    }
}
