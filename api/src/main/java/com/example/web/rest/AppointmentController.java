package com.example.web.rest;


import com.example.domain.Appointment;
import com.example.service.AppointmentService;

import com.example.service.dto.AppointmentDTO;
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

        Appointment appointment=appointmentService.saveAppointment(appointmentDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/appointment",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllAppointment()
            throws URISyntaxException {

        List<Appointment> val=appointmentService.getAllAppointments();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/appointment",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.updateAppointment(appointmentDTO.getId(),appointmentDTO.getAppointmentDate(),appointmentDTO.getDoctorScheduleId(),appointmentDTO.getComment(),appointmentDTO.getStatus(),appointmentDTO.getPatientpatientId(),appointmentDTO.getDoctorScheduleByDoctorScheduleId(),appointmentDTO.getPatientByPatientpatientId(),appointmentDTO.getNotificationLogsByAppointmentId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/appointment/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAppointment(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        return appointmentService.getAppointmentById(id)
                .map(appointmentDTO -> new ResponseEntity<>(appointmentDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/appointment/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteAppointment(@PathVariable Integer id) {
        System.out.println("delete");
        appointmentService.deleteAppointment(id);
    }


}
