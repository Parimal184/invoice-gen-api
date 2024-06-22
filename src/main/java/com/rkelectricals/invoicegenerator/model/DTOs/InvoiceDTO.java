package com.rkelectricals.invoicegenerator.model.DTOs;

import java.util.List;

import com.rkelectricals.invoicegenerator.utils.MathUtils;

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
	    private Double totalAmount;
	    private Double cgst;
	    private Double sgst;
	    private Double roundOff;
	    private String taxDetails;
	    
	    public Double getTotalAmount() {
	    	return MathUtils.format(totalAmount);
	    }
	    
	    public Double getCgst() {
	    	return MathUtils.format(cgst);
	    }
	    
	    public Double getSgst() {
	    	return MathUtils.format(sgst);
	    }
	    
	    public Double getRoundOff() {
	    	return MathUtils.format(roundOff);
	    }
}
