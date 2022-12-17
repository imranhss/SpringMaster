package org.idb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.idb.dao.IContactDao;
import org.idb.entity.Contact;
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
	
	@Autowired
	IContactDao dao;
	
	@RequestMapping("/user/contact_form")
	public String contactForm(Model m) {
		Contact c=new Contact();
		
		m.addAttribute("contact", c);
		
		return  "contact_form";
	}
	
	
	@RequestMapping(value = "/user/save_contact", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("contact") Contact c ,Model m, HttpSession httpSession) {
		
		try {
			Integer userId=(Integer) httpSession.getAttribute("userId");	
			System.out.println(userId);
			
			c.setUserId(userId);
			service.save(c);	
			
			m.addAttribute("contact", c);		
			return  "redirect:/user/contact_list?act=add";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m.addAttribute("err", "failed to add new Contact");
			return  "contact_form";
		}
	}
	
	
	@RequestMapping("/user/contact_list")
	public String contactList(HttpSession httpSession, Model m) {
		
		Integer userId=(Integer) httpSession.getAttribute("userId");
		
		m.addAttribute("contactList", service.findUserContact(userId));
		
		return "contact_list";
	}
	
	
}
