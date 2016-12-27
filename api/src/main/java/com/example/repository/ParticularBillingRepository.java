package com.example.repository;

import com.example.domain.ParticularBilling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/25/2016.
 */
public interface ParticularBillingRepository extends JpaRepository<ParticularBilling, Long>{
    List<ParticularBilling> findAll();
    Optional<ParticularBilling> findOneById(Long id);
    void delete(ParticularBilling p);
}
