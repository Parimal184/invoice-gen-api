package com.rkelectricals.invoicegenerator.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rkelectricals.invoicegenerator.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	
	Page<Invoice> findAllByOrderByInvoiceDateDesc(Pageable pageable);
}
