package com.example.service;

import com.example.domain.Appointment;
import com.example.domain.NotificationLog;
import com.example.repository.NotificationLogRepository;
import com.example.service.dto.NotificationLogDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
@Service
@Transactional
public class NotificationLogService {


    @Inject
    NotificationLogRepository notificationLogRepository;

    private final Logger log = LoggerFactory.getLogger(DoctorService.class);

    public NotificationLog saveNotificationLog(NotificationLogDTO notificationLogDTO){
        NotificationLog notify=new NotificationLog();

        notify.setNotificationDatetime(notificationLogDTO.getNotificationDatetime());
        notify.setAppointmentId(notificationLogDTO.getAppointmentId());
        notify.setConfirmedDatetime(notificationLogDTO.getConfirmedDatetime());
        notify.setAppointmentByAppointmentId(notificationLogDTO.getAppointmentByAppointmentId());

        notificationLogRepository.save(notify);

        log.debug("created information for doctor: {}", notify);

        return notify;
    }

    public List<NotificationLog> getAllNotification(){
        List<NotificationLog> notification=notificationLogRepository.findAll();
        return notification;
    }

    public void updateNotification(Integer notificationId, String notificationDatetime, Integer appointmentId, String confirmedDatetime, Appointment appointmentByAppointmentId){
        notificationLogRepository.findOneById(notificationId).ifPresent(notification->{
            notification.setNotificationDatetime(notificationDatetime);
            notification.setConfirmedDatetime(confirmedDatetime);



            log.debug("Updated doctor Information:{}", notification);
            notificationLogRepository.save(notification);
        });
    }

    public Optional<NotificationLog> getNotificationById(Integer id){
        Optional<NotificationLog> notify=notificationLogRepository.findOneById(id);
        return notify;
    }

    public void deleteNotification(Integer id){
        notificationLogRepository.findOneById(id).ifPresent(notify->{
            notificationLogRepository.delete(notify);
            log.debug("Deleted Information:{}",notify);
        });
    }
}
