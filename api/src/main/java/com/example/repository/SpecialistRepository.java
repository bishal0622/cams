package com.example.repository;

import com.example.domain.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/22/2016.
 */
public interface SpecialistRepository extends JpaRepository<Specialist, Long>{
    List<Specialist> findAll();
    Optional<Specialist> findOneById(Long id);
    void delete(Specialist s);
}
