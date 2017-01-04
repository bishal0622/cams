package com.clinic.web.rest;

import com.clinic.domain.Doctor;
import com.clinic.service.genericService.DoctorService;
import com.clinic.service.dto.DoctorDTO;
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
public class DoctorController {

    @Inject
    DoctorService doctorService;

    @RequestMapping(value="/doctor",
    method = RequestMethod.POST,
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertDoctor(@RequestBody DoctorDTO doctorDTO, HttpServletRequest httpServletRequest){
        System.out.println("usercontroller");
        System.out.println(doctorDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Doctor doctor=doctorService.save(doctorDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctor",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllUsers()
            throws URISyntaxException {

        List<Doctor> val=doctorService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctor/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<DoctorDTO> updateUser(@PathVariable Integer id, @RequestBody DoctorDTO doctorDTO) {
        Doctor doctor=doctorService.findOne(id);
        if(doctor==null){
            return new ResponseEntity<DoctorDTO>(HttpStatus.NOT_FOUND);
        }
        doctorDTO.setId(id);
        doctorService.update(doctorDTO);
        return new ResponseEntity<DoctorDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/doctor/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getUsers(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");
        Doctor doctor= doctorService.findOne(id);
        if(doctor==null){
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctor/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteUser(@PathVariable Integer id) {
        System.out.println("delete");
        doctorService.delete(id);
    }
}
