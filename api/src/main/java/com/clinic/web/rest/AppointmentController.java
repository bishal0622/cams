package com.clinic.web.rest;


import com.clinic.domain.Appointment;
import com.clinic.service.genericService.AppointmentService;

import com.clinic.service.dto.AppointmentDTO;
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
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api")
public class AppointmentController {

    @Inject
    AppointmentService appointmentService;

    @RequestMapping(value="/appointment",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertAppointment(@RequestBody AppointmentDTO appointmentDTO, HttpServletRequest httpServletRequest){
        System.out.println("appointment Controller");
        System.out.println(appointmentDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Appointment appointment=appointmentService.save(appointmentDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/appointment",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllAppointment()
            throws URISyntaxException {

        List<Appointment> val=appointmentService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/appointment/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Integer id, @RequestBody AppointmentDTO appointmentDTO) {
        Appointment currentAppointment=appointmentService.findOne(id);
        if(currentAppointment==null){
            return new ResponseEntity<AppointmentDTO>(HttpStatus.NOT_FOUND);
        }
        appointmentDTO.setId(id);
        appointmentService.update(appointmentDTO);
        return new ResponseEntity<AppointmentDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/appointment/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAppointment(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        Appointment appointment= appointmentService.findOne(id);
        if(appointment==null){
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);    }

    @RequestMapping(value = "/appointment/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteAppointment(@PathVariable Integer id) {
        System.out.println("delete");
        appointmentService.delete(id);
    }


}
