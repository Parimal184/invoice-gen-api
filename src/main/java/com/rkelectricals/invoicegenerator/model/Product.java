package com.rkelectricals.invoicegenerator.model;

import com.rkelectricals.invoicegenerator.utils.MathUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Transactional
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String name;
	@Column
    private String hsnSac;
	@Column
    private Double stateTaxRate;
	@Column
    private Double centralTaxRate;
	@Column
    private int quantity;
	@Column
    private Double rate;
	@Column
    private String unit;
	@Column
    private Double amount;
	
	public Double getStateTaxRate() {
    	return MathUtils.format(stateTaxRate != null ? stateTaxRate : 0.00);
    }
	
	public Double getCentralTaxRate() {
    	return MathUtils.format(centralTaxRate != null ? centralTaxRate : 0.00);
    }
    
	public Double getRate() {
    	return MathUtils.format(rate != null ? rate : 0.00);
    }
	
	public Double getAmount() {
    	return MathUtils.format(amount != null ? amount : 0.00);
    }
}
