package com.nt.service;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.ContactDTO;
import com.nt.entity.ContactEntity;
import com.nt.repo.ContactDetailsRepo;
@Service
public class ContactMgmtServiceImpl implements IContactMgmtService {

	@Autowired
	private ContactDetailsRepo contactRepo;
	@Override
	public boolean saveContactDetails(ContactDTO dto) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(dto, entity);
		ContactEntity saveEntity = contactRepo.save(entity);
		
		return saveEntity.getContactId()!=null;
	}

	@Override
	public List<ContactDTO> fetchAllContactDetails() {
	
		//use repo
		List<ContactEntity> listentity = contactRepo.findAll();
		List<ContactDTO> listdto=new ArrayList();
		listentity.forEach(entity->{
			ContactDTO dto=new ContactDTO();		
			BeanUtils.copyProperties(entity, dto);

			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public ContactDTO editContactById(Integer contactId) {
	Optional<ContactEntity> findById = contactRepo.findById(contactId);		
	if(findById.isPresent()) {
		ContactEntity contactEntity = findById.get();
		ContactDTO dto=new ContactDTO();
		BeanUtils.copyProperties(contactEntity, dto);
		return dto;
	}
		return null;
	}

	@Override
	public boolean updateContactDetails(ContactDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		return true;
	}

}
