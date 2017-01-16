package com.clinic.web.rest;

import com.clinic.domain.Specialist;
import com.clinic.service.genericService.SpecialistService;
import com.clinic.service.dto.SpecialistDTO;
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
 * Created by japnica on 12/22/2016.
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api")
public class SpecialistController {
    @Inject
    SpecialistService specialistService;

    @RequestMapping(value="/specialist",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertSpecialist(@RequestBody SpecialistDTO specialistDTO, HttpServletRequest httpServletRequest){
        System.out.println("usercontroller");
        System.out.println(specialistDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Specialist specialist=specialistService.save(specialistDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/specialist",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllSpecialist()
            throws URISyntaxException {

        List<Specialist> val=specialistService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/specialist/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<SpecialistDTO> updateSpecialist(@PathVariable Integer id, @RequestBody SpecialistDTO specialistDTO) {
        Specialist specialist=specialistService.findOne(id);
        if(specialist==null){
            return new ResponseEntity<SpecialistDTO>(HttpStatus.NOT_FOUND);
        }
        specialistDTO.setId(id);
        specialistService.update(specialistDTO);
        return new ResponseEntity<SpecialistDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/specialist/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getSpecialist(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");
        Specialist specialist=specialistService.findOne(id);
        if(specialist==null){
            return new ResponseEntity<Specialist>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(specialist, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/specialist/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteSpecialist(@PathVariable Integer id) {
        System.out.println("delete");
        specialistService.delete(id);
    }
}
