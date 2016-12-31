package com.example.service;

import com.example.domain.Authority;
import com.example.domain.AuthorityStaff;
import com.example.repository.AuthorityRepository;
import com.example.service.dto.AuthorityDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by rajiv on 12/26/2016.
 * Package clinic com.example.service.dto
 */
@Service
@Transactional
public class AuthorityService {

    @Inject
    AuthorityRepository authorityRepository;

    private final Logger log = LoggerFactory.getLogger(AuthorityService.class);


    public Authority saveAuthority(AuthorityDTO authorityDTO){
        Authority authority=new Authority();

        authority.setAuthorityName(authorityDTO.getAuthorityName());
        authority.setAuthorityStaffsByAuthorityId(authorityDTO.getAuthorityStaffsByAuthorityId());
        authorityRepository.save(authority);

        return authority;
    }
    public List<Authority> getAllAuthority(){

        List<Authority> authority=authorityRepository.findAll();
        return authority;
    }

    public void updateAuthority(Integer id, String authorityName, Collection<AuthorityStaff> authorityStaffs){
        authorityRepository.findOneById(id).ifPresent(authority-> {
            authority.setId(id);
            authority.setAuthorityName(authorityName);
            authority.setAuthorityStaffsByAuthorityId(authorityStaffs);

            log.debug("Updated information:{}", authority);
            authorityRepository.save(authority);
        });
        }

        public Optional<Authority> getAuthorityById(Integer id){
            Optional<Authority> authority=authorityRepository.findOneById(id);
            return authority;
    }
    public void deleteAuthority(Integer id){
        authorityRepository.findOneById(id).ifPresent(authority->{
            authorityRepository.delete(authority);
            log.debug("Deleted Information:{}", authority);
        });
    }

}
