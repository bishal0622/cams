package com.example.service;

import com.example.domain.Appointment;
import com.example.domain.PatientAppointment;
import com.example.repository.PatientAppointmentRepository;
import com.example.service.dto.PatientAppointmentDTO;
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
public class PatientAppointmentService {

    @Inject
    PatientAppointmentRepository patientAppointmentRepository;

    private final Logger log = LoggerFactory.getLogger(AppointmentService.class);

    public PatientAppointment savePatientAppointment(PatientAppointmentDTO patientAppointmentDTO){
        PatientAppointment patientAppointment=new PatientAppointment();

        patientAppointment.setAppointment(patientAppointmentDTO.getAppointment());
//        patientAppointment.setPatient(patientAppointmentDTO.getPatient());

        patientAppointmentRepository.save(patientAppointment);

        return patientAppointment;
    }

    public List<PatientAppointment> getAllPatientAppointments(){
        List<PatientAppointment> patientAppointments=patientAppointmentRepository.findAll();
        return patientAppointments;
    }

    public void updatePatientAppointment(Long id, Appointment appointment ){
        patientAppointmentRepository.findOneById(id).ifPresent(patientAppointment->{
            patientAppointment.setId(id);
           patientAppointment.setAppointment(appointment);
//            patientAppointment.setPatient(patient);

            log.debug("Updated specialist information:{}", patientAppointment);
            patientAppointmentRepository.save(patientAppointment);
        });
    }

    public Optional<PatientAppointment> getPatientAppointmentById(Long id){
        Optional<PatientAppointment> patientAppointment=patientAppointmentRepository.findOneById(id);
        return patientAppointment;
    }

    public void deletePatientAppointment(Long id){
        patientAppointmentRepository.findOneById(id).ifPresent(patientAppointment->{
            patientAppointmentRepository.delete(patientAppointment);
            log.debug("Deleted Information:{}", patientAppointment);
        });
    }
}
