package com.clinic.repository;

import com.clinic.domain.Doctor;
import com.clinic.domain.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by japnica on 1/9/2017.
 */
public interface SearchRepository extends JpaRepository<Specialist, Integer> {
    @Query(value= "select d.doctorsBySpecialistId from Specialist d where d.id=:id")
    List<Doctor> findDoctors(@Param("id") Integer id);
}
