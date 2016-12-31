package com.example.service;

import com.example.domain.AuthorityStaff;
import com.example.domain.Billing;
import com.example.domain.Staff;
import com.example.repository.StaffRepository;
import com.example.service.dto.StaffDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/25/2016.
 */
@Service
@Transactional
public class StaffService {

    @Inject
    StaffRepository staffRepository;

    private final Logger log = LoggerFactory.getLogger(StaffService.class);

    public Staff saveStaff(StaffDTO staffDTO){

        Staff staff=new Staff();

        staff.setStaffName(staffDTO.getStaffName());
        staff.setPassword(staffDTO.getPassword());
        staff.setStaffContact(staffDTO.getStaffContact());
        staff.setBillingbillId(staffDTO.getBillingbillId());
        staff.setAuthorityStaffsByStaffId(staffDTO.getAuthorityStaffsByStaffId());
        staff.setBillingsByStaffId(staffDTO.getBillingsByStaffId());

        staffRepository.save(staff);

        log.debug("created information for staff: {}", staff);

        return staff;
    }

    public List<Staff> getAllStaff(){
        List<Staff> staff=staffRepository.findAll();
        return staff;
    }

    public void updateStaff(Integer staffId, String staffName, String staffContact, String password, Integer billingbillId, Collection<AuthorityStaff> authorityStaffsByStaffId, Collection<Billing> billingsByStaffId ){
        staffRepository.findOneById(staffId).ifPresent(staff->{

            staff.setStaffName(staffName);
            staff.setPassword(password);
            staff.setStaffContact(staffContact);
            staff.setBillingbillId(billingbillId);
            staff.setAuthorityStaffsByStaffId(authorityStaffsByStaffId);
            staff.setBillingsByStaffId(billingsByStaffId);

            log.debug("Updated staff information:{}", staff);
            staffRepository.save(staff);
        });
    }

    public Optional<Staff> getStaffById(Integer id){
        Optional<Staff> staff=staffRepository.findOneById(id);
        return staff;
    }

    public void deleteStaff(Integer id){
        staffRepository.findOneById(id).ifPresent(staff->{
            staffRepository.delete(staff);
            log.debug("Deleted Information:{}", staff);
        });
    }
}
