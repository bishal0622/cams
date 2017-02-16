package com.clinic.service.genericService;

import com.clinic.domain.Appointment;
import com.clinic.domain.NotificationLog;
import com.clinic.repository.AppointmentRepository;
import com.clinic.repository.NotificationLogRepository;
import com.clinic.service.dto.NotificationLogDTO;
import com.clinic.service.generic.NotificationLogGeneric;
import com.clinic.service.genericService.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
@Service
@Transactional
public class NotificationLogService implements NotificationLogGeneric{


    @Inject
    NotificationLogRepository notificationLogRepository;

    @Inject
    AppointmentService appointmentService;

    private final Logger log = LoggerFactory.getLogger(DoctorService.class);


    @Override
    public NotificationLog save(NotificationLogDTO notificationLogDTO) {
        NotificationLog notify=new NotificationLog();

        notify.setNotificationDatetime(notificationLogDTO.getNotificationDatetime());
        Appointment appointment=appointmentService.lastEntryAppointment();
        notify.setAppointmentId(appointment.getId());
        notify.setConfirmedDatetime(notificationLogDTO.getConfirmedDatetime());
        notify.setStatus(notificationLogDTO.getStatus());

        notificationLogRepository.save(notify);

        log.debug("created information for doctor: {}", notify);

        return notify;
    }

    @Override
    public List<NotificationLog> getAll() {
        List<NotificationLog> notification=notificationLogRepository.findAll();
        return notification;
    }

    @Override
    public void update(NotificationLogDTO notificationLogDTO) {
        notificationLogRepository.findOneById(notificationLogDTO.getId()).ifPresent(notification -> {
            notification.setNotificationDatetime(notificationLogDTO.getNotificationDatetime());
            notification.setConfirmedDatetime(notificationLogDTO.getConfirmedDatetime());
            notification.setStatus(notificationLogDTO.getStatus());
            log.debug("Updated doctor Information:{}", notification);
            notificationLogRepository.save(notification);
        });

    }

    @Override
    public NotificationLog findOne(int id) {
        return notificationLogRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        notificationLogRepository.findOneById(id).ifPresent(notify->{
            notificationLogRepository.delete(notify);
            log.debug("Deleted Information:{}",notify);
        });
    }
}
