package com.example.repository;

import com.example.domain.PatientAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public interface PatientAppointmentRepository  extends JpaRepository<PatientAppointment, Long> {
    List<PatientAppointment> findAll();
    Optional<PatientAppointment> findOneById(long id);
    void delete(PatientAppointment d);
}
