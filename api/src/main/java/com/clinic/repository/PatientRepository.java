package com.clinic.repository;

import com.clinic.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/23/2016.
 */
public interface PatientRepository extends JpaRepository<Patient, Integer>{
    List<Patient> findAll();
    Optional<Patient> findOneById(Integer id);
    void delete(Patient p);

    @Query("select p from Patient p where p.id=(select max(p.id) from Patient p)")
    Patient findPatient();

    @Query(value= "select d from Patient d where d.id=:id")
    Patient getOneById(@Param("id") Integer id);
}
