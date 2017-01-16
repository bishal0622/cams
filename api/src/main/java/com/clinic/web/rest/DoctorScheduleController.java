package com.clinic.web.rest;

import com.clinic.domain.DoctorSchedule;
import com.clinic.service.genericService.DoctorScheduleService;
import com.clinic.service.dto.DoctorScheduleDTO;
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
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api")
public class DoctorScheduleController {
    @Inject
    DoctorScheduleService doctorScheduleService;

    @RequestMapping(value="/doctorSchedule",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertDoctorSchedule(@RequestBody DoctorScheduleDTO doctorScheduleDTO, HttpServletRequest httpServletRequest){
        System.out.println("usercontroller");
        System.out.println(doctorScheduleDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        DoctorSchedule doctorSchedule=doctorScheduleService.save(doctorScheduleDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctorSchedule",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllDoctorSchedule()
            throws URISyntaxException {

        List<DoctorSchedule> val=doctorScheduleService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctorSchedule/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<DoctorScheduleDTO> updateDoctorSchedule(@PathVariable Integer id, @RequestBody DoctorScheduleDTO doctorScheduleDTO) {
        System.out.println("update");
        DoctorSchedule doctorSchedule=doctorScheduleService.findOne(id);
        if(doctorSchedule==null){
            return new ResponseEntity<DoctorScheduleDTO>(HttpStatus.NOT_FOUND);
        }
        doctorScheduleDTO.setId(id);
        doctorScheduleService.update(doctorScheduleDTO);
        return new ResponseEntity<DoctorScheduleDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/doctorSchedule/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getDoctorSchedule(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        DoctorSchedule doctorSchedule=doctorScheduleService.findOne(id);
        if(doctorSchedule==null){
            return new ResponseEntity<DoctorSchedule>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(doctorSchedule, HttpStatus.CREATED);    }

    @RequestMapping(value = "/doctorSchedule/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteDoctorSchedule(@PathVariable Integer id) {
        System.out.println("delete");
        doctorScheduleService.delete(id);
    }
}
