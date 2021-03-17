package com.nt.service;

import java.util.List;

import com.nt.dto.ContactDTO;



public interface IContactMgmtService {
	public boolean saveContactDetails(ContactDTO dto);
	public List<ContactDTO> fetchAllContactDetails();
	public ContactDTO editContactById(Integer contactId);
	public boolean updateContactDetails(ContactDTO dto);
	public boolean deleteContact(Integer contactId);
	

}
