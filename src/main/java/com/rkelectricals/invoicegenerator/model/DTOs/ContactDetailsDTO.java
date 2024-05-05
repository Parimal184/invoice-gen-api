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
public class ContactDetailsDTO {
	private String name;
    private String address;
    private String gstin;
    private String email;
    private String mobileNo;
}
