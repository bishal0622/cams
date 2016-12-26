package com.example.repository;

import com.example.domain.Appointment;
import com.example.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/25/2016.
 */
public interface StaffRepository extends JpaRepository<Staff,Long>{
    List<Staff> findAll();
    Optional<Staff> findOneById(long id);
    void delete(Staff d);
}
