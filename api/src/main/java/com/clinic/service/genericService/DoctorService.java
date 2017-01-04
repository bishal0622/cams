package com.clinic.service.genericService;

import com.clinic.domain.Doctor;
import com.clinic.service.dto.DoctorDTO;
import com.clinic.service.generic.DoctorGeneric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import com.clinic.repository.DoctorRepository;

/**
 * Created by japnica on 12/22/2016.
 */
@Service
@Transactional
public class DoctorService implements DoctorGeneric {

    @Inject
    DoctorRepository doctorRepository;

    private final Logger log = LoggerFactory.getLogger(DoctorService.class);


//    public Optional<Doctor> getDoctorById(Integer id){
//        Optional<Doctor> doctor=doctorRepository.findOneById(id);
//        return doctor;
//    }

    @Override
    public Doctor save(DoctorDTO doctorDTO) {
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

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctor=doctorRepository.findAll();
        return doctor;
    }

    @Override
    public void update(DoctorDTO doctorDTO) {
        doctorRepository.findOneById(doctorDTO.getId()).ifPresent(doctor -> {
            doctor.setDoctorName(doctorDTO.getDoctorName());
            doctor.setDoctorAddress(doctorDTO.getDoctorAddress());
            doctor.setDoctorContact(doctorDTO.getDoctorContact());
            doctor.setDoctorEmail(doctorDTO.getDoctorEmail());
            doctor.setHospitalsAssociated(doctorDTO.getHospitalsAssociated());
            doctor.setSpecialistId(doctorDTO.getSpecialistId());
            doctor.setSpecialistBySpecialistId(doctorDTO.getSpecialistBySpecialistId());
            doctor.setDoctorSchedulesByDoctorId(doctorDTO.getDoctorSchedulesByDoctorId());

            log.debug("Updated doctor Information:{}", doctor);
            doctorRepository.save(doctor);
        });
    }

    @Override
    public Doctor findOne(int id) {
        return doctorRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        doctorRepository.findOneById(id).ifPresent(doctor->{
            doctorRepository.delete(doctor);
            log.debug("Deleted Information:{}",doctor);
        });
    }
}