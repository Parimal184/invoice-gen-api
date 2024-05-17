package com.rkelectricals.invoicegenerator.model.DTOs;

import com.rkelectricals.invoicegenerator.model.ContactDetails;

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
public class ContactDetailsDTO {
	private Long id;
	private String name;
    private String address;
    private String gstin;
    private String email;
    private String mobileNo;
    private ContactDetails.Type type;
    
    public ContactDetailsDTO(ContactDetails contactDetails) {
    	this.id = contactDetails.getId();
        this.name = contactDetails.getName().toUpperCase();
        this.address = contactDetails.getAddress().toUpperCase();
        this.gstin = contactDetails.getGstin();
        this.email = contactDetails.getEmail();
        this.mobileNo = contactDetails.getMobileNo();
        this.type = contactDetails.getType();
    }
}
