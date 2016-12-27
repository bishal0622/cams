package com.example.service;

import com.example.domain.Authority;
import com.example.repository.AuthorityRepository;
import com.example.service.dto.AuthorityDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
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
   // private final Logger log = LoggerFactory.getILoggerFactory(AuthorityService.class);
    public Authority saveAuthority(AuthorityDTO authorityDTO){
        Authority authority=new Authority();

        authority.setId(authorityDTO.getId());
        authority.setAuthorityName(authorityDTO.getAuthorityName());
        authorityRepository.save(authority);

        return authority;
    }
    public List<Authority> getAllAuthority(){

        List<Authority> authority=authorityRepository.findAll();
        return authority;
    }

    public void updateAuthority(Long id,String authorityName){
        authorityRepository.findOneById(id).ifPresent(authority-> {
            authority.setId(id);
            authority.setAuthorityName(authorityName);

          //  log.debug("Updated information:{}", authority);
            authorityRepository.save(authority);
        });
        }
        public Optional<Authority> getAuthorityById(Long id){
            Optional<Authority> authority=authorityRepository.findOneById(id);
            return authority;
    }
    public void deleteAuthority(Long id){
        authorityRepository.findOneById(id).ifPresent(authority->{
            authorityRepository.delete(authority);
           // log.debug("Deleted Information:{}", authority);
        });
    }

}
