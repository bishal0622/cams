package com.example.repository;

import com.example.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
    List<Appointment> findAll();
    Optional<Appointment> findOneById(long id);
    void delete(Appointment d);
}
