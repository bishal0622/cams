package com.clinic.web.rest;

import com.clinic.domain.Authority;
import com.clinic.service.genericService.AuthorityService;
import com.clinic.service.dto.AuthorityDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by rajiv on 12/26/2016.
 * Package clinic com.clinic.web.rest
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api")
public class AuthorityController {
    @Inject
    AuthorityService authorityService;

    @RequestMapping(value="/authority",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertAppointment(@RequestBody AuthorityDTO authorityDTO, HttpServletRequest httpServletRequest){
        System.out.println("authority Controller");
        System.out.println(authorityDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Authority authority=authorityService.save(authorityDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authority",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllAuthority()
            throws URISyntaxException {

        List<Authority> val=authorityService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authority/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<AuthorityDTO> updateAppointment(@PathVariable Integer id,@RequestBody AuthorityDTO authorityDTO) {
        Authority authority=authorityService.findOne(id);
        if(authority==null){
            return new ResponseEntity<AuthorityDTO>(HttpStatus.NOT_FOUND);
        }
        authorityDTO.setId(id);
        authorityService.update(authorityDTO);
        return new ResponseEntity<AuthorityDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/authority/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAuthority(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");
        Authority authority=authorityService.findOne(id);
        if(authority==null){
            return new ResponseEntity<Authority>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authority, HttpStatus.CREATED);    }

    @RequestMapping(value = "/authority/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteAuthority(@PathVariable Integer id) {
        System.out.println("delete");
        authorityService.delete(id);
    }


}
