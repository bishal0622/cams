package com.example.service;

import com.example.domain.Billing;
import com.example.domain.Patient;
import com.example.domain.PatientAppointment;
import com.example.repository.PatientRepository;
import com.example.service.dto.PatientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/23/2016.
 */
@Service
@Transactional
public class PatientService {
    @Inject
    PatientRepository patientRepository;

    private final Logger log = LoggerFactory.getLogger(PatientService.class);

    public Patient savePatient(PatientDTO patientDTO){
        Patient patient=new Patient();
        patient.setPatientName(patientDTO.getPatientName());
        patient.setPatientAddress(patientDTO.getPatientAddress());
        patient.setPatientContact(patientDTO.getPatientContact());
        patient.setAge(patientDTO.getAge());
        patient.setGender(patientDTO.getGender());
        patient.setPatientEmail(patientDTO.getPatientEmail());
//        patient.setBillings(patientDTO.getBillings());
//        patient.setPatientAppointments(patientDTO.getPatientAppointments());

        patientRepository.save(patient);
        log.debug("created information for patient: {}", patient);

        return patient;
    }

    public List<Patient> getAllPatient(){
        List<Patient> patient=patientRepository.findAll();
        return patient;
    }

    public void updatePatient(Long id, String patientName, String patientAddress, String patientContact, Long age, String gender, String patientEmail){
        patientRepository.findOneById(id).ifPresent(patient->{
            patient.setId(id);
            patient.setPatientName(patientName);
            patient.setPatientAddress(patientAddress);
            patient.setPatientContact(patientContact);
            patient.setAge(age);
            patient.setGender(gender);
            patient.setPatientEmail(patientEmail);
//            patient.setBillings(billings);
//            patient.setPatientAppointments(patientAppointments);
            log.debug("Updated Patient Information:{}",patient);
            patientRepository.save(patient);
        });
    }

    public Optional<Patient> getPatientById(Long id){
        Optional<Patient> patient=patientRepository.findOneById(id);
        return patient;
    }

    public void deletePatient(Long id){
        patientRepository.findOneById(id).ifPresent(patient->{
            patientRepository.delete(patient);
            log.debug("Deleted Information:{}", patient);
        });
    }
}
