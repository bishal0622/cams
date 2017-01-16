package com.clinic.repository;

import com.clinic.domain.Appointment;
import com.clinic.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/25/2016.
 */
public interface StaffRepository extends JpaRepository<Staff,Integer>{
    List<Staff> findAll();
    Optional<Staff> findOneById(Integer id);
    void delete(Staff d);
}
