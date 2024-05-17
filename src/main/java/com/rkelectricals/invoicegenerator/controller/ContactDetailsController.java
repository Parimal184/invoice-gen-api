package com.rkelectricals.invoicegenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<?> getBuyerDetails(@RequestParam(required = false, defaultValue = "0") Integer page,
	        @RequestParam(required = false, defaultValue = "10") Integer size) {
		
		Page<ContactDetails> buyers = contactDetailsService.getBuyerDetails(PageRequest.of(page, size));
		return new ResponseEntity<>(buyers, HttpStatus.OK);
	}

	@PutMapping("/UpdateBuyer")
	public ContactDetails updateBuyer(@RequestBody ContactDetails buyerDetails) {
		return contactDetailsService.updateBuyer(buyerDetails);
	}

	@DeleteMapping("/DeleteBuyer/{id}")
	public ResponseEntity<?> deleteBuyer(@PathVariable Long id) {
		contactDetailsService.deleteBuyer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}