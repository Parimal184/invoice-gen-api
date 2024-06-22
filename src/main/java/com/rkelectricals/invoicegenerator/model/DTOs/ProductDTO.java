package com.rkelectricals.invoicegenerator.model.DTOs;

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
public class ProductDTO {
	private String productName;
	private String hsnSac;
	private int quantity;
	private Double rate;
	private String per;
	private Double amount;
	private Double cgst;
	private Double sgst;
	private Double roundOff;
	private Double totalAmount;
	
	public Double getCsgt() {
    	return MathUtils.format(cgst != null ? cgst : 0.00);
    }
	
	public Double getSgst() {
    	return MathUtils.format(sgst != null ? sgst : 0.00);
    }
    
	public Double getRate() {
    	return MathUtils.format(rate != null ? rate : 0.00);
    }
	
	public Double getAmount() {
    	return MathUtils.format(amount != null ? amount : 0.00);
    }
}
