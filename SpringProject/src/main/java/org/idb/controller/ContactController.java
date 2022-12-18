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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

	@Autowired
	IContactService service;

	@Autowired
	IContactDao dao;

	@RequestMapping("/user/contact_form")
	public String contactForm(Model m) {
		Contact c = new Contact();

		m.addAttribute("contact", c);

		return "contact_form";
	}

//	@RequestMapping(value = "/user/save_contact", method = RequestMethod.POST)
//	public String saveContact(@ModelAttribute("contact") Contact c ,Model m, HttpSession httpSession) {
//		
//		try {
//			Integer userId=(Integer) httpSession.getAttribute("userId");	
//			System.out.println(userId);
//			
//			c.setUserId(userId);
//			service.save(c);	
//			
//			m.addAttribute("contact", c);		
//			return  "redirect:/user/contact_list?act=add";
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			m.addAttribute("err", "failed to add new Contact");
//			return  "contact_form";
//		}
//	}

	@RequestMapping(value = "/user/save_contact", method = RequestMethod.POST)
	public String saveOrUpdateContact(@ModelAttribute("contact") Contact c, Model m, HttpSession httpSession) {
		
		Integer contactId = (Integer) httpSession.getAttribute("aContactId");

		System.out.println(contactId);
		if (contactId == null) {

			try {
				Integer userId = (Integer) httpSession.getAttribute("userId");
				c.setUserId(userId);
				service.save(c);

				m.addAttribute("contact", c);
				return "redirect:/user/contact_list?act=add";

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				m.addAttribute("err", "failed to add new Contact");
				return "contact_form";
			}
		}

		else {
			try {
				c.setContactId(contactId);
				service.update(c);
				m.addAttribute("contact", c);
				
				return "redirect:/user/contact_list?act=ed";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				m.addAttribute("err", "failed to Edit Contact");
				return "contact_form";
			}

		}

	}

	@RequestMapping("/user/contact_list")
	public String contactList(HttpSession httpSession, Model m) {

		Integer userId = (Integer) httpSession.getAttribute("userId");
		List<Contact> contactList = service.findUserContact(userId);

		m.addAttribute("contactList", contactList);

		return "contact_list";
	}

	@RequestMapping("/user/contact_delete/")
	public String contactDelete(@RequestParam("contactId") int cintactId) {

		service.delete(cintactId);

		return "redirect:/user/contact_list?act=del";
	}

	@RequestMapping("/user/edit_contact")
	public String eidtContactForm(Model m, HttpSession httpSession, @RequestParam("contactId") int contactId) {
		httpSession.setAttribute("aContactId", contactId);
		Contact c = service.findById(contactId);

		m.addAttribute("contact", c);

		return "contact_form";
	}
	
	@RequestMapping("/user/contact_search")
	public String contactSearch(HttpSession httpSession, Model m, @RequestParam("freeText") String freeText) {

		Integer userId = (Integer) httpSession.getAttribute("userId");
		
		List<Contact> contactList = service.findUserContact(userId, freeText);

		m.addAttribute("contactList", contactList);

		return "contact_list";
	}
	
	
	@RequestMapping("/user/bulk_delete")
	public String bulkContactDelete(@RequestParam("contactId") Integer[] contactIds) {

		service.delete(contactIds);

		return "redirect:/user/contact_list?act=del";
	}
	

}
