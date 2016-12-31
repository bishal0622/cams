package com.example.service;

import com.example.domain.Appointment;
import com.example.domain.Billing;
import com.example.domain.Patient;
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
        patient.setWeight(patientDTO.getWeight());
        patient.setPatientEmail(patientDTO.getPatientEmail());
        patient.setAppointmentsByPatientId(patientDTO.getAppointmentsByPatientId());
        patient.setBillingsByPatientId(patientDTO.getBillingsByPatientId());

        patientRepository.save(patient);
        log.debug("created information for patient: {}", patient);

        return patient;
    }

    public List<Patient> getAllPatient(){
        List<Patient> patient=patientRepository.findAll();
        return patient;
    }

    public void updatePatient(Integer patientId, String patientName, String patientAddress, String patientContact, Integer age, String gender, Integer weight, String patientEmail, Collection<Appointment> appointmentsByPatientId, Collection<Billing> billingsByPatientId){
        patientRepository.findOneById(patientId).ifPresent(patient->{

            patient.setPatientName(patientName);
            patient.setPatientAddress(patientAddress);
            patient.setPatientContact(patientContact);
            patient.setAge(age);
            patient.setGender(gender);
            patient.setPatientEmail(patientEmail);
            patient.setWeight(weight);
            patient.setAppointmentsByPatientId(appointmentsByPatientId);
            patient.setBillingsByPatientId(billingsByPatientId);


            log.debug("Updated Patient Information:{}",patient);
            patientRepository.save(patient);
        });
    }

    public Optional<Patient> getPatientById(Integer id){
        Optional<Patient> patient=patientRepository.findOneById(id);
        return patient;
    }

    public void deletePatient(Integer id){
        patientRepository.findOneById(id).ifPresent(patient->{
            patientRepository.delete(patient);
            log.debug("Deleted Information:{}", patient);
        });
    }
}
