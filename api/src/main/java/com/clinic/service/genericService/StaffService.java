package com.clinic.service.genericService;

import com.clinic.domain.Staff;
import com.clinic.repository.StaffRepository;
import com.clinic.service.dto.StaffDTO;
import com.clinic.service.generic.StaffGeneric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by BiSAl MhRzn on 12/25/2016.
 */
@Service
@Transactional
public class StaffService implements StaffGeneric{

    @Inject
    StaffRepository staffRepository;

    private final Logger log = LoggerFactory.getLogger(StaffService.class);

//    public Optional<Staff> getStaffById(Integer id){
//        Optional<Staff> staff=staffRepository.findOneById(id);
//        return staff;
//    }

    @Override
    public Staff save(StaffDTO staffDTO) {
        Staff staff=new Staff();

        staff.setStaffName(staffDTO.getStaffName());
        staff.setPassword(staffDTO.getPassword());
        staff.setStaffContact(staffDTO.getStaffContact());
//        staff.setBillingbillId(staffDTO.getBillingbillId());
        staff.setAuthorityStaffsByStaffId(staffDTO.getAuthorityStaffsByStaffId());
        staff.setBillingsByStaffId(staffDTO.getBillingsByStaffId());

        staffRepository.save(staff);

        log.debug("created information for staff: {}", staff);

        return staff;
    }

    @Override
    public List<Staff> getAll() {
        List<Staff> staff=staffRepository.findAll();
        return staff;
    }

    @Override
    public void update(StaffDTO staffDTO) {
        staffRepository.findOneById(staffDTO.getId()).ifPresent(staff -> {
            staff.setStaffName(staffDTO.getStaffName());
            staff.setPassword(staffDTO.getPassword());
            staff.setStaffContact(staffDTO.getStaffContact());
//        staff.setBillingbillId(staffDTO.getBillingbillId());
            staff.setAuthorityStaffsByStaffId(staffDTO.getAuthorityStaffsByStaffId());
            staff.setBillingsByStaffId(staffDTO.getBillingsByStaffId());

            log.debug("Updated staff information:{}", staff);
            staffRepository.save(staff);
        });
    }

    @Override
    public Staff findOne(int id) {
        return staffRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        staffRepository.findOneById(id).ifPresent(staff->{
            staffRepository.delete(staff);
            log.debug("Deleted Information:{}", staff);
        });
    }
}
