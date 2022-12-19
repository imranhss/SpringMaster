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
import org.springframework.web.bind.annotation.RequestParam;

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
	public String contactAddOrUpdate(@ModelAttribute("contact") Contact c, Model m, HttpSession httpSession) {
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

	@RequestMapping(value = "/user/contact_list")
	public String contactList(Model m, HttpSession httpSession) {

		Integer userId = (Integer) httpSession.getAttribute("userId");
		List<Contact> contactList = service.findUserContact(userId);

		m.addAttribute("contactList", contactList);

		return "contact_list";

	}

	@RequestMapping("/user/delete_contact/")
	public String deleteContact(@RequestParam("contactId") Integer contactId) {

		service.delete(contactId);

		return "redirect:/user/contact_list?act=del";
	}

	@RequestMapping("/user/update_contact/")
	public String updateContact(@RequestParam("contactId") Integer contactId, Model m, HttpSession httpSession) {

		httpSession.setAttribute("aContactId", contactId);

		Contact c = service.findById(contactId);

		m.addAttribute("contact", c);

		return "contact_form";
	}
	
	
	@RequestMapping(value = "/user/search_contact")
	public String searchContactList(Model m, HttpSession httpSession, @RequestParam("freeText") String freeText) {

		Integer userId = (Integer) httpSession.getAttribute("userId");
		
		List<Contact> contactList = service.findUserContact(userId, freeText);
		m.addAttribute("contactList", contactList);

		return "contact_list";

	}
	
	
	
	@RequestMapping("/user/bulk_delete")
	public String bulkDeleteContact(@RequestParam("contactId") Integer[] contactIds) {

		service.delete(contactIds);

		return "redirect:/user/contact_list?act=del";
	}

}
