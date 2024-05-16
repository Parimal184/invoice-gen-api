package com.rkelectricals.invoicegenerator.service;

import java.util.List;

import com.rkelectricals.invoicegenerator.model.Invoice;
import com.rkelectricals.invoicegenerator.model.DTOs.InvoiceDTO;

public interface InvoiceService {
	
	Invoice saveInvoice(InvoiceDTO invoiceDTO);
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(Long id);
    
}
