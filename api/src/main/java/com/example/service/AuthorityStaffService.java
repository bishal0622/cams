package com.example.service;

import com.example.domain.Authority;
import com.example.domain.AuthorityStaff;
import com.example.domain.Staff;
import com.example.repository.AuthorityStaffRepository;
import com.example.service.dto.AuthorityStaffDTO;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by HELLZ on 12/26/2016.
 */
@Service
@Transactional
public class AuthorityStaffService {
    @Inject
    AuthorityStaffRepository authorityStaffRepository;

    private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AuthorityStaffService.class);

    public AuthorityStaff saveAuthorityStaff(AuthorityStaffDTO authorityStaffDTO ){
        AuthorityStaff authorityStaff=new AuthorityStaff();

        authorityStaff.setAuthority(authorityStaffDTO.getAuthority());
        authorityStaff.setStaff(authorityStaffDTO.getStaff());

        authorityStaffRepository.save(authorityStaff);
        return authorityStaff;
    }

    public List<AuthorityStaff> getAllAuthorityStaffs(){
        List<AuthorityStaff> authorityStaffs=authorityStaffRepository.findAll();
        return authorityStaffs;
    }

    public void updateAuthorityStaff(Long id, Authority authority, Staff staff) {
        authorityStaffRepository.findOneById(id).ifPresent(authorityStaff -> {
            authorityStaff.setId(id);
            authorityStaff.setAuthority(authority);
            authorityStaff.setStaff(staff);

            log.debug("Updated:{}", authorityStaff);
            authorityStaffRepository.save(authorityStaff);
        });
    }

    public Optional<AuthorityStaff>getauthorityStaffById(Long id){
        Optional<AuthorityStaff> authorityStaff=authorityStaffRepository.findOneById(id);
        return authorityStaff;
    }

    public void deleteAuthorityStaff(Long id) {
        authorityStaffRepository.findOneById(id).ifPresent(authorityStaff -> {
            authorityStaffRepository.delete(authorityStaff);
            log.debug("Deleted Information:{}", authorityStaff);
        });
    }
}











