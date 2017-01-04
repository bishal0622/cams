package com.clinic.service.genericService;

import com.clinic.domain.*;
import com.clinic.repository.BillingRepository;
import com.clinic.service.dto.BillingDTO;
import com.clinic.service.generic.BillingGeneric;
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
public class BillingService implements BillingGeneric{
    @Inject
    BillingRepository billingRepository;

    private final Logger log = LoggerFactory.getLogger(BillingService.class);

//    public Optional<Billing> getBillingById(Integer id){
//        Optional<Billing> billing=billingRepository.findOneById(id);
//        return billing;
//    }

    @Override
    public Billing save(BillingDTO billingDTO) {
        Billing billing=new Billing();

        billing.setPatientId(billingDTO.getPatientId());
        billing.setBillingDate(billingDTO.getBillingDate());
        billing.setStaffId(billingDTO.getStaffId());
        billing.setDiscount(billingDTO.getDiscount());
        billing.setTax(billingDTO.getTax());
        billing.setGrandTotal(billingDTO.getGrandTotal());
        billing.setAmount(billingDTO.getAmount());
        billing.setPatientByPatientId(billingDTO.getPatientByPatientId());
        billing.setStaffByStaffId(billingDTO.getStaffByStaffId());
        billing.setParticularBillingsByBillId(billingDTO.getParticularBillingsByBillId());



        billingRepository.save(billing);
        log.debug("Created Information for Billing: {}", billing);
        return billing;
    }

    @Override
    public List<Billing> getAll() {
        List<Billing> billings=billingRepository.findAll();
        return billings;
    }

    @Override
    public void update(BillingDTO billingDTO) {
        billingRepository.findOneById(billingDTO.getId()).ifPresent(billing -> {
            billing.setPatientId(billingDTO.getPatientId());
            billing.setBillingDate(billingDTO.getBillingDate());
            billing.setStaffId(billingDTO.getStaffId());
            billing.setDiscount(billingDTO.getDiscount());
            billing.setTax(billingDTO.getTax());
            billing.setGrandTotal(billingDTO.getGrandTotal());
            billing.setAmount(billingDTO.getGrandTotal());
            billing.setPatientByPatientId(billingDTO.getPatientByPatientId());
            billing.setStaffByStaffId(billingDTO.getStaffByStaffId());
            billing.setParticularBillingsByBillId(billingDTO.getParticularBillingsByBillId());
            log.debug("Updated Information for Billing: {}", billing);
            billingRepository.save(billing);
        });
    }

    @Override
    public Billing findOne(int id) {
        return billingRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        billingRepository.findOneById(id).ifPresent(billing -> {
            billingRepository.delete(billing);
            log.debug("Deleted Information for Billing: {}", billing);
        });
    }
}
