package com.clinic.service.genericService;

import com.clinic.domain.ParticularBilling;
import com.clinic.repository.ParticularBillingRepository;
import com.clinic.service.dto.ParticularBillingDTO;
import com.clinic.service.generic.ParticularBillingGeneric;
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
public class ParticularBillingService implements ParticularBillingGeneric{
    @Inject
    ParticularBillingRepository particularBillingRepository;

    private final Logger log = LoggerFactory.getLogger(ParticularBillingService.class);

//    public Optional<ParticularBilling> getParticularBillingById(Integer id){
//        Optional<ParticularBilling> particularBilling=particularBillingRepository.findOneById(id);
//        return particularBilling;
//    }

    @Override
    public ParticularBilling save(ParticularBillingDTO particularBillingDTO) {
        ParticularBilling particularBilling=new ParticularBilling();

        particularBilling.setBillingbillId(particularBillingDTO.getBillingbillId());
        particularBilling.setParticularparticularId(particularBillingDTO.getParticularparticularId());
        particularBilling.setBillingbillId(particularBillingDTO.getBillingbillId());
        particularBilling.setParticularByParticularparticularId(particularBillingDTO.getParticularByParticularparticularId());
        particularBilling.setBillingByBillingbillId(particularBillingDTO.getBillingByBillingbillId());

        particularBillingRepository.save(particularBilling);
        log.debug("Created Information for particularbilling: {}", particularBilling);
        return particularBilling;
    }

    @Override
    public List<ParticularBilling> getAll() {
        List<ParticularBilling> particularBillings=particularBillingRepository.findAll();
        return particularBillings;
    }

    @Override
    public void update(ParticularBillingDTO particularBillingDTO) {
        particularBillingRepository.findOneById(particularBillingDTO.getId()).ifPresent(particularBilling -> {
            particularBilling.setBillingbillId(particularBillingDTO.getBillingbillId());
            particularBilling.setParticularByParticularparticularId(particularBillingDTO.getParticularByParticularparticularId());
            particularBilling.setBillingByBillingbillId(particularBillingDTO.getBillingByBillingbillId());

            log.debug("Updated particular billing information: {}", particularBilling);
            particularBillingRepository.save(particularBilling);
        });

    }

    @Override
    public ParticularBilling findOne(int id) {
        return particularBillingRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        particularBillingRepository.findOneById(id).ifPresent(particularBilling -> {
            particularBillingRepository.delete(particularBilling);
            log.debug("Deleted Information: {}", particularBilling);
        });

    }
}
