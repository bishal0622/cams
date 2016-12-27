package com.example.web.rest;

import com.example.domain.Appointment;
import com.example.domain.Authority;
import com.example.service.AppointmentService;
import com.example.service.AuthorityService;
import com.example.service.dto.AppointmentDTO;
import com.example.service.dto.AuthorityDTO;
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
 * Package clinic com.example.web.rest
 */
@RestController
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

        Authority authority=authorityService.saveAuthority(authorityDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authority",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllAuthority()
            throws URISyntaxException {

        List<Authority> val=authorityService.getAllAuthority();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authority",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<AuthorityDTO> updateAppointment(@RequestBody AuthorityDTO authorityDTO) {
        authorityService.updateAuthority(authorityDTO.getId(),authorityDTO.getAuthorityName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authority/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAuthority(@PathVariable Long id)
            throws URISyntaxException {
        System.out.println("get one user");

        return authorityService.getAuthorityById(id)
                .map(authorityDTO -> {
                    return new ResponseEntity<>(authorityDTO, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/authority/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteAuthority(@PathVariable Long id) {
        System.out.println("delete");
        authorityService.deleteAuthority(id);
    }


}
