package com.example.repository;

import com.example.domain.AuthorityStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by HELLZ on 12/26/2016.
 */
public interface AuthorityStaffRepository extends JpaRepository<AuthorityStaff,Integer>{
    List<AuthorityStaff> findAll();
    Optional<AuthorityStaff> findOneById(Integer id);
    void delete(AuthorityStaff d);
}
