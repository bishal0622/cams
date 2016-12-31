package com.example.web.rest;

import com.example.domain.Patient;
import com.example.service.PatientService;
import com.example.service.dto.PatientDTO;
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
 * Created by japnica on 12/23/2016.
 */
@RestController
@RequestMapping("/api")
public class PatientController {
    @Inject
    PatientService patientService;

    @RequestMapping(value="/patient",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertPatient(@RequestBody PatientDTO patientDTO, HttpServletRequest httpServletRequest){
        System.out.println("usercontroller");
        System.out.println(patientDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Patient patient=patientService.savePatient(patientDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patient",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllPatient()
            throws URISyntaxException {

        List<Patient> val=patientService.getAllPatient();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patient",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patientDTO) {
        patientService.updatePatient(patientDTO.getId(),patientDTO.getPatientName(),patientDTO.getPatientAddress(),patientDTO.getPatientContact(),patientDTO.getAge(),patientDTO.getGender(),patientDTO.getWeight(),patientDTO.getPatientEmail(),patientDTO.getAppointmentsByPatientId(),patientDTO.getBillingsByPatientId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patient/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getPatient(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        return patientService.getPatientById(id)
                .map(patientDTO -> new ResponseEntity<>(patientDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/patient/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deletePatient(@PathVariable Integer id) {
        System.out.println("delete");
        patientService.deletePatient(id);
    }
}
