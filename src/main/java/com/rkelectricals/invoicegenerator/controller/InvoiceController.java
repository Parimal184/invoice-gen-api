package com.rkelectricals.invoicegenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkelectricals.invoicegenerator.model.Invoice;
import com.rkelectricals.invoicegenerator.model.DTOs.InvoiceDTO;
import com.rkelectricals.invoicegenerator.service.InvoiceService;

@RestController
@RequestMapping("/api/Invoice")
@CrossOrigin("*")
public class InvoiceController {
	
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/SaveInvoice")
    public Invoice saveInvoice(@RequestBody InvoiceDTO invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/GetInvoices")
    public ResponseEntity<?> getAllInvoices() {
    	List<Invoice> invoices = invoiceService.getAllInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/GetInvoice/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    // Other endpoints as needed
}