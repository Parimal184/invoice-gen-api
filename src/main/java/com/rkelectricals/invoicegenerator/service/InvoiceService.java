package com.rkelectricals.invoicegenerator.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rkelectricals.invoicegenerator.model.Invoice;
import com.rkelectricals.invoicegenerator.model.DTOs.InvoiceDTO;

public interface InvoiceService {
	
	Invoice saveInvoice(InvoiceDTO invoiceDTO);
    Page<Invoice> getAllInvoices(Pageable pageable);
    Invoice getInvoiceById(Long id);
    void deleteInvoice(Long id);
}
