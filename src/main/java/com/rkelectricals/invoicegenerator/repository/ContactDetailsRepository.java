package com.rkelectricals.invoicegenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rkelectricals.invoicegenerator.model.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long> {
	
}
