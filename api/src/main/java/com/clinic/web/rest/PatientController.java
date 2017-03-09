package com.clinic.web.rest;

import com.clinic.domain.Patient;
import com.clinic.service.genericService.PatientService;
import com.clinic.service.dto.PatientDTO;
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
@CrossOrigin(origins = "http://localhost:9000")
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

        Patient patient=patientService.save(patientDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patient",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllPatient()
            throws URISyntaxException {

        List<Patient> val=patientService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patient/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Integer id, @RequestBody PatientDTO patientDTO) {
        Patient patient=patientService.findOne(id);
        if(patient==null){
            return new ResponseEntity<PatientDTO>(HttpStatus.NOT_FOUND);
        }
        patientDTO.setId(id);
        patientService.update(patientDTO);
        return new ResponseEntity<PatientDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getPatient(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");
        Patient patient=patientService.findOne(id);
        if(patient==null){
            return new ResponseEntity<PatientDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patient, HttpStatus.CREATED);    }

    @RequestMapping(value = "/patient/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deletePatient(@PathVariable Integer id) {
        System.out.println("delete");
        patientService.delete(id);
    }

    @RequestMapping(value ="/patient/lastEntry",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLastEntry(){
        Patient last=new Patient();
        last=patientService.lastEntryPatient();
        if(last==null){
            return new ResponseEntity<PatientDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(last, HttpStatus.CREATED);
    }
}
