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

import com.rkelectricals.invoicegenerator.model.Invoice;
import com.rkelectricals.invoicegenerator.model.DTOs.InvoiceDTO;
import com.rkelectricals.invoicegenerator.service.InvoiceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/Invoice")
@CrossOrigin("*")
@Slf4j
public class InvoiceController {
	
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/SaveInvoice")
    public Invoice saveInvoice(@RequestBody InvoiceDTO invoice) {
        return invoiceService.saveInvoice(invoice);
    }
    
    @PutMapping("/UpdateInvoice")
    public Invoice updateInvoice(@RequestBody InvoiceDTO invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/GetInvoices")
    public ResponseEntity<?> getAllInvoices(@RequestParam(required = false, defaultValue = "0") Integer page,
	        @RequestParam(required = false, defaultValue = "10") Integer size) {
    	log.warn("Start getAllInvoices :");
    	Page<Invoice> invoices = invoiceService.getAllInvoices(PageRequest.of(page, size));
    	log.warn("End getAllInvoices :");
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/GetInvoice/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }
    
    @DeleteMapping("/DeleteInvoice/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable Long id) {
    	invoiceService.deleteInvoice(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}