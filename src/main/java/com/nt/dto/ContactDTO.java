package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContactDTO implements Serializable {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	
}
