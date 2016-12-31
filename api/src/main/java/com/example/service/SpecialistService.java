package com.example.service;

import com.example.domain.Doctor;
import com.example.domain.Specialist;
import com.example.repository.SpecialistRepository;
import com.example.service.dto.SpecialistDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/22/2016.
 */
@Service
@Transactional
public class SpecialistService {
    @Inject
    SpecialistRepository specialistRepository;

    private final Logger log = LoggerFactory.getLogger(SpecialistService.class);

    public Specialist saveSpecialist(SpecialistDTO specialistDTO){
        Specialist specialist=new Specialist();
        specialist.setSpecialistName(specialistDTO.getSpecialistName());
        specialist.setDoctorsBySpecialistId(specialistDTO.getDoctorsBySpecialistId());

        specialistRepository.save(specialist);

        log.debug("created information for specialist: {}", specialist);

        return specialist;
    }

    public List<Specialist> getAllSpecialist(){
        List<Specialist> specialist=specialistRepository.findAll();
        return specialist;
    }

    public void updateSpecialist(Integer specialistId, String specialistName, Collection<Doctor> doctorsBySpecialistId){
        specialistRepository.findOneById(specialistId).ifPresent(specialist->{
            specialist.setSpecialistName(specialistName);
            specialist.setDoctorsBySpecialistId(doctorsBySpecialistId);
            log.debug("Updated specialist information:{}", specialist);
            specialistRepository.save(specialist);
        });
    }

    public Optional<Specialist> getSpecialistById(Integer id){
        Optional<Specialist> specialist=specialistRepository.findOneById(id);
        return specialist;
    }

    public void deleteSpecialist(Integer id){
        specialistRepository.findOneById(id).ifPresent(specialist->{
            specialistRepository.delete(specialist);
            log.debug("Deleted Information:{}", specialist);
        });
    }
}
