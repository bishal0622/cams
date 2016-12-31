package com.example.repository;

import com.example.domain.Particular;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/25/2016.
 */
public interface ParticularRepository extends JpaRepository<Particular, Integer> {
    List<Particular> findAll();
    Optional<Particular> findOneById(Integer id);
    void delete(Particular p);
}
