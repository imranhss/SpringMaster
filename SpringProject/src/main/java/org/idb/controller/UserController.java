package org.idb.controller;

import javax.servlet.http.HttpSession;

import org.idb.entity.User;
import org.idb.entity.UserLogin;
import org.idb.entity.UserReg;
import org.idb.exception.UserBlockException;
import org.idb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@Autowired
	IUserService service;

	@RequestMapping(value={"/index", "/"})
	public String index(Model m) {
		m.addAttribute("login", new UserLogin());
		
		return "index";
	} 
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String handle_login(@ModelAttribute("login") UserLogin ul, Model m, HttpSession httpSession) {
		
		try {
			User loginUser= service.login(ul.getLoginName(), ul.getPassword());
			
			if(loginUser==null) {
				m.addAttribute("err", "Login Failed enter valied user name and apssword");
				return "index"; //login form
			}
			else {
				if(loginUser.getRole()==IUserService.ROLE_ADMIN) {
					
					userInSession(loginUser, httpSession);
					
					return "redirect:/admin/dashboard";					
				}
				else if(loginUser.getRole()==IUserService.ROLE_USER) {
					userInSession(loginUser, httpSession);
					
					return "redirect:/user/dashboard";
					
				}
				else {
					m.addAttribute("err", "Invalied user Role");
					System.out.println("Error ");
					return "index"; //login form
				}
			}
		
		} catch (UserBlockException e) {
			// TODO Auto-generated catch block
			m.addAttribute("err", e.getMessage());
			return "index"; //login form
		}
	
	} 
	
	@RequestMapping(value={"/user/dashboard"})
	public String userDashboard() {
		
		
		return "dashboard_user";
	} 
	
	@RequestMapping(value={"/admin/dashboard"})
	public String adminDashboard() {
		
		
		return "dashboard_admin";
	} 
	
	@RequestMapping(value={"/logout"})
	public String logout(HttpSession session) {		
		session.invalidate();
		return "redirect:/?act=lo";  //query string  ?act=lo
	} 
	
	public void userInSession(User u, HttpSession session) {
		
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
		
	}
	@RequestMapping("/reg_form")
	public String registrationForm(Model m) {
		UserReg ur=new UserReg();	
		
		m.addAttribute("register", ur);
		return "reg_form";
	}
	
	@RequestMapping("/register")
	public String registration(@ModelAttribute("register") UserReg ur, Model m) {
		
		try {
			User user=ur.getUser();
			
			user.setRole(IUserService.ROLE_USER);
			user.setLoginStatus(IUserService.LOGIN_STATUS_ACTIVE);		
			service.userRegiter(user);	
			
			m.addAttribute("register", ur);
			return "redirect:/?act=reg";
		}
		catch (DuplicateKeyException e) {
			// TODO: handle exception
			e.printStackTrace();
			m.addAttribute("err", "Username is already registerd");
			return "redirect:/?act=reg reg_form";
			
		}
		
	}
	
	@RequestMapping(value={"/admin/users"})
	public String getUsersList(Model m) {
		m.addAttribute("userList", service.getUserList()) ;
		
		return "users";
	} 
	
	
}
