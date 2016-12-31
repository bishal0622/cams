package com.example.repository;

import com.example.domain.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/25/2016.
 */
public interface BillingRepository extends JpaRepository<Billing, Integer> {
    List<Billing> findAll();
    Optional<Billing> findOneById(Integer id);
    void delete(Billing b);
}
