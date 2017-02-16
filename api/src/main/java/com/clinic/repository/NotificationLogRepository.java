package com.clinic.repository;

import com.clinic.domain.Appointment;
import com.clinic.domain.NotificationLog;
import com.clinic.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public interface NotificationLogRepository extends JpaRepository<NotificationLog,Integer> {
    List<NotificationLog> findAll();
    Optional<NotificationLog> findOneById(Integer id);
    void delete(NotificationLog d);

    @Query(value = "select count(n) from NotificationLog n where n.status='unchecked'")
    Integer countPending();

    @Query(value = "select count(n) from NotificationLog n where n.status='booked'")
    Integer countBooked();

    @Query(value = "select count(n) from NotificationLog n where n.status='rejected'")
    Integer countRejected();



}
