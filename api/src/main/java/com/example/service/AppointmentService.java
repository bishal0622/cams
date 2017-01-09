package com.example.service;

import com.example.domain.Appointment;
import com.example.domain.DoctorSchedule;
import com.example.domain.NotificationLog;
import com.example.domain.Patient;
import com.example.repository.AppointmentRepository;
import com.example.service.dto.AppointmentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.Time;

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

        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
       appointment.setDoctorScheduleId(appointmentDTO.getDoctorScheduleId());
        appointment.setComment(appointmentDTO.getComment());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setPatientpatientId(appointmentDTO.getPatientpatientId());
        appointment.setPatientByPatientpatientId(appointmentDTO.getPatientByPatientpatientId());
        appointment.setNotificationLogsByAppointmentId(appointmentDTO.getNotificationLogsByAppointmentId());
        appointmentRepository.save(appointment);

        return appointment;
    }

    public List<Appointment> getAllAppointments(){
        List<Appointment> appointments=appointmentRepository.findAll();
        return appointments;
    }

    public void updateAppointment(Integer appointmentId, String appointmentDate, Integer doctorScheduleId, String comment, String status, Integer patientpatientId, DoctorSchedule doctorSchedule, Patient patient,Collection<NotificationLog> notificationLog){
        appointmentRepository.findOneById(appointmentId).ifPresent(appointment->{
            appointment.setAppointmentDate(appointmentDate);
            appointment.setDoctorScheduleId(doctorScheduleId);
            appointment.setComment(comment);
            appointment.setStatus(status);
            appointment.setPatientpatientId(patientpatientId);
            appointment.setNotificationLogsByAppointmentId(notificationLog);

            log.debug("Updated specialist information:{}", appointment);
            appointmentRepository.save(appointment);
        });
    }

    public Optional<Appointment> getAppointmentById(Integer id){
        Optional<Appointment> appointment=appointmentRepository.findOneById(id);
        return appointment;
    }

    public void deleteAppointment(Integer id){
        appointmentRepository.findOneById(id).ifPresent(appointment->{
            appointmentRepository.delete(appointment);
            log.debug("Deleted Information:{}", appointment);
        });
    }
}


