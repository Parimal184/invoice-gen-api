package com.rkelectricals.invoicegenerator.model;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    
    @ManyToOne(cascade = CascadeType.ALL)
    private ContactDetails sellerDetails;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private ContactDetails buyerDetails;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;
    
    @Column(columnDefinition = "json")
    private String invoiceItems;
    
    @Column
    private double totalAmount;
    
    @Column
    private double cgst;
    
    @Column
    private double sgst;
    
    @Column
    private double roundOff;
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = roundToTwoDecimalPlaces(totalAmount);
    }

    public void setCgst(double cgst) {
        this.cgst = roundToTwoDecimalPlaces(cgst);
    }

    public void setSgst(double sgst) {
        this.sgst = roundToTwoDecimalPlaces(sgst);
    }

    public void setRoundOff(double roundOff) {
        this.roundOff = roundToTwoDecimalPlaces(roundOff);
    }

    private double roundToTwoDecimalPlaces(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }
    
}
