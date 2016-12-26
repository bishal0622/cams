package com.example.service;

import com.example.domain.Appointment;
import com.example.domain.DoctorSchedule;
import com.example.domain.NotificationLog;
import com.example.domain.PatientAppointment;
import com.example.repository.AppointmentRepository;
import com.example.service.dto.AppointmentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
@Service
@Transactional
public class AppointmentService {

    @Inject
    AppointmentRepository appointmentRepository;

    private final Logger log = LoggerFactory.getLogger(AppointmentService.class);

    public Appointment saveAppointment(AppointmentDTO appointmentDTO){
        Appointment appointment=new Appointment();

        appointment.setDoctorSchedule(appointmentDTO.getDoctorSchedule());
        appointment.setComment(appointmentDTO.getComment());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setNotificationLogs(appointmentDTO.getNotificationLog());
        appointmentRepository.save(appointment);

        return appointment;
    }

    public List<Appointment> getAllAppointments(){
        List<Appointment> appointments=appointmentRepository.findAll();
        return appointments;
    }

    public void updateAppointment(Long id, DoctorSchedule doctorSchedule, String comment, String status, NotificationLog notificationLogs){
        appointmentRepository.findOneById(id).ifPresent(appointment->{
            appointment.setId(id);
            appointment.setDoctorSchedule(doctorSchedule);
            appointment.setComment(comment);
            appointment.setStatus(status);
            appointment.setNotificationLogs(notificationLogs);

            log.debug("Updated specialist information:{}", appointment);
            appointmentRepository.save(appointment);
        });
    }

    public Optional<Appointment> getAppointmentById(Long id){
        Optional<Appointment> appointment=appointmentRepository.findOneById(id);
        return appointment;
    }

    public void deleteAppointment(Long id){
        appointmentRepository.findOneById(id).ifPresent(appointment->{
            appointmentRepository.delete(appointment);
            log.debug("Deleted Information:{}", appointment);
        });
    }
}


