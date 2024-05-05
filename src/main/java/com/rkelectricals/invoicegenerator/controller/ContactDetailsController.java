package com.rkelectricals.invoicegenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkelectricals.invoicegenerator.model.ContactDetails;
import com.rkelectricals.invoicegenerator.service.ContactDetailsService;

@RestController
@RequestMapping("/api/ContactDetails")
@CrossOrigin("*")
public class ContactDetailsController {
    @Autowired
    private ContactDetailsService contactDetailsService;

    @PostMapping("/SaveBuyer")
    public ContactDetails saveBuyerDetails(@RequestBody ContactDetails buyerDetails) {
        return contactDetailsService.saveContactDetails(buyerDetails);
    }
    
    @GetMapping("/GetBuyers")
    public ResponseEntity<?> getBuyerDetails() {
    	List<ContactDetails> buyers = contactDetailsService.getBuyerDetails();
        return new ResponseEntity<>(buyers, HttpStatus.OK);
    }
}