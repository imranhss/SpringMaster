package org.idb.controller;

import javax.servlet.http.HttpSession;

import org.idb.entity.User;
import org.idb.entity.UserLogin;
import org.idb.entity.UserReg;
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
	public String login(@ModelAttribute("login") UserLogin ul, Model m, HttpSession httpSession) {
		try {
			User u = service.login(ul.getLoginName(), ul.getPassword());

			if (u == null) {

				m.addAttribute("err", "Login Failed, username or password is incorrect");
				return "home";
			} else {
				if (u.getRole() == IUserService.ROLE_ADMIN) {

					sessionInUser(u, httpSession);

					return "redirect:/admin/dashboard";

				} else if (u.getRole() == IUserService.ROLE_USER) {
					
					sessionInUser(u, httpSession);

					return "redirect:/user/dashboard";
				} else {

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

	public void sessionInUser(User u, HttpSession httpSession) {

		httpSession.setAttribute("user", u);
		httpSession.setAttribute("userId", u.getUserId());
		httpSession.setAttribute("role", u.getRole());

	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession httpSession) {
		
		httpSession.invalidate();
		
		return "redirect:/?act=lo";
	}
	
	@RequestMapping(value = "/reg_form")
	public String reg_form(Model m) {
		
		UserReg ur=new UserReg();
		
		m.addAttribute("registration", ur);		
		return "reg_form";
	}
		
	
	@RequestMapping(value = "/user_reg")
	public String userReg(@ModelAttribute("registration") UserReg ur, Model m) {
		
		User user=ur.getUser();
		
		user.setRole(IUserService.ROLE_USER);
		user.setUserStatus(IUserService.LOGIN_STATUS_ACTIVE);
		
		service.userRegister(user);		
			
		return "redirect:/?act=reg";
	}
	
	
}
