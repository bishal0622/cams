package com.clinic.repository;

import com.clinic.domain.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/25/2016.
 */
public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Integer> {
    List<DoctorSchedule> findAll();
    Optional<DoctorSchedule> findOneById(Integer id);
    void delete(DoctorSchedule d);
}
