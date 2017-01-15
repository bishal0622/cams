package com.clinic.web.rest;

import com.clinic.domain.Doctor;
import com.clinic.service.genericService.DoctorService;
import com.clinic.service.dto.DoctorDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> insertDoctor(@RequestParam MultipartFile file, @RequestParam String doctor, HttpServletRequest httpServletRequest) throws IOException {
        System.out.println("usercontroller");
        System.out.println(doctor);
        System.out.println(file);
        Doctor doctor1= new Doctor();
        ObjectMapper mapper = new ObjectMapper();
        try {
            DoctorDTO doctorDTO = mapper.readValue(doctor, DoctorDTO.class);
            String picName=doctorService.photoName(file);
            System.out.println(picName);
            doctorDTO.setPhoto(picName);
            System.out.println(doctorDTO.toString());
            doctor1=doctorService.save(doctorDTO);
        } catch (JsonParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (JsonMappingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);







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
