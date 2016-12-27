package com.example.service;

import com.example.domain.Billing;
import com.example.domain.Patient;
import com.example.domain.Staff;
import com.example.repository.BillingRepository;
import com.example.service.dto.BillingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/25/2016.
 */

@Service
@Transactional
public class BillingService {
    @Inject
    BillingRepository billingRepository;

    private final Logger log = LoggerFactory.getLogger(BillingService.class);

    public Billing saveBilling(BillingDTO billingDTO){
        Billing billing=new Billing();
        billing.setPatient(billingDTO.getPatient());
        billing.setBillingDate(billingDTO.getBillingDate());
        billing.setStaff(billingDTO.getStaff());
        billing.setDiscount(billingDTO.getDiscount());
        billing.setTax(billingDTO.getTax());
        billing.setGrandTotal(billingDTO.getGrandTotal());
        billing.setAmount(billingDTO.getAmount());
        billingRepository.save(billing);
        log.debug("Created Information for Billing: {}", billing);
        return billing;
    }

    public List<Billing> getAllBilling(){
        List<Billing> billings=billingRepository.findAll();
        return billings;
    }

    public void updateBilling(Long id, Patient patient, Timestamp billingDate, Staff staff, Double discount, Double tax, Double grandTotal, Double amount){
        billingRepository.findOneById(id).ifPresent(billing -> {
            billing.setId(id);
            billing.setPatient(patient);
            billing.setBillingDate(billingDate);
            billing.setStaff(staff);
            billing.setDiscount(discount);
            billing.setTax(tax);
            billing.setGrandTotal(grandTotal);
            billing.setAmount(amount);
            log.debug("Updated Information for Billing: {}", billing);
            billingRepository.save(billing);
        });
    }

    public Optional<Billing> getBillingById(Long id){
        Optional<Billing> billing=billingRepository.findOneById(id);
        return billing;
    }

    public void deleteBilling(Long id){
        billingRepository.findOneById(id).ifPresent(billing -> {
            billingRepository.delete(billing);
            log.debug("Deleted Information for Billing: {}", billing);
        });
    }
}
