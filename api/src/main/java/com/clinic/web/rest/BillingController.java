package com.clinic.web.rest;

import com.clinic.domain.Billing;
import com.clinic.service.genericService.BillingService;
import com.clinic.service.dto.BillingDTO;
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
public class BillingController {
    @Inject
    BillingService billingService;

    @RequestMapping(value="/billing",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertBill(@RequestBody BillingDTO billingDTO, HttpServletRequest httpServletRequest){
        System.out.println("usercontroller");
        System.out.println(billingDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        Billing billing=billingService.save(billingDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/billing",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllBills()
            throws URISyntaxException {

        List<Billing> val=billingService.getAll();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);    }

    @RequestMapping(value = "/billing/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<BillingDTO> updateBil(@PathVariable Integer id,@RequestBody BillingDTO billingDTO) {
        Billing billing=billingService.findOne(id);
        if(billing==null){
            return new ResponseEntity<BillingDTO>(HttpStatus.NOT_FOUND);
        }
        billingDTO.setId(id);
        billingService.update(billingDTO);
        return new ResponseEntity<BillingDTO>(HttpStatus.OK);
    }

    @RequestMapping(value = "/billing/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getBill(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");
        Billing billing=billingService.findOne(id);
        if(billing==null){
            return new ResponseEntity<Billing>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billing, HttpStatus.CREATED);    }

    @RequestMapping(value = "/billing/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteBill(@PathVariable Integer id) {
        System.out.println("delete");
        billingService.delete(id);
    }
}
