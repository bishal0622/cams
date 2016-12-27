package com.example.service;

import com.example.domain.Particular;
import com.example.repository.ParticularRepository;
import com.example.service.dto.ParticularDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/25/2016.
 */
@Service
@Transactional
public class ParticularService {
    @Inject
    ParticularRepository particularRepository;
    private final Logger log = LoggerFactory.getLogger(ParticularService.class);

    public Particular saveParticular(ParticularDTO particularDTO){
        Particular particular=new Particular();
        particular.setParticularName(particularDTO.getParticularName());
        particular.setParticularRate(particularDTO.getParticularRate());
        particularRepository.save(particular);
        log.debug("Created Information for Particular: {}", particular);
        return particular;
    }

    public List<Particular> getAllParticular(){
        List<Particular> particulars=particularRepository.findAll();
        return particulars;
    }

    public void updateParticular(Long id, String particularName, Double particularRate){
        particularRepository.findOneById(id).ifPresent(particular->{
            particular.setId(id);
            particular.setParticularName(particularName);
            particular.setParticularRate(particularRate);
            log.debug("Updated Particular Information: {}", particular);
            particularRepository.save(particular);
        });
    }

    public Optional<Particular> getParticularById(Long id){
        Optional<Particular> particular=particularRepository.findOneById(id);
        return particular;
    }

    public void deleteParticular(Long id){
        particularRepository.findOneById(id).ifPresent(particular -> {
            particularRepository.delete(particular);
            log.debug("Deleted Information for Particlar:{}", particular);
        });
    }
}
