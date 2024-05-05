package com.rkelectricals.invoicegenerator.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Invoice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String invoiceNumber;
	@Column
    private Date invoiceDate;
    
    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails sellerDetails;
    
    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails buyerDetails;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;
    
    @Column
    private double totalAmount;
    
    @Column
    private double cgst;
    
    @Column
    private double sgst;
    
    @Column
    private double roundOff;
    
}
