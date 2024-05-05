package com.rkelectricals.invoicegenerator.model.DTOs;

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
	private double rate;
	private String per;
	private double amount;
	private double cgst;
	private double sgst;
	private double roundOff;
	private double totalAmount;
}
