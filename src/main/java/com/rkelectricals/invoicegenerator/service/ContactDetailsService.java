package com.rkelectricals.invoicegenerator.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rkelectricals.invoicegenerator.model.ContactDetails;

public interface ContactDetailsService {
	
	ContactDetails saveContactDetails(ContactDetails contactDetails);
	
	Page<ContactDetails> getBuyerDetails(Pageable pageable);
	
	ContactDetails updateBuyer(ContactDetails buyerDetails);
	
	void deleteBuyer(Long id);
	
}
