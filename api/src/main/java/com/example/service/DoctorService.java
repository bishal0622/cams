package com.example.service;

import com.example.domain.Doctor;
import com.example.domain.DoctorSchedule;
import com.example.domain.Specialist;
import com.example.service.dto.DoctorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import com.example.repository.DoctorRepository;

/**
 * Created by japnica on 12/22/2016.
 */
@Service
@Transactional
public class DoctorService {

    @Inject
    DoctorRepository doctorRepository;

    private final Logger log = LoggerFactory.getLogger(DoctorService.class);

    public Doctor saveDoctor(DoctorDTO doctorDTO){
        Doctor doctor=new Doctor();
        doctor.setDoctorName(doctorDTO.getDoctorName());
        doctor.setDoctorAddress(doctorDTO.getDoctorAddress());
        doctor.setDoctorContact(doctorDTO.getDoctorContact());
        doctor.setDoctorEmail(doctorDTO.getDoctorEmail());
        doctor.setHospitalsAssociated(doctorDTO.getHospitalsAssociated());
        doctor.setSpecialistId(doctorDTO.getSpecialistId());
        doctor.setSpecialistBySpecialistId(doctorDTO.getSpecialistBySpecialistId());
        doctor.setDoctorSchedulesByDoctorId(doctorDTO.getDoctorSchedulesByDoctorId());

        doctorRepository.save(doctor);

        log.debug("created information for doctor: {}", doctor);

        return doctor;
    }

    public List<Doctor> getAllDoctor(){
        List<Doctor> doctor=doctorRepository.findAll();
        return doctor;
    }

    public void updateDoctor(Integer doctorId, String doctorName, String doctorAddress, String doctorContact, String doctorEmail, String hospitalsAssociated, Integer specialistId, Specialist specialistBySpecialistId, Collection<DoctorSchedule> doctorSchedulesByDoctorId){
        doctorRepository.findOneById(doctorId).ifPresent(doctor->{
            doctor.setId(doctorId);
            doctor.setDoctorName(doctorName);
            doctor.setDoctorAddress(doctorAddress);
            doctor.setDoctorContact(doctorContact);
            doctor.setDoctorEmail(doctorEmail);
            doctor.setHospitalsAssociated(hospitalsAssociated);
            doctor.setSpecialistId(specialistId);
            doctor.setSpecialistBySpecialistId(specialistBySpecialistId);
            doctor.setDoctorSchedulesByDoctorId(doctorSchedulesByDoctorId);

            log.debug("Updated doctor Information:{}", doctor);
            doctorRepository.save(doctor);
        });
    }

    public Optional<Doctor> getDoctorById(Integer id){
        Optional<Doctor> doctor=doctorRepository.findOneById(id);
        return doctor;
    }

    public void deleteDoctor(Integer id){
        doctorRepository.findOneById(id).ifPresent(doctor->{
            doctorRepository.delete(doctor);
            log.debug("Deleted Information:{}",doctor);
        });
    }
}
