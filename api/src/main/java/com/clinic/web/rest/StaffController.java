package com.clinic.web.rest;

import com.clinic.domain.Staff;
import com.clinic.service.genericService.StaffService;
import com.clinic.service.dto.StaffDTO;
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
 * Created by BiSAl MhRzn on 12/25/2016.
 */

@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api")
public class StaffController {

    @Inject
    StaffService staffService;

    @RequestMapping(value="/staff",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertStaff(@RequestBody StaffDTO staffDTO, HttpServletRequest httpServletRequest){
        System.out.println("staffController");
        System.out.println(staffDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Staff staff=staffService.save(staffDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/staff",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllStaffs()
            throws URISyntaxException {

        List<Staff> val=staffService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/staff/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<StaffDTO> updateStaff(@PathVariable Integer id, @RequestBody StaffDTO staffDTO) {
        Staff staff=staffService.findOne(id);
        if(staff==null){
            return new ResponseEntity<StaffDTO>(HttpStatus.NOT_FOUND);
        }
        staffDTO.setId(id);
        staffService.update(staffDTO);
        return new ResponseEntity<StaffDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/staff/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getStaff(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one staff");
        Staff staff=staffService.findOne(id);
        if(staff==null){
            return new ResponseEntity<Staff>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staff, HttpStatus.CREATED);    }

    @RequestMapping(value = "/staff/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteStaff(@PathVariable Integer id) {
        System.out.println("delete");
        staffService.delete(id);
    }
}
