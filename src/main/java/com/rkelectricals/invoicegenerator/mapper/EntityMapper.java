package com.rkelectricals.invoicegenerator.mapper;

import com.rkelectricals.invoicegenerator.model.Invoice;
import com.rkelectricals.invoicegenerator.model.DTOs.InvoiceDTO;

public class EntityMapper {

	public static Invoice mapToEntity(InvoiceDTO invoiceDTO) {
		return Invoice.builder().cgst(invoiceDTO.getCgst()).sgst(invoiceDTO.getSgst())
				.totalAmount(invoiceDTO.getTotalAmount()).taxDetails(invoiceDTO.getTaxDetails()).build();

	}

}
