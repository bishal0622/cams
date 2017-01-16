package com.clinic.repository;

import com.clinic.domain.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public interface NotificationLogRepository extends JpaRepository<NotificationLog,Integer> {
    List<NotificationLog> findAll();
    Optional<NotificationLog> findOneById(Integer id);
    void delete(NotificationLog d);
}
