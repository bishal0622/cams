package com.example.web.rest;

import com.example.domain.Specialist;
import com.example.service.SpecialistService;
import com.example.service.dto.DoctorDTO;
import com.example.service.dto.SpecialistDTO;
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

//        HttpHeaders textPlainheaders = new HttpHeaders();
//        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Specialist specialist=specialistService.saveSpecialist(specialistDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/specialist",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllSpecialist()
            throws URISyntaxException {

        List<Specialist> val=specialistService.getAllSpecialist();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/specialist",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<DoctorDTO> updateSpecialist(@RequestBody SpecialistDTO specialistDTO) {
        specialistService.updateSpecialist(specialistDTO.getId(),specialistDTO.getSpecialistName(),specialistDTO.getDoctorsBySpecialistId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/specialist/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getSpecialist(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        return specialistService.getSpecialistById(id)
                .map(specialistDTO -> new ResponseEntity<>(specialistDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/specialist/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteSpecialist(@PathVariable Integer id) {
        System.out.println("delete");
        specialistService.deleteSpecialist(id);
    }
}
