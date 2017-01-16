package com.clinic.service.genericService;

import com.clinic.domain.Appointment;
import com.clinic.repository.AppointmentRepository;
import com.clinic.service.dto.AppointmentDTO;
import com.clinic.service.generic.AppointmentGeneric;
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
public class AppointmentService implements AppointmentGeneric{

    @Inject
    AppointmentRepository appointmentRepository;

    private final Logger log = LoggerFactory.getLogger(AppointmentService.class);


//    public Optional<Appointment> getAppointmentById(Integer id){
//        Optional<Appointment> appointment=appointmentRepository.findOneById(id);
//        return appointment;
//    }


    @Override
    public Appointment save(AppointmentDTO appointmentDTO) {
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

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointments=appointmentRepository.findAll();
        return appointments;
    }

    @Override
    public void update(AppointmentDTO appointmentDTO) {
        appointmentRepository.findOneById(appointmentDTO.getId()).ifPresent(appointment -> {
            appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
            appointment.setDoctorScheduleId(appointmentDTO.getDoctorScheduleId());
            appointment.setComment(appointmentDTO.getComment());
            appointment.setStatus(appointmentDTO.getStatus());
            appointment.setPatientpatientId(appointmentDTO.getPatientpatientId());
            appointment.setNotificationLogsByAppointmentId(appointmentDTO.getNotificationLogsByAppointmentId());

            log.debug("Updated specialist information:{}", appointment);
            appointmentRepository.save(appointment);
        });

    }

    @Override
    public Appointment findOne(int id) {
        return appointmentRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        appointmentRepository.findOneById(id).ifPresent(appointment->{
            appointmentRepository.delete(appointment);
            log.debug("Deleted Information:{}", appointment);
        });
    }
}


