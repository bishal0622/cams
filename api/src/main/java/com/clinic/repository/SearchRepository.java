package com.clinic.repository;

import com.clinic.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by japnica on 1/9/2017.
 */
public interface SearchRepository extends JpaRepository<Doctor, Integer> {
    @Query(value= "select doctor from Doctor doctor where doctor.specialistId=:id")
    List<Doctor> search(@Param("id") Integer id);
}
