package com.example.web.rest;

import com.example.domain.ParticularBilling;
import com.example.service.ParticularBillingService;
import com.example.service.dto.ParticularBillingDTO;
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

        ParticularBilling particularBilling=particularBillingService.saveParticularBilling(particularBillingDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/particularBilling",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllParticularBilling()
            throws URISyntaxException {

        List<ParticularBilling> val=particularBillingService.getAllParticularBilling();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/particularBilling",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ParticularBillingDTO> updateParticularBilling(@RequestBody ParticularBillingDTO particularBillingDTO) {
        particularBillingService.updateParticularBilling(particularBillingDTO.getId(),particularBillingDTO.getParticularparticularId(),particularBillingDTO.getBillingbillId(),particularBillingDTO.getParticularByParticularparticularId(),particularBillingDTO.getBillingByBillingbillId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/particularBilling/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getParticularBilling(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        return particularBillingService.getParticularBillingById(id)
                .map(particularBillingDTO -> new ResponseEntity<>(particularBillingDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/particularBilling/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteParticularBilling(@PathVariable Integer id) {
        System.out.println("delete");
        particularBillingService.deleteParticularBilling(id);
    }
}
