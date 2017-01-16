package com.clinic.service.genericService;

import com.clinic.domain.Specialist;
import com.clinic.repository.SpecialistRepository;
import com.clinic.service.dto.SpecialistDTO;
import com.clinic.service.generic.SpecialistGeneric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by japnica on 12/22/2016.
 */
@Service
@Transactional
public class SpecialistService implements SpecialistGeneric{
    @Inject
    SpecialistRepository specialistRepository;

    private final Logger log = LoggerFactory.getLogger(SpecialistService.class);

//    public Optional<Specialist> getSpecialistById(Integer id){
//        Optional<Specialist> specialist=specialistRepository.findOneById(id);
//        return specialist;
//    }

    @Override
    public Specialist save(SpecialistDTO specialistDTO) {
        Specialist specialist=new Specialist();
        specialist.setSpecialistName(specialistDTO.getSpecialistName());
        specialist.setDoctorsBySpecialistId(specialistDTO.getDoctorsBySpecialistId());

        specialistRepository.save(specialist);

        log.debug("created information for specialist: {}", specialist);

        return specialist;
    }

    @Override
    public List<Specialist> getAll() {
        List<Specialist> specialist=specialistRepository.findAll();
        return specialist;
    }

    @Override
    public void update(SpecialistDTO specialistDTO) {
        specialistRepository.findOneById(specialistDTO.getId()).ifPresent(specialist -> {
            specialist.setSpecialistName(specialistDTO.getSpecialistName());
            specialist.setDoctorsBySpecialistId(specialistDTO.getDoctorsBySpecialistId());
            log.debug("Updated specialist information:{}", specialist);
            specialistRepository.save(specialist);
        });
    }

    @Override
    public Specialist findOne(int id) {
        return specialistRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        specialistRepository.findOneById(id).ifPresent(specialist->{
            specialistRepository.delete(specialist);
            log.debug("Deleted Information:{}", specialist);
        });
    }
}
