package com.clinic.service.genericService;

import com.clinic.domain.Authority;
import com.clinic.repository.AuthorityRepository;
import com.clinic.service.dto.AuthorityDTO;
import com.clinic.service.generic.AuthorityGeneric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by rajiv on 12/26/2016.
 * Package clinic com.clinic.service.dto
 */
@Service
@Transactional
public class AuthorityService implements AuthorityGeneric {

    @Inject
    AuthorityRepository authorityRepository;

    private final Logger log = LoggerFactory.getLogger(AuthorityService.class);

//        public Optional<Authority> getAuthorityById(Integer id){
//            Optional<Authority> authority=authorityRepository.findOneById(id);
//            return authority;
//    }

    @Override
    public Authority save(AuthorityDTO authorityDTO) {
        Authority authority=new Authority();

        authority.setAuthorityName(authorityDTO.getAuthorityName());
//        authority.setAuthorityStaffsByAuthorityId(authorityDTO.getAuthorityStaffsByAuthorityId());
        authorityRepository.save(authority);

        return authority;
    }

    @Override
    public List<Authority> getAll() {
        List<Authority> authority=authorityRepository.findAll();
        return authority;
    }

    @Override
    public void update(AuthorityDTO authorityDTO) {
        authorityRepository.findOneById(authorityDTO.getId()).ifPresent(authority -> {
            authority.setId(authorityDTO.getId());
            authority.setAuthorityName(authorityDTO.getAuthorityName());
//            authority.setAuthorityStaffsByAuthorityId(authorityDTO.getAuthorityStaffsByAuthorityId());

            log.debug("Updated information:{}", authority);
            authorityRepository.save(authority);
        });
    }

    @Override
    public Authority findOne(int id) {
        return authorityRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        authorityRepository.findOneById(id).ifPresent(authority->{
            authorityRepository.delete(authority);
            log.debug("Deleted Information:{}", authority);
        });
    }
}
