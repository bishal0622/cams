package com.example.web.rest;

import com.example.domain.Staff;
import com.example.service.StaffService;
import com.example.service.dto.StaffDTO;
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

        Staff staff=staffService.saveStaff(staffDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/staff",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllStaffs()
            throws URISyntaxException {

        List<Staff> val=staffService.getAllStaff();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/staff",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<StaffDTO> updateStaff(@RequestBody StaffDTO staffDTO) {
        staffService.updateStaff(staffDTO.getId(),staffDTO.getStaffName(),staffDTO.getPassword(),staffDTO.getStaffContact());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/staff/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getStaff(@PathVariable Long id)
            throws URISyntaxException {
        System.out.println("get one staff");

        return staffService.getStaffById(id)
                .map(staffDTO -> new ResponseEntity<>(staffDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/staff/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteStaff(@PathVariable Long id) {
        System.out.println("delete");
        staffService.deleteStaff(id);
    }
}
