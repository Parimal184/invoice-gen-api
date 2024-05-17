package com.rkelectricals.invoicegenerator.model;

import com.rkelectricals.invoicegenerator.model.DTOs.ContactDetailsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ContactDetails {
	
	public enum Type {
		BUYER, SELLER
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String name;
	@Column
    private String address;
	@Column
    private String gstin;
	@Column
    private String email;
	@Column
    private String mobileNo;
	@Column
    private Type type = Type.BUYER;
	
}
