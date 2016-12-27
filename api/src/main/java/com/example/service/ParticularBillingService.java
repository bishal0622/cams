package com.example.service;

import com.example.domain.Billing;
import com.example.domain.Particular;
import com.example.domain.ParticularBilling;
import com.example.repository.ParticularBillingRepository;
import com.example.service.dto.ParticularBillingDTO;
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
public class ParticularBillingService {
    @Inject
    ParticularBillingRepository particularBillingRepository;

    private final Logger log = LoggerFactory.getLogger(ParticularBillingService.class);

    public ParticularBilling saveParticularBilling(ParticularBillingDTO particularBillingDTO){
        ParticularBilling particularBilling=new ParticularBilling();
        particularBilling.setParticular(particularBillingDTO.getParticular());
        particularBilling.setBilling(particularBillingDTO.getBilling());
        particularBillingRepository.save(particularBilling);
        log.debug("Created Information for particularbilling: {}", particularBilling);
        return particularBilling;
    }

    public List<ParticularBilling> getAllParticularBilling(){
        List<ParticularBilling> particularBillings=particularBillingRepository.findAll();
        return particularBillings;
    }

    public void updateParticularBilling(Long id, Particular particular, Billing billing){
        particularBillingRepository.findOneById(id).ifPresent(particularBilling -> {
            particularBilling.setId(id);
            particularBilling.setParticular(particular);
            particularBilling.setBilling(billing);

            log.debug("Updated particular billing information: {}", particularBilling);
            particularBillingRepository.save(particularBilling);
        });
    }

    public Optional<ParticularBilling> getParticularBillingById(Long id){
        Optional<ParticularBilling> particularBilling=particularBillingRepository.findOneById(id);
        return particularBilling;
    }

    public void deleteParticularBilling(Long id){
        particularBillingRepository.findOneById(id).ifPresent(particularBilling -> {
            particularBillingRepository.delete(particularBilling);
            log.debug("Deleted Information: {}", particularBilling);
        });
    }
}
