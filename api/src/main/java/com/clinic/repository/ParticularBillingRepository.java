package com.clinic.repository;

import com.clinic.domain.ParticularBilling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/25/2016.
 */
public interface ParticularBillingRepository extends JpaRepository<ParticularBilling, Integer>{
    List<ParticularBilling> findAll();
    Optional<ParticularBilling> findOneById(Integer id);
    void delete(ParticularBilling p);
}
