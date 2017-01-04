package com.clinic.service.genericService;

import com.clinic.domain.Particular;
import com.clinic.repository.ParticularRepository;
import com.clinic.service.dto.ParticularDTO;
import com.clinic.service.generic.ParticularGeneric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by japnica on 12/25/2016.
 */
@Service
@Transactional
public class ParticularService implements ParticularGeneric{
    @Inject
    ParticularRepository particularRepository;
    private final Logger log = LoggerFactory.getLogger(ParticularService.class);

//    public Optional<Particular> getParticularById(Integer id){
//        Optional<Particular> particular=particularRepository.findOneById(id);
//        return particular;
//    }

    @Override
    public Particular save(ParticularDTO particularDTO) {
        Particular particular=new Particular();

        particular.setId(particularDTO.getId());
        particular.setParticularName(particularDTO.getParticularName());
        particular.setParticularRate(particularDTO.getParticularRate());


        particularRepository.save(particular);
        log.debug("Created Information for Particular: {}", particular);
        return particular;
    }

    @Override
    public List<Particular> getAll() {
        List<Particular> particulars=particularRepository.findAll();
        return particulars;
    }

    @Override
    public void update(ParticularDTO particularDTO) {
        particularRepository.findOneById(particularDTO.getId()).ifPresent(particular -> {
            particular.setParticularName(particularDTO.getParticularName());
            particular.setParticularRate(particularDTO.getParticularRate());
            particular.setParticularBillingsByParticularId(particularDTO.getParticularBillingsByParticularId());
            log.debug("Updated Particular Information: {}", particular);
            particularRepository.save(particular);
        });

    }

    @Override
    public Particular findOne(int id) {
        return particularRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        particularRepository.findOneById(id).ifPresent(particular -> {
            particularRepository.delete(particular);
            log.debug("Deleted Information for Particlar:{}", particular);
        });
    }
}
