package com.example.repository;

import com.example.domain.Appointment;
import com.example.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by rajiv on 12/26/2016.
 * Package clinic com.example.repository
 */

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    List<Authority> findAll();
    Optional<Authority> findOneById(Integer id);
    void delete(Authority d);
}

