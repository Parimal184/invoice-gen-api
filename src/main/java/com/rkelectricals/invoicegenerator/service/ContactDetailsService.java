package com.rkelectricals.invoicegenerator.service;

import java.util.List;

import com.rkelectricals.invoicegenerator.model.ContactDetails;

public interface ContactDetailsService {
	
	ContactDetails saveContactDetails(ContactDetails contactDetails);
	
	List<ContactDetails> getBuyerDetails();
	
}
