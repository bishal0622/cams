package com.clinic.web.rest;

import com.clinic.domain.Particular;
import com.clinic.service.genericService.ParticularService;
import com.clinic.service.dto.ParticularDTO;
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
 * Created by japnica on 12/25/2016.
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api")
public class ParticularController {
    @Inject
    ParticularService particularService;

    @RequestMapping(value="/particular",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertParticular(@RequestBody ParticularDTO particularDTO, HttpServletRequest httpServletRequest){
        System.out.println("usercontroller");
        System.out.println(particularDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Particular particular=particularService.save(particularDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/particular",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllParticular()
            throws URISyntaxException {

        List<Particular> val=particularService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/particular/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ParticularDTO> updateParticular(@PathVariable Integer id, @RequestBody ParticularDTO particularDTO) {
        Particular particular=particularService.findOne(id);
        if(particular==null){
            return new ResponseEntity<ParticularDTO>(HttpStatus.NOT_FOUND);
        }
        particularDTO.setId(id);
        particularService.update(particularDTO);
        return new ResponseEntity<ParticularDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/particular/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getParticular(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        Particular particular=particularService.findOne(id);
        if(particular==null){
            return new ResponseEntity<ParticularDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(particular, HttpStatus.CREATED);    }

    @RequestMapping(value = "/particular/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteParticular(@PathVariable Integer id) {
        System.out.println("delete");
        particularService.delete(id);
    }
}
