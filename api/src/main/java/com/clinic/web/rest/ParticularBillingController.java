package com.clinic.web.rest;

import com.clinic.domain.ParticularBilling;
import com.clinic.service.genericService.ParticularBillingService;
import com.clinic.service.dto.ParticularBillingDTO;
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
@RequestMapping
public class ParticularBillingController {
    @Inject
    ParticularBillingService particularBillingService;

    @RequestMapping(value="/particularBilling",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertParticularBilling(@RequestBody ParticularBillingDTO particularBillingDTO, HttpServletRequest httpServletRequest){
        System.out.println("usercontroller");
        System.out.println(particularBillingDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        ParticularBilling particularBilling=particularBillingService.save(particularBillingDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/particularBilling",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllParticularBilling()
            throws URISyntaxException {

        List<ParticularBilling> val=particularBillingService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/particularBilling/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ParticularBillingDTO> updateParticularBilling(@PathVariable Integer id, @RequestBody ParticularBillingDTO particularBillingDTO) {
        ParticularBilling particularBilling=particularBillingService.findOne(id);
        if(particularBilling==null){
            return new ResponseEntity<ParticularBillingDTO>(HttpStatus.NOT_FOUND);
        }
        particularBillingDTO.setId(id);
        particularBillingService.update(particularBillingDTO);
        return new ResponseEntity<ParticularBillingDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/particularBilling/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getParticularBilling(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        ParticularBilling particularBilling=particularBillingService.findOne(id);
        if(particularBilling==null){
            return new ResponseEntity<ParticularBilling>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(particularBilling, HttpStatus.CREATED);    }

    @RequestMapping(value = "/particularBilling/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteParticularBilling(@PathVariable Integer id) {
        System.out.println("delete");
        particularBillingService.delete(id);
    }
}
