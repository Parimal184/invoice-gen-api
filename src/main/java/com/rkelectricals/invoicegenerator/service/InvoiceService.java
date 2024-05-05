package com.rkelectricals.invoicegenerator.service;

import java.util.List;

import com.rkelectricals.invoicegenerator.model.Invoice;

public interface InvoiceService {
	
	Invoice saveInvoice(Invoice invoice);
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(Long id);
    
}
