package com.clinic.service.genericService;

import com.clinic.domain.AuthorityStaff;
import com.clinic.repository.AuthorityStaffRepository;
import com.clinic.service.dto.AuthorityStaffDTO;
import com.clinic.service.generic.AuthorityStaffGeneric;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by HELLZ on 12/26/2016.
 */
@Service
@Transactional
public class AuthorityStaffService implements AuthorityStaffGeneric {

    @Inject
    AuthorityStaffRepository authorityStaffRepository;

    private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AuthorityStaffService.class);

//    public Optional<AuthorityStaff>getauthorityStaffById(Integer id){
//        Optional<AuthorityStaff> authorityStaff=authorityStaffRepository.findOneById(id);
//        return authorityStaff;
//    }

    @Override
    public AuthorityStaff save(AuthorityStaffDTO authorityStaffDTO) {
        AuthorityStaff authorityStaff=new AuthorityStaff();

        authorityStaff.setAuthorityauthorityId(authorityStaffDTO.getAuthorityauthorityId());
        authorityStaff.setStaffstaffId(authorityStaffDTO.getStaffstaffId());
        authorityStaff.setAuthorityByAuthorityauthorityId(authorityStaffDTO.getAuthorityByAuthorityauthorityId());
        authorityStaff.setStaffByStaffstaffId(authorityStaffDTO.getStaffByStaffstaffId());

        authorityStaffRepository.save(authorityStaff);
        return authorityStaff;
    }

    @Override
    public List<AuthorityStaff> getAll() {
        List<AuthorityStaff> authorityStaffs=authorityStaffRepository.findAll();
        return authorityStaffs;
    }

    @Override
    public void update(AuthorityStaffDTO authorityStaffDTO) {
        authorityStaffRepository.findOneById(authorityStaffDTO.getId()).ifPresent(authorityStaff -> {
            authorityStaff.setId(authorityStaffDTO.getId());
            authorityStaff.setAuthorityauthorityId(authorityStaffDTO.getAuthorityauthorityId());
            authorityStaff.setStaffstaffId(authorityStaffDTO.getStaffstaffId());
            authorityStaff.setAuthorityByAuthorityauthorityId(authorityStaffDTO.getAuthorityByAuthorityauthorityId());
            authorityStaff.setStaffByStaffstaffId(authorityStaffDTO.getStaffByStaffstaffId());

            log.debug("Updated:{}", authorityStaff);
            authorityStaffRepository.save(authorityStaff);
        });
    }

    @Override
    public AuthorityStaff findOne(int id) {
        return authorityStaffRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        authorityStaffRepository.findOneById(id).ifPresent(authorityStaff -> {
            authorityStaffRepository.delete(authorityStaff);
            log.debug("Deleted Information:{}", authorityStaff);
        });
    }
}











