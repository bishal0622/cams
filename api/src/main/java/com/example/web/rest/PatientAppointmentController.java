package com.example.web.rest;

import com.example.domain.PatientAppointment;
import com.example.service.PatientAppointmentService;
import com.example.service.dto.PatientAppointmentDTO;
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
 * Created by BiSAl MhRzn on 12/23/2016.
 */
@RestController
@RequestMapping("/api")
public class PatientAppointmentController {
    @Inject
    PatientAppointmentService patientAppointmentService;

    @RequestMapping(value="/patientAppointment",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertPatientAppointment(@RequestBody PatientAppointmentDTO patientAppointmentDTO, HttpServletRequest httpServletRequest){
        System.out.println("patientappointment");
        System.out.println(patientAppointmentDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        PatientAppointment patientAppointment=patientAppointmentService.savePatientAppointment(patientAppointmentDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/patientAppointment",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllPatientAppointment()
            throws URISyntaxException {

        List<PatientAppointment> val=patientAppointmentService.getAllPatientAppointments();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patientAppointment",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<PatientAppointment> updatePatientAppointment(@RequestBody PatientAppointmentDTO patientAppointmentDTO) {
        patientAppointmentService.updatePatientAppointment(patientAppointmentDTO.getId(),patientAppointmentDTO.getAppointment());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patientAppointment/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getPatientAppointment(@PathVariable Long id)
            throws URISyntaxException {
        System.out.println("get one user");

        return patientAppointmentService.getPatientAppointmentById(id)
                .map(patientAppointmentDTO -> new ResponseEntity<>(patientAppointmentDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/patientAppointment/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deletePatientAppointment(@PathVariable Long id) {
        System.out.println("delete");
        patientAppointmentService.deletePatientAppointment(id);
    }
}
