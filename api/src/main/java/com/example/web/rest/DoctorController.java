package com.example.web.rest;

import com.example.domain.Doctor;
import com.example.service.DoctorService;
import com.example.service.dto.DoctorDTO;
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

        Doctor doctor=doctorService.saveDoctor(doctorDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctor",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllUsers()
            throws URISyntaxException {

        List<Doctor> val=doctorService.getAllDoctor();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctor",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<DoctorDTO> updateUser(@RequestBody DoctorDTO doctorDTO) {
        doctorService.updateDoctor(doctorDTO.getId(),doctorDTO.getDoctorName(),doctorDTO.getDoctorAddress(),doctorDTO.getDoctorContact(),doctorDTO.getDoctorEmail(),doctorDTO.getHospitalsAssociated(),doctorDTO.getSpecialistId(),doctorDTO.getSpecialistBySpecialistId(),doctorDTO.getDoctorSchedulesByDoctorId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctor/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getUsers(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        return doctorService.getDoctorById(id)
                .map(doctorDTo -> new ResponseEntity<>(doctorDTo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/doctor/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteUser(@PathVariable Integer id) {
        System.out.println("delete");
        doctorService.deleteDoctor(id);
    }
}
