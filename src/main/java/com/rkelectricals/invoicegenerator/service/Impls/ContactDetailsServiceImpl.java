package com.rkelectricals.invoicegenerator.service.Impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkelectricals.invoicegenerator.model.ContactDetails;
import com.rkelectricals.invoicegenerator.repository.ContactDetailsRepository;
import com.rkelectricals.invoicegenerator.service.ContactDetailsService;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {
	
	@Autowired
	private ContactDetailsRepository contactDetailsRepository;

	@Override
	public ContactDetails saveContactDetails(ContactDetails contactDetails) {
		return contactDetailsRepository.save(contactDetails);
	}

	@Override
	public List<ContactDetails> getBuyerDetails() {
		return contactDetailsRepository.findAll();
	}
	
}
