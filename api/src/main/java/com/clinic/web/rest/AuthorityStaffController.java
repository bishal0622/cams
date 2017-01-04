package com.clinic.web.rest;

import com.clinic.domain.AuthorityStaff;
import com.clinic.service.genericService.AuthorityStaffService;
import com.clinic.service.dto.AuthorityStaffDTO;
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
 * Created by HELLZ on 12/26/2016.
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api")
public class AuthorityStaffController {
    @Inject
    AuthorityStaffService authorityStaffService;

    @RequestMapping(value = "/authorityStaff",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertAuthorityStaff(@RequestBody AuthorityStaffDTO authorityStaffDTO, HttpServletRequest httpServletRequest){
        System.out.println("AuthorityStaffGeneric");
        System.out.println(authorityStaffDTO.toString());

        HttpHeaders textPlainheaders=new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        AuthorityStaff authorityStaff=authorityStaffService.save(authorityStaffDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authorityStaff",
         method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<?> getAllAuthorityStaff()
        throws URISyntaxException{
        List<AuthorityStaff> val=authorityStaffService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/authorityStaff/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<AuthorityStaff> updateAuthorityStaff(@PathVariable Integer id, @RequestBody AuthorityStaffDTO authorityStaffDTO) {
        AuthorityStaff authorityStaff=authorityStaffService.findOne(id);
        if(authorityStaff==null){
            return new ResponseEntity<AuthorityStaff>(HttpStatus.NOT_FOUND);
        }
        authorityStaffDTO.setId(id);
        authorityStaffService.update(authorityStaffDTO);
        return new ResponseEntity<AuthorityStaff>(HttpStatus.OK);
    }

    @RequestMapping(value = "/authorityStaff/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAuthorityStaff(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one staff");
        AuthorityStaff authorityStaff=authorityStaffService.findOne(id);
        if(authorityStaff==null){
            return new ResponseEntity<AuthorityStaff>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorityStaff, HttpStatus.CREATED);    }

    @RequestMapping(value = "/authorityStaff/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteAuthorityStaff(@PathVariable Integer id) {
        System.out.println("delete");
        authorityStaffService.delete(id);
    }

}
