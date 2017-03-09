package com.clinic.service.genericService;

import com.clinic.domain.Patient;
import com.clinic.repository.PatientRepository;
import com.clinic.service.dto.PatientDTO;
import com.clinic.service.generic.PatientGeneric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by japnica on 12/23/2016.
 */
@Service
@Transactional
public class PatientService implements PatientGeneric{
    @Inject
    PatientRepository patientRepository;

    private final Logger log = LoggerFactory.getLogger(PatientService.class);

//    public Optional<Patient> getPatientById(Integer id){
//        Optional<Patient> patient=patientRepository.findOneById(id);
//        return patient;
//    }

    @Override
    public Patient save(PatientDTO patientDTO) {
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

    @Override
    public List<Patient> getAll() {
        List<Patient> patient=patientRepository.findAll();
        return patient;
    }

    @Override
    public void update(PatientDTO patientDTO) {
        patientRepository.findOneById(patientDTO.getId()).ifPresent(patient -> {
            patient.setPatientName(patientDTO.getPatientName());
            patient.setPatientAddress(patientDTO.getPatientAddress());
            patient.setPatientContact(patientDTO.getPatientContact());
            patient.setAge(patientDTO.getAge());
            patient.setGender(patientDTO.getGender());
            patient.setPatientEmail(patientDTO.getPatientEmail());
            patient.setWeight(patientDTO.getWeight());
            patient.setAppointmentsByPatientId(patientDTO.getAppointmentsByPatientId());
            patient.setBillingsByPatientId(patientDTO.getBillingsByPatientId());


            log.debug("Updated Patient Information:{}", patient);
            patientRepository.save(patient);
        });
    }

    @Override
    public Patient findOne(int id) {
        return patientRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        patientRepository.findOneById(id).ifPresent(patient->{
            patientRepository.delete(patient);
            log.debug("Deleted Information:{}", patient);
        });

    }

    public Patient lastEntryPatient(){
        return patientRepository.findPatient();
    }
}
