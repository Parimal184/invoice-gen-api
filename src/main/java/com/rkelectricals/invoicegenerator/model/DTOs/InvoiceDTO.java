package com.rkelectricals.invoicegenerator.model.DTOs;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {
	private String invoiceNumber;
    private Date invoiceDate;
    private ContactDetailsDTO sellerDetails;
    private ContactDetailsDTO buyerDetails;
    private List<ProductDTO> products;
    private double totalAmount;
    private double cgst;
    private double sgst;
    private double roundOff;
}
