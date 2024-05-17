package com.rkelectricals.invoicegenerator.model.DTOs;

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
	    private Long sellerDetailsId;
	    private Long buyerDetailsId;
	    private List<Long> productIds;
	    private double totalAmount;
	    private double cgst;
	    private double sgst;
	    private double roundOff;
	    private String taxDetails;
}
