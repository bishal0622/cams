package com.clinic.web.rest;

import com.clinic.domain.Appointment;
import com.clinic.repository.AppointmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by japnica on 1/25/2017.
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api")
public class AppointmentListController {
    @Inject
    AppointmentRepository appointmentRepository;

    @RequestMapping(value="/bookedTime/{id}",
            method= RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> time(@PathVariable Integer id, @RequestParam List<String> time){
        System.out.println(time.size());
        System.out.println(time);
        boolean contains=false;
        List<String> unique=new ArrayList<String>();
        List<String> appointments=appointmentRepository.appointmentList(id);
        System.out.println(appointments);
        for(int i=0; i<time.size(); i++) {
            for(int j=0; j<appointments.size(); j++) {
                if(time.get(i).equals(appointments.get(j))) {
                    contains = true;
                    break;
                }
            }
            if(!contains) {
                unique.add(time.get(i));
            }
            else{
                contains = false;
            }
        }
        System.out.println(unique);
        return new ResponseEntity<>(unique, HttpStatus.OK);
    }
}
