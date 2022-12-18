package org.idb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.idb.entity.Contact;
import org.idb.entity.User;
import org.idb.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

	@Autowired
	IContactService service;

	@RequestMapping(value = "/user/contact_form")
	public String contactForm(Model m) {
		Contact c = new Contact();

		m.addAttribute("contact", c);
		return "contact_form";

	}

	@RequestMapping(value = "/user/contact_reg", method = RequestMethod.POST)
	public String contactAdd(@ModelAttribute("contact") Contact c, Model m, HttpSession httpSession) {

		Integer userId = (Integer) httpSession.getAttribute("userId");
		
		c.setUserId(userId);

		service.save(c);

		return "redirect:/user/contact_list?act=add";

	}
		
	
	@RequestMapping(value = "/user/contact_list")
	public String contactList(Model m, HttpSession httpSession) {
		
		Integer userId = (Integer) httpSession.getAttribute("userId");
		List<Contact> contactList=service.findUserContact(userId);		
		
		m.addAttribute("contactList", contactList);

		return "contact_list";

	}
	

}
