package com.nt.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.dto.ContactDTO;
import com.nt.service.IContactMgmtService;

@Controller
public class ContactController {

	@Autowired
	private IContactMgmtService service;
	
	@GetMapping(value= "/phonebook")
	public String loadFormPage(Model model) {
		ContactDTO dto=new ContactDTO();
		model.addAttribute("ContactDTO", dto);
		return "contact_info";
		
	}
	@PostMapping(value="/savecontact")
	public String submitFormPage(@ModelAttribute("ContactDTO") ContactDTO dto,Model model) {
		boolean isSave = service.saveContactDetails(dto);
		if(isSave) {
			model.addAttribute("SucessMsg","All ContactDetails Are Saved SucessFully");
		}
		else {
			model.addAttribute("ErrorMsg","All ContactDetails Are Not Saved SucessFully");
		}
		return "contact_info";
	}
	@GetMapping("/ViewContacts")
	public String handelViewContactLink(Model model) {
		List<ContactDTO>  listdto = service.fetchAllContactDetails();
		model.addAttribute("contactlist",listdto);
		return "view_contact";
	}
	@RequestMapping("/editContact")
	public String handelReqest(@RequestParam("contactId") Integer contactId ,Model model) {
		ContactDTO dto = service.editContactById(contactId);
		model.addAttribute("ContactDTO", dto);
		return "contact_info";
		
	}
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("contactId") Integer contactId) {
		boolean isSave = service.deleteContact(contactId);
		if(isSave)
			
		return "redirect:/ViewContacts";
		return null;
		
		
	}
	
}

