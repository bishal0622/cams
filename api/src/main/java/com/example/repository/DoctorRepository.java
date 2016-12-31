package com.example.repository;

import com.example.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/22/2016.
 */
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
    List<Doctor> findAll();
    Optional<Doctor> findOneById(Integer id);
    void delete(Doctor d);
}
