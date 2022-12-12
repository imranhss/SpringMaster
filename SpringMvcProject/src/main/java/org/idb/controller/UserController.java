package org.idb.controller;

import org.idb.entity.User;
import org.idb.entity.UserLogin;
import org.idb.exception.UserBlockException;
import org.idb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	IUserService service;

	@RequestMapping(value = { "/", "/index" })
	public String home(Model m) {

		m.addAttribute("title", "Login");
		m.addAttribute("login", new UserLogin());

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") UserLogin ul, Model m ) {
		try {
			User u = service.login(ul.getLoginName(), ul.getPassword());

			if (u == null) {

				m.addAttribute("err", "Login Failed, username or password is incorrect");
				return "home";
			} else {
				if (u.getRole() == IUserService.ROLE_ADMIN) {

					return "redirect:/admin/dashboard";
				}
				else if (u.getRole() == IUserService.ROLE_USER) {

					return "redirect:/user/dashboard";
				}
				else {
					
					m.addAttribute("err", "U r not authorised");
					return "redirect:/";	
				}

			}

		} catch (UserBlockException e) {
			// TODO Auto-generated catch block
			m.addAttribute("err", e.getMessage());
			return "home";
		}

		
	}

	@RequestMapping(value = "/user/dashboard")
	public String userDashboard() {

		return "user_dashboard";
	}

	@RequestMapping(value = "/admin/dashboard")
	public String adminDashboard() {

		return "admin_dashboard";
	}

}
