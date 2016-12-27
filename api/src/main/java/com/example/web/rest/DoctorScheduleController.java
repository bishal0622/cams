package com.example.web.rest;

import com.example.domain.DoctorSchedule;
import com.example.service.DoctorScheduleService;
import com.example.service.dto.DoctorScheduleDTO;
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
@RequestMapping("/api")
public class DoctorScheduleController {
    @Inject
    DoctorScheduleService doctorScheduleService;

    @RequestMapping(value="/doctorSchedule",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertDoctor(@RequestBody DoctorScheduleDTO doctorScheduleDTO, HttpServletRequest httpServletRequest){
        System.out.println("usercontroller");
        System.out.println(doctorScheduleDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        DoctorSchedule doctorSchedule=doctorScheduleService.saveSchedule(doctorScheduleDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctorSchedule",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllUsers()
            throws URISyntaxException {

        List<DoctorSchedule> val=doctorScheduleService.getAllSchedule();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctorSchedule",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<DoctorScheduleDTO> updateUser(@RequestBody DoctorScheduleDTO doctorScheduleDTO) {
        doctorScheduleService.updateSchedule(doctorScheduleDTO.getId(),doctorScheduleDTO.getDoctor(),doctorScheduleDTO.getDoctorScheduleTo(),doctorScheduleDTO.getDoctorScheduleFrom(),doctorScheduleDTO.getDayOfWeek());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctorSchedule/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getUsers(@PathVariable Long id)
            throws URISyntaxException {
        System.out.println("get one user");

        return doctorScheduleService.getScheduleById(id)
                .map(doctorScheduleDTO -> new ResponseEntity<>(doctorScheduleDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/doctorSchedule/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteUser(@PathVariable Long id) {
        System.out.println("delete");
        doctorScheduleService.deleteSchedule(id);
    }
}