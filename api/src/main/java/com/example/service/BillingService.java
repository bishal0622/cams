package com.example.service;

import com.example.domain.*;
import com.example.repository.BillingRepository;
import com.example.service.dto.BillingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.Collection;
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

    public List<Billing> getAllBilling(){
        List<Billing> billings=billingRepository.findAll();
        return billings;
    }

    public void updateBilling(Integer id, Integer patientid, String billingDate, Integer staffid, double discount, double tax, double grandTotal, double amount, Patient patientByPatientId, Staff staff, Collection<ParticularBilling> particularBillings){
        billingRepository.findOneById(id).ifPresent(billing -> {
            billing.setId(id);
            billing.setPatientId(patientid);
            billing.setBillingDate(billingDate);
            billing.setStaffId(staffid);
            billing.setDiscount(discount);
            billing.setTax(tax);
            billing.setGrandTotal(grandTotal);
            billing.setAmount(amount);
            billing.setPatientByPatientId(patientByPatientId);
            billing.setStaffByStaffId(staff);
            billing.setParticularBillingsByBillId(particularBillings);
            log.debug("Updated Information for Billing: {}", billing);
            billingRepository.save(billing);
        });
    }

    public Optional<Billing> getBillingById(Integer id){
        Optional<Billing> billing=billingRepository.findOneById(id);
        return billing;
    }

    public void deleteBilling(Integer id){
        billingRepository.findOneById(id).ifPresent(billing -> {
            billingRepository.delete(billing);
            log.debug("Deleted Information for Billing: {}", billing);
        });
    }
}
