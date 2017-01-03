package com.example.web.rest;

import com.example.domain.Authority;
import com.example.domain.AuthorityStaff;
import com.example.service.AuthorityStaffService;
import com.example.service.dto.AuthorityStaffDTO;
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
        System.out.println("AuthorityStaff");
        System.out.println(authorityStaffDTO.toString());

        HttpHeaders textPlainheaders=new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        AuthorityStaff authorityStaff=authorityStaffService.saveAuthorityStaff(authorityStaffDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authorityStaff",
         method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<?> getAllAuthorityStaff()
        throws URISyntaxException{
        List<AuthorityStaff> val=authorityStaffService.getAllAuthorityStaffs();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/authorityStaff",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<AuthorityStaff> updateAuthorityStaff(@RequestBody AuthorityStaffDTO authorityStaffDTO) {
        authorityStaffService.updateAuthorityStaff(authorityStaffDTO.getId(),authorityStaffDTO.getAuthorityauthorityId(),authorityStaffDTO.getStaffstaffId(),authorityStaffDTO.getAuthorityByAuthorityauthorityId(),authorityStaffDTO.getStaffByStaffstaffId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authorityStaff/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAuthorityStaff(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one staff");

        return authorityStaffService.getauthorityStaffById(id)
                .map(authorityStaffDTO -> new ResponseEntity<>(authorityStaffDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/authorityStaff/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteAuthorityStaff(@PathVariable Integer id) {
        System.out.println("delete");
        authorityStaffService.deleteAuthorityStaff(id);
    }

}
