package com.clinic.repository;

import com.clinic.domain.Appointment;
import com.clinic.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by rajiv on 12/26/2016.
 * Package clinic com.clinic.repository
 */

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    List<Authority> findAll();
    Optional<Authority> findOneById(Integer id);
    void delete(Authority d);
}

