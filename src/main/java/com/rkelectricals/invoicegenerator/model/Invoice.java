package com.rkelectricals.invoicegenerator.model;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.rkelectricals.invoicegenerator.utils.MathUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Invoice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String invoiceNumber;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
    private Date invoiceDate;
    
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ContactDetails sellerDetails;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ContactDetails buyerDetails;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Product> products;
    
    @Column(columnDefinition = "json")
    private String taxDetails;
    
    @Column
    private Double totalAmount;
    
    @Column
    private Double cgst;
    
    @Column
    private Double sgst;
    
    @Column
    private Double roundOff;
    

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
