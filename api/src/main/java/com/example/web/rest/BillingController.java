package com.example.web.rest;

import com.example.domain.Billing;
import com.example.domain.Doctor;
import com.example.service.BillingService;
import com.example.service.dto.BillingDTO;
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
public class BillingController {
    @Inject
    BillingService billingService;

    @RequestMapping(value="/billing",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertDoctor(@RequestBody BillingDTO billingDTO, HttpServletRequest httpServletRequest){
        System.out.println("usercontroller");
        System.out.println(billingDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Billing billing=billingService.saveBilling(billingDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/billing",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllUsers()
            throws URISyntaxException {

        List<Billing> val=billingService.getAllBilling();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/billing",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<BillingDTO> updateUser(@RequestBody BillingDTO billingDTO) {
        billingService.updateBilling(billingDTO.getId(),billingDTO.getPatient(),billingDTO.getBillingDate(),billingDTO.getStaff(),billingDTO.getDiscount(),billingDTO.getTax(),billingDTO.getGrandTotal(),billingDTO.getAmount());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/billing/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getUsers(@PathVariable Long id)
            throws URISyntaxException {
        System.out.println("get one user");

        return billingService.getBillingById(id)
                .map(billingDTO -> new ResponseEntity<>(billingDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/billing/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteUser(@PathVariable Long id) {
        System.out.println("delete");
        billingService.deleteBilling(id);
    }
}
